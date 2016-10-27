public class Cereal extends Alimento implements Vegetariano {
	String nome;
	
	public Cereal(String n,double prtn,double cal,double pes){
		super(prtn,cal,pes);
		nome=n;
	}

	public String nome(){ return nome;}

	@Override 
	public boolean equals(Object other){
		if(super.equals(other)){
			return ((Cereal) other).nome().equals(nome());
		}
		return false;
	}

	@Override 
    public int hashCode(){ 
        return super.hashCode()+nome().hashCode()+145; 
    }

}

