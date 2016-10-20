public class PoliceMotocycle extends Motocycle implements Police{
	private PType type;	
	private String ID;

	public PoliceMotocycle(int year,String colour,int wheel,int mspeed,String lic,float max_turn_angle,int power,float cons,String fuelt,PType type,String ID){
		super(year,colour,wheel,mspeed,lic,max_turn_angle,power,cons,fuelt);
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
