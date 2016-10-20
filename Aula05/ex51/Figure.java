/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public abstract class Figure implements Comparable<Figure> {
    private Ponto centro;
    
    public Figure(Ponto centro){
		this.centro=centro;
	}
    
    
    
    public abstract double area();
    public abstract double perimeter();
    @Override
    public abstract String toString();
    
    public Ponto centro(){
		return centro;
	}
	
	public void centro(Ponto p){
		this.centro=centro;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o==null)
			return false;
		if(this==o)
			return true;
		if(getClass()==o.getClass())
			return ((Figure)o).centro().equals(this.centro());
		return false;
	}
	
	@Override 
	public int compareTo(Figure t){
			return (int)(area()-t.area());
	}
}
