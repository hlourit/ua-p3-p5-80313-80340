public class Carne extends Alimento{
	
	private final VariedadeCarne variedade;
	
	public Carne(VariedadeCarne v,double prtn,double cal,double pes){
		super(prtn,cal,pes);
		variedade=v;
	}
	
	public VariedadeCarne variedade(){ return variedade;}		

	@Override 
	public boolean equals(Object other){
		if(super.equals(other)){
			return ((Carne) other).variedade().equals(variedade());
		}
		return false;
	}
	@Override 
    public int hashCode(){ 
        return super.hashCode()+variedade().ordinal()+145; 
    }

	@Override 
	public String toString(){
		return super.toString()+","+variedade.toString();
	}
}
