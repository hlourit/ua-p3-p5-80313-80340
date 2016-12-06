import java.io.*;

public class Alimento implements Serializable{
	private double proteinas,calorias,peso;
	
	public Alimento(double prtn,double cal,double pes){
		proteinas=prtn;
		calorias=cal;
		peso=pes;
	}
	
	public double proteinas(){
		return proteinas;
	}
	
	public double calorias(){
		return proteinas;
	}
	
	public double peso(){
		return proteinas;
	}

	@Override
	public boolean equals(Object other){
		if(other==null) return false;
		if(other.getClass()!=getClass()) return false;
		Alimento ot=(Alimento) other;
		return ot.proteinas()==proteinas()&&ot.calorias()==calorias()&&ot.peso()==peso();
	}
	@Override 
    public int hashCode(){ 
        int hash=203865092; 
        hash+=((int)proteinas()*100000)<<2; 
        hash+=((int)(calorias()*345))<<9; 
        hash+=((int)peso())<<5; 
        return hash>>2; 
    }
	@Override
	public String toString(){
		return ""+proteinas+","+calorias+","+peso;
	}
}
