/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class Word {
    private final String word;
    private final int l,c;
    boolean found;
    int dir;
    
    public Word(String word,int l, int c, boolean found, int dir){
        this.word=word;
        this.l=l;
        this.c=c;
        this.found=found;
        this.dir=dir;
    }
    
    public String word(){
        return word;
    }
    public int l(){
        return l;
    }
    public int c(){
        return c;
    }
}
