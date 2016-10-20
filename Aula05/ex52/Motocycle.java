public class Motocycle extends Vehicle implements Motorized{
    private String lic_nr;
	private float max_turn_angle;
	private int power;
	private float cons;
	private String fuelt;	

    public Motocycle(int year,String colour,int wheel,int mspeed,String lic,float max_turn_angle,int power,float cons,String fuelt){
		super(year,colour,wheel,mspeed);
		lic_nr=lic;
		this.max_turn_angle=max_turn_angle;
		this.power=power;
		this.cons=cons;
		this.fuelt=fuelt;		
	}

	public String getLicenseNr(){ return lic_nr;}
	public float getMaxTurnAngle(){ return max_turn_angle;}

	public int getPower(){ return power;}
	public float getConsumption(){ return cons;}
	public String getFuelType(){ return fuelt;}

	@Override
	public String toString(){
		return super.toString()+","+lic_nr+","+max_turn_angle+","+power+","+cons+","+fuelt;
	}
}
