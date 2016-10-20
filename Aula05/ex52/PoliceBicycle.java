public class PoliceBicycle extends Bicycle implements Police{
	private PType type;	
	private String ID;

	public PoliceBicycle(int year,String colour,int wheel,int mspeed,int fgear,int bgear,PType type,String ID){
		super(year,colour,wheel,mspeed,fgear,bgear);
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
