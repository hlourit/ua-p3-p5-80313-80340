
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

    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        Bitmap bmp = new Bitmap("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/Figura.bmp");
        System.out.println("1");
        bmp.printInfo();
        System.out.println("2");
        bmp.saveRawPPM("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/FiguraRaw.raw");
        System.out.println("3");
        bmp.resize1_4("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/FiguraR.bmp");
        System.out.println("4");
        bmp.flipV("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/FiguraFlipV.bmp");
        System.out.println("5");
        bmp.flipH("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex72/FiguraFlipH.bmp");
    }


    
    
    
    
}

