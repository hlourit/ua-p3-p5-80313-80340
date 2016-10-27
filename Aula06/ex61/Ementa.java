import java.util.*;
import java.io.*;

public class Ementa implements Serializable{
	private Hashtable<DiaSemana,Prato> pratos;
	//private LinkedList<Prato> pratos;
	private String nome;
	private String local;
	
	public Ementa(String n,String l){
		pratos=new Hashtable<>();
		nome=n;
		local=l;
	}
	

	public String nome(){ return nome;}
	public String local(){ return local;}

	public void addPrato(Prato a,DiaSemana b){
		pratos.put(b,a);
	}
	public void removePrato(int index){
		pratos.remove(index);
	}
	public Prato[] pratos(){
		return pratos.values().toArray(new Prato[pratos.size()]);
	}

	@Override 
	public boolean equals(Object other){
		if(other==null) return false;
		if(other.getClass()!=getClass()) return false;
		Ementa e = (Ementa) other;
		return e.nome().equals(nome())&&e.local().equals(local())&&Arrays.equals(e.pratos(),pratos());
	}
	@Override 
    public int hashCode(){ 
        return super.hashCode()+pratos.hashCode()+nome.hashCode()+local.hashCode()>>2; 
    }
	@Override
	public String toString(){
		return nome+","+local+","+pratos.toString();
	}
}
