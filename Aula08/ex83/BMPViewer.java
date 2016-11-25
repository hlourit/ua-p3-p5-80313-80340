
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BMPViewer extends JFrame {

    private File bmpPath = null;
    private final File bmpTempFile = new File("tmpBmp.bmp");
    private JLabel picLabel;

    public BMPViewer(String windowtitle) {
        super(windowtitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);
        mainPanel.setBackground(Color.white);
        JLabel top = new JLabel("Aguardando escolha de ficheiro...");
        add(top, BorderLayout.NORTH);
        JPanel lowerToolbar = new JPanel(new FlowLayout());
        add(lowerToolbar, BorderLayout.SOUTH);
        
        if(bmpTempFile.exists())
            bmpTempFile.deleteOnExit();
        
        //BUTTON FOR FILE CHOICE
        JButton b_filechoice = new JButton("Procurar...");
        b_filechoice.addActionListener(e
                                        -> {
                                            bmpPath = chooseFile();
                                            if (bmpPath != null) {
                                                top.setText(bmpPath.getName());
                                                try {
                                                    Files.copy(bmpPath.toPath(), bmpTempFile.toPath(), REPLACE_EXISTING);
                                                } catch (IOException ex) {
                                                    System.err.println(ex);
                                                    System.exit(0);
                                                }
                                                addImage(bmpPath);

                                            }
                                        });
        lowerToolbar.add(b_filechoice);

        
        //BUTTON TO FLIP VERT
        JButton b_flipV=new JButton("Rodar Vert.");
        b_flipV.addActionListener(e->edit(0));
        lowerToolbar.add(b_flipV);
        
        //BUTTON TO FLIP HORIZ
        JButton b_flipH=new JButton("Rodar Horiz.");
        b_flipH.addActionListener(e->edit(1));
        lowerToolbar.add(b_flipH);
        
        //BUTTON TO RESIZE
        JButton b_resize=new JButton("Diminuir");
        b_resize.addActionListener(e->edit(2));
        lowerToolbar.add(b_resize);
        
        //BUTTON TO SAVE
        JButton b_save = new JButton("Guardar");
        b_save.addActionListener(e->{
                                        if(bmpPath==null)
                                            return;
                                        int dialogResult = JOptionPane.showConfirmDialog(null, "Isto vai modificar permanentemente a tua imagem, queres prosseguir?","Aviso!",0,0);
                                        if(dialogResult == JOptionPane.YES_OPTION){
                                            try {
                                                Files.copy(bmpTempFile.toPath(),bmpPath.toPath(),REPLACE_EXISTING);
                                            } catch (IOException ex) {
                                                System.err.println(ex.getMessage());
                                                System.err.println(ex);
                                                System.exit(0);
                                            }
                                        }
                                    });
        lowerToolbar.add(b_save);
        
        //BUTTON TO SAVE AS
        JButton b_save_as =new JButton("Guardar como...");
        b_save_as.addActionListener(e->
                                        {
                                            String newPath = JOptionPane.showInputDialog(this, "Qual o nome com que quer guardar?","Guardar como...",1);
                                            if(newPath.equals("")){
                                                JOptionPane.showMessageDialog(this, "Não especificou o nome!","Erro!",0);
                                                return;
                                            }
                                            if(newPath==null)
                                                return;
                                            File dest=chooseSavingFile();
                                            if(dest==null)
                                                return;
                                            if(dest.getPath().charAt(0)=='/'){
                                                newPath=dest.getAbsolutePath()+"/"+newPath+".bmp";
                                            }else
                                                newPath=dest.getAbsolutePath()+"\\"+newPath+".bmp";
                                            try {
                                                Files.copy(bmpTempFile.toPath(), Paths.get(newPath),REPLACE_EXISTING);
                                            } catch (IOException ex) {
                                                System.err.println(ex.getMessage());
                                                System.exit(0);
                                            }
                                        });
        lowerToolbar.add(b_save_as);
        
        setVisible(true);
    }


    private File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "bmp");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile().getName().endsWith(".bmp")) {
                return chooser.getSelectedFile();
            }

            JOptionPane.showMessageDialog(this, "Formato inesperado, tente novamente!","Erro!",0);
            return chooseFile();
        }

        return null;

    }
    
    private File chooseSavingFile(){
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(bmpPath);
        chooser.setDialogTitle("Escolha a pasta de destino");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            return chooser.getSelectedFile();
        }
        else {
            return null;
        }
    }

    private void addImage(File bmpPath) {

        BufferedImage myPicture = null;

        try {
            myPicture = ImageIO.read(bmpPath);
            if(picLabel!=null){
                remove(picLabel); //removing last image
                
            }
            picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel, BorderLayout.CENTER);
            revalidate();
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
            System.exit(0);
        }
    }
    
    private void edit(int op) {
        if(bmpPath==null)
            return;
        try{
            Bitmap bmp=new Bitmap(bmpTempFile.getAbsolutePath());
        
            switch(op){
                case 0:
                    bmp.flipV(bmpTempFile.getAbsolutePath());
                    break;
                case 1:
                    bmp.flipH(bmpTempFile.getAbsolutePath());
                    break;
                default:
                    if(Math.abs(bmp.getHeight())<=10 || Math.abs(bmp.getWidth())<=10){
                        bmp=new Bitmap(bmpPath.getAbsolutePath());
                         Files.copy(bmpPath.toPath(), bmpTempFile.toPath(), REPLACE_EXISTING);
                        
                    }else
                        bmp.resize1_4(bmpTempFile.getAbsolutePath());
                    break;
            }
            
            addImage(bmpTempFile);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new BMPViewer("BMPViewer");
            }
        });
    }
}
