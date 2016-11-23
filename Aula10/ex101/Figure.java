
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
