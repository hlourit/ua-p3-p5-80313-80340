/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class ex22 {
    public static void main(String[] args) throws FileNotFoundException {
        assert args.length==1;
        char[][] tmpGrid;
        LinkedList<String> tmpWordList=new LinkedList<String>();
            
        try{
            
            tmpGrid=getGridDimensions(args[0]);
            
            fill(tmpGrid,tmpWordList,args[0]);
            
            Soup soup=new Soup(tmpGrid,tmpWordList);
            
            for(int i=0;i<soup.words().size();i++){
                System.out.println(soup.find(soup.words().get(i).toUpperCase()));
            }
        }catch(FileNotFoundException e){
            System.err.printf("ERROR: The file \"%s\" was not found!\n",args[0]);
        }catch(IndexOutOfBoundsException e){
            System.err.println("ERROR: Invalid input for the program, please insert \"java ex22 file_name\", replacing file_name by the name of a file in the specified format.\n");
        }
        
        
    }
    
    private static char[][] getGridDimensions(String fileName) throws FileNotFoundException{
        Scanner read=null;
        int lines=1,columns=0;
        File file=new File(fileName);
        read=new Scanner(file);
        boolean stillInThePuzzle=true;
        columns=read.nextLine().length();
        do{
            String tmp=read.nextLine();
            char[] tmpCharArray = tmp.toCharArray();
            for(char tmpChar:tmpCharArray){
                if(Character.isLowerCase(tmpChar)){
                    stillInThePuzzle=false;
                    break;
                }
            }
            if(stillInThePuzzle)
                lines++;
            
        }while(stillInThePuzzle);
    return new char[lines][columns];
    }
    
    private static void fill(char[][] tmpGrid,LinkedList<String> tmpWordList,String filename) throws FileNotFoundException{
        Scanner read=new Scanner(new File(filename));
        for(int i=0;i<tmpGrid.length;i++){
            tmpGrid[i]=read.nextLine().toCharArray();
        }
        while(read.hasNextLine()){
            String tmp=read.nextLine();
            for(String word : tmp.split("[ , \\s+ ; ]")){
                if(word.length()>1){
                    tmpWordList.add(word.trim());
                }
            }
        }
        
    }
}
