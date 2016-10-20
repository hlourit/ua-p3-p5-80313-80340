public class PoliceCar extends Car implements Police{
	private PType type;	
	private String ID;

	public PoliceCar(int year,String colour,int wheel,int mspeed,String lic,String model,int power,float cons,String fuelt,PType type,String ID){
		super(year,colour,wheel,mspeed,lic,model,power,cons,fuelt);
		this.type=type;
		this.ID=ID;
	}	
	public PType getType(){ return type;}
	public String getID(){ return ID;}

	@Override
	public String toString(){
		return super.toString()+","+type+","+ID;
	}
}
