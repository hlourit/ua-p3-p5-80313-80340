public class Legume extends Alimento implements Vegetariano{
	private String nome;

	public Legume(String n,double prtn,double cal,double pes){
		super(prtn,cal,pes);
		nome=n;
	}

	public String nome(){ return nome;}

	@Override 
	public boolean equals(Object other){
		if(super.equals(other)){
			return ((Legume) other).nome().equals(nome());
		}
		return false;
	}

	@Override 
    public int hashCode(){ 
        return super.hashCode()+nome().hashCode()+145; 
    }
	@Override 
	public String toString(){
		return super.toString()+","+nome;
	}
}
