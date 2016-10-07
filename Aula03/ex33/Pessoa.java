

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Pessoa {
   private Carta carta;
   private final Date dataNasc;
   private final String nome;
   
   public Pessoa(int d,int m,int a,String nome,String carta){
       this.carta=new Carta(carta);
       dataNasc=new Date(a, m, d);
       this.nome=nome;
       
   }
   
   public Pessoa(Date dataNasc, String nome, String carta){
       this.dataNasc=dataNasc;
       this.nome=nome;
       this.carta=new Carta(carta);
   }
   
   public String carta(){
       return carta.tipo();
   }
   
   
   public void carta(String tipo){
       carta=new Carta(tipo);
   }
   
   public Date dataNasc(){
       return dataNasc;
   }
   
   public String nome(){
       return nome;
   }
   
   @Override
   public boolean equals(Object o){
       if(o==null)
           return false;
       if(o==this)
           return true;
       if(getClass()!=o.getClass())
           return false;
       return carta.tipo().equals(((Pessoa)o).carta()) && dataNasc==((Pessoa)o).dataNasc() && nome.equals(((Pessoa)o).nome());
   }
   
   @Override
   public String toString(){
       return "**"+nome+"\n   Data de Nasc: "+dataNasc.toGMTString()+"\n    Carta: "+carta.tipo()+"\n";
   }
}
