
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;

class Bitmap {
    String bitmapPath;
    BitmapFileHeader bitmapFileHeader=new BitmapFileHeader(); 
    BitmapInfoHeader bitmapInfoHeader= new BitmapInfoHeader();
    byte[] rgbQuad;
    byte[] data;
    
    
    public Bitmap(String path) throws IOException{
        bitmapPath=path;
        RandomAccessFile file=new RandomAccessFile(bitmapPath,"rw");
        bitmapFileHeader.type = Short.reverseBytes(file.readShort());
        bitmapFileHeader.size = Integer.reverseBytes(file.readInt());
        bitmapFileHeader.reserved1 = 0;
        bitmapFileHeader.reserved2 = 0;
        file.seek(0xA);
        bitmapFileHeader.offBits = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.size = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.width = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.height = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.planes = Short.reverseBytes(file.readShort());
        bitmapInfoHeader.bitCount = Short.reverseBytes(file.readShort());
        bitmapInfoHeader.compression = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.sizeImage = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.xPelsPerMeter = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.yPelsPerMeter = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.clrUsed = Integer.reverseBytes(file.readInt());
        bitmapInfoHeader.clrImportant = Integer.reverseBytes(file.readInt());
        if (bitmapInfoHeader.compression != 0) {
            System.err.print("O ficheiro não está na compressão desejada! (=0)\n");
        }
        data = new byte[(int)(file.length()-bitmapFileHeader.offBits)];
        file.seek(bitmapFileHeader.offBits);
        file.read(data);
        file.close();
        
    }
    
    public void printInfo() throws IOException {
        System.out.printf("Ficheiro de imagem:\n\tNúmero de linhas: %d\n\tNúmero de colunas: %d\n\tNúmero de cores: %d\n", Math.abs(bitmapInfoHeader.height), bitmapInfoHeader.width, numberOfColors());
    }
    
    public int getWidth(){
        return bitmapInfoHeader.width;
    }
    
    
    public int getHeight(){
        return bitmapInfoHeader.height;
    }
    
    
    public byte[] getPixelData(){
        return data;
    }
    
    private static class Color {

        byte B, G, R;
        
        private Color(byte b,byte g,byte r){
            R=r;
            G=g;
            B=b;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) 
                return false;
            if (o == this) 
                return true;
            return hashCode() == ((Color) o).hashCode();
        }

        @Override
        public int hashCode() {
            return this.B * 1000000 + this.G * 1000 + this.R;
        }
    }
    
    private int numberOfColors() throws IOException {

        HashSet<Color> colors = new HashSet<>();

        for (int y=0;y<Math.abs(bitmapInfoHeader.height);y++) 
            for(int x=0;x<bitmapInfoHeader.width;x++)
                colors.add(getColor(x,y));
            
        
        return colors.size();
    }
    
    
    private Color getColor(int x,int y) throws IOException{
        assert x<bitmapInfoHeader.width && y<Math.abs(bitmapInfoHeader.height);
        int pos = y*(bitmapInfoHeader.width*3 + (bitmapInfoHeader.width%4))+x*3;
        RandomAccessFile file=new RandomAccessFile(bitmapPath,"rw");
        file.seek(bitmapFileHeader.offBits+pos);
        Color color=new Color(file.readByte(),file.readByte(),file.readByte());
        file.close();
        return color;
    }
    
    public void saveRawPPM(String finalPath) throws IOException{
        
        RandomAccessFile fileR = new RandomAccessFile(finalPath, "rw");
        for(int x=0;x<bitmapInfoHeader.width;x++)
            for(int y=0;y<Math.abs(bitmapInfoHeader.height);y++){
                Color c=getColor(x,y);
                fileR.write(c.R);
                fileR.write(c.G);
                fileR.write(c.B);
            }
        fileR.close();
    }
    
    private Color[][] dataToColorMatrix(){
        Color[][] tmp=new Color[bitmapInfoHeader.width][Math.abs(bitmapInfoHeader.height)];
        int i=0;
        for(int y=0;y<tmp[0].length;y++){
            for(int x=0;x<tmp.length;x++){
                tmp[x][y]=new Color(data[i++],data[i++],data[i++]);
            }
        }
        return tmp;
    }
    public void resize1_4(String destination)throws IOException{
        RandomAccessFile file=new RandomAccessFile(destination,"rw");
        file.writeShort(Short.reverseBytes(bitmapFileHeader.type));
        file.writeInt(Integer.reverseBytes(bitmapFileHeader.offBits+bitmapInfoHeader.sizeImage/4));
        file.writeShort(0);
        file.writeShort(0);
        file.writeInt(Integer.reverseBytes(bitmapFileHeader.offBits));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.size));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.width/2));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.height/2));
        file.writeShort(Short.reverseBytes(bitmapInfoHeader.planes));
        file.writeShort(Short.reverseBytes(bitmapInfoHeader.bitCount));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.compression));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.sizeImage/4));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.xPelsPerMeter));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.yPelsPerMeter));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.clrUsed));
        file.writeInt(Integer.reverseBytes(bitmapInfoHeader.clrImportant));
        
        Color[][] cores=dataToColorMatrix();
        int last_Y=0;
        for(int y=0;y<cores[0].length;y=y+2)
            for(int x=0;x<cores.length;x=x+2){
                if(last_Y!=y){
                    for(int i=0;i<(bitmapInfoHeader.width/2)%4;i++)
                        file.write(0);
                }
                file.write(cores[x][y].B);
                file.write(cores[x][y].G);
                file.write(cores[x][y].R);
                last_Y=y;
            }
        file.close();
        
    }
    
    public void flipV(String destination) throws IOException{
        RandomAccessFile file = new RandomAccessFile(destination, "rw");
        RandomAccessFile fileSrc = new RandomAccessFile(bitmapPath, "rw");
        byte[] header =new byte[bitmapFileHeader.offBits];
        fileSrc.read(header);
        fileSrc.close();
        file.write(header);
        
        Color[][] cores=dataToColorMatrix();
        int last_Y=0;
        for(int y=0;y<cores[0].length;y++)
            for(int x=cores.length-1;x>=0;x--){
                if(last_Y!=y){
                    for(int i=0;i<(bitmapInfoHeader.width)%4;i++)
                        file.write(0);
                }
                file.write(cores[x][y].B);
                file.write(cores[x][y].G);
                file.write(cores[x][y].R);
                last_Y=y;
            }
        file.close();
        
    }
    
    public void flipH(String destination) throws IOException{
        RandomAccessFile file = new RandomAccessFile(destination, "rw");
        RandomAccessFile fileSrc = new RandomAccessFile(bitmapPath, "rw");
        byte[] header =new byte[bitmapFileHeader.offBits];
        fileSrc.read(header);
        fileSrc.close();
        file.write(header);
        
        Color[][] cores=dataToColorMatrix();
        int last_Y=0;
        for(int y=cores[0].length-1;y>=0;y--)
            for(int x=0;x<cores.length;x++){
                if(last_Y!=y){
                    for(int i=0;i<(bitmapInfoHeader.width)%4;i++)
                        file.write(0);
                }
                file.write(cores[x][y].B);
                file.write(cores[x][y].G);
                file.write(cores[x][y].R);
                last_Y=y;
            }
        file.close();
        
    }
}
