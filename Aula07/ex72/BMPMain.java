
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manuel
 */
public class BMPMain {

    static class Color {

        byte B, G, R;
        
        public Color(byte b,byte g,byte r){
            R=r;
            G=g;
            B=b;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            return hashCode() == ((Color) o).hashCode();
        }

        @Override
        public int hashCode() {
            return this.B * 1000000 + this.G * 1000 + this.R;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomAccessFile file = new RandomAccessFile("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/Figura.bmp", "r");
        Bitmap bmp = fillBitmap(file);
        printBmpInfo(file,bmp);
        saveRaw(file,bmp);
    }

    private static Bitmap fillBitmap(RandomAccessFile file) throws IOException {
        Bitmap bmp = new Bitmap();
        bmp.bitmapFileHeader.type = Short.reverseBytes(file.readShort());
        bmp.bitmapFileHeader.size = Integer.reverseBytes(file.readInt());
        bmp.bitmapFileHeader.reserved1 = 0;
        bmp.bitmapFileHeader.reserved2 = 0;
        file.seek(0xA);
        bmp.bitmapFileHeader.offBits = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.size = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.width = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.height = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.planes = Short.reverseBytes(file.readShort());
        bmp.bitmapInfoHeader.bitCount = Short.reverseBytes(file.readShort());
        bmp.bitmapInfoHeader.compression = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.sizeImage = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.xPelsPerMeter = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.yPelsPerMeter = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.clrUsed = Integer.reverseBytes(file.readInt());
        bmp.bitmapInfoHeader.clrImportant = Integer.reverseBytes(file.readInt());
        if (bmp.bitmapInfoHeader.compression != 0) {
            System.err.print("O ficheiro não está na compressão desejada! (=0)\n");
        }
        bmp.data = new byte[(int)(file.length()-bmp.bitmapFileHeader.offBits)];
        file.seek(bmp.bitmapFileHeader.offBits);
        file.read(bmp.data);

        return bmp;

    }

    public static void printBmpInfo(RandomAccessFile file,Bitmap bmp) throws IOException {
        System.out.printf("Ficheiro de imagem:\n\tNúmero de linhas: %d\n\tNúmero de colunas: %d\n\tNúmero de cores: %d\n", -bmp.bitmapInfoHeader.height, bmp.bitmapInfoHeader.width, numberOfColors(file,bmp));
    }

    public static int numberOfColors(RandomAccessFile file,Bitmap bmp) throws IOException {

        HashSet<Color> colors = new HashSet<>();

        for (int x=0;x<bmp.bitmapInfoHeader.width;x++) {
            for(int y=0;y<-bmp.bitmapInfoHeader.height;y++){
                colors.add(getColor(file,bmp,x,y));
            }
        }
        return colors.size();
    }
    
    
    public static Color getColor(RandomAccessFile file, Bitmap bmp, int x,int y) throws IOException{
        assert x<bmp.bitmapInfoHeader.width && y<Math.abs(bmp.bitmapInfoHeader.height);
        int pos = y*(bmp.bitmapInfoHeader.width*3 + (bmp.bitmapInfoHeader.width%4))+x*3;
        file.seek(bmp.bitmapFileHeader.offBits+pos);
        Color color=new Color(file.readByte(),file.readByte(),file.readByte());
        return color;
    }
    
    public static void saveRaw(RandomAccessFile file,Bitmap bmp) throws FileNotFoundException, IOException{
        
        File fileRaw =new File("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/FiguraRaw.raw");
        RandomAccessFile fileR = new RandomAccessFile(fileRaw, "rw");
        fileR.write(bmp.data);
        fileR.close();
    }
    
}
