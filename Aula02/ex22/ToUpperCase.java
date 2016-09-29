/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class ToUpperCase {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File(args[0]);
        Scanner read = new Scanner(file);
        PrintWriter write = new PrintWriter(file);
        boolean aindaNaoChegouAoQueEuNaoQueroMexer=true;
        while(read.hasNextLine()){
            String tmp=read.nextLine();
            if(tmp.trim().equals("pararprograma"))
                aindaNaoChegouAoQueEuNaoQueroMexer=false;
            if(aindaNaoChegouAoQueEuNaoQueroMexer){
                String tmp3="";
                for(String tmp2 : tmp.split("[ \\s+ ]")){
                    tmp3+=tmp2;
                }
                tmp=tmp3;
                write.println(tmp.toUpperCase());
            }else
                write.println(tmp);
            
        }
        write.close();
    }
    
}
