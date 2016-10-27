public class Peixe extends Alimento {
	private final TipoPeixe tipo;

	public Peixe(TipoPeixe v,double prtn,double cal,double pes){
		super(prtn,cal,pes);
		tipo=v;
	}
	
	public TipoPeixe tipo(){ return tipo;}

	@Override 
	public boolean equals(Object other){
		if(super.equals(other)){
			return ((Peixe) other).tipo().equals(tipo());
		}
		return false;
	}
	@Override 
	public int hashCode(){ 
		return super.hashCode()+tipo().ordinal()+145; 
	}
	@Override 
	public String toString(){
		return super.toString()+","+tipo.toString();
	}
}

