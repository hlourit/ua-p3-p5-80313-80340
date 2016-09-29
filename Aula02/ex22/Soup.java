/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;

/**
 *
 * @author Utilizador
 */
public class Soup {
    private final char[][] soup;
    private final LinkedList<String> words;
    
    public Soup(char[][] soup, LinkedList<String> words){
        this.soup=soup;
        this.words=words;
    }
    
    public char[][] soup(){
        return soup;
    }
    
    public LinkedList<String> words(){
        return words;
    }
    
    public String find(String tmp){
        Word tmpW=null;
        for(int l=0;l<soup.length;l++){
            for(int c=0;c<soup[0].length;c++){
                
                    tmpW=find(new Word(tmp,l,c,false,0),l,c,tmp.length());
                    if(tmpW.found)
                        break;
                
                
            }
            if(tmpW.found)
                break;
        }
        return "Word: "+tmp+" \n     Line: "+(tmpW.l()+1)+" Column: "+(tmpW.c()+1)+" Direction: "+decodeDir(tmpW.dir)+"\n";
    }
    
    private Word find(Word word,int l, int c,int left){
        if (left==0){
            word.found=true;
            return word;
        }
        if(word.word().charAt(word.word().length()-left)==soup[l][c]){
            switch(word.dir){
                case 0:
                    if(outOfBounds(l-1,c-1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l-1,c-1,left-1);
                case 1:
                    if(outOfBounds(l-1,c)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l-1,c,left-1);
                case 2:
                    if(outOfBounds(l-1,c+1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l-1,c+1,left-1);
                case 3:
                    if(outOfBounds(l,c+1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l,c+1,left-1);
                case 4:
                    if(outOfBounds(l+1,c+1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l+1,c+1,left-1);
                case 5:
                    if(outOfBounds(l+1,c)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l+1,c,left-1);
                case 6:
                    if(outOfBounds(l+1,c-1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l+1,c-1,left-1);
                case 7:
                    if(outOfBounds(l,c-1)){
                        word.dir+=1;
                        return find(word,word.l(),word.c(),word.word().length());
                    }else
                        return find(word,l,c-1,left-1);
            }
            
                         
            
        }else if(word.dir<8){
            word.dir+=1;
            return find(word,word.l(),word.c(),word.word().length());
        }
        return word;
        
    }
    
    private boolean outOfBounds(int l, int c){
        return !(l>=0 && l<soup.length && c>=0 && c<soup[0].length);
    }
    
    private String decodeDir(int dir){
        switch(dir){
            case 0:
                return "upleft";
            case 1:
                return "up";
            case 2:
                return "upright";
            case 3:
                return "right";
            case 4:
                return "downright";
            case 5:
                return "down";
            case 6:
                return "downleft";
            case 7:
                return "left";
            
        }
        return "ERROR";
    }
    
}
