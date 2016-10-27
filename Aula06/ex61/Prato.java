import java.util.*;
import java.io.*;

public class Prato implements Comparable<Prato>,Serializable{
	private LinkedList<Alimento> alim;
	private String nome;

	public Prato(String nome){
		alim=new LinkedList<>();
		this.nome=nome;
	}
	
	public String nome(){return	nome;}

	public boolean addIngrediente(Alimento al){
		return alim.add(al);
	}
	public void removeIngrediente(int index){
		alim.remove(index);
	}
	public Alimento[] alimentos(){
		return alim.toArray(new Alimento[alim.size()]);
	}	
	public double caloriasTot(){
		double c=0f;
		for(Alimento a : alim) c+=a.calorias();
		return c;
	}
	@Override 
	public boolean equals(Object other){
		if(other==null) return false;
		if(other.getClass()!=getClass()) return false;
		Prato p = (Prato) other;
		return p.nome().equals(nome())&&Arrays.equals(p.alimentos(),alimentos());
	}
	@Override 
    public int hashCode(){ 
        return alim.hashCode()+nome().hashCode()+145; 
    }
	@Override
	public String toString(){
		return nome+","+alim.toString();
	}
	public int compareTo(Prato other){
		return (int)(caloriasTot()-other.caloriasTot()+0.5f); 
	}
}
