public class Car extends Vehicle implements Motorized{
    private String lic_nr;
	private String model;
	private int power;
	private float cons;
	private String fuelt;

    public Car(int year,String colour,int wheel,int mspeed,String lic,String model,int power,float cons,String fuelt){
		super(year,colour,wheel,mspeed);
		lic_nr=lic;
		this.model=model;
		this.power=power;
		this.cons=cons;
		this.fuelt=fuelt;
	}

	public String getLicenseNr(){ return lic_nr;}
	public String getModel(){ return model;}
	
	public int getPower(){ return power;}
	public float getConsumption(){ return cons;}
	public String getFuelType(){ return fuelt;}

	@Override
	public String toString(){
		return super.toString()+","+lic_nr+","+model+","+power+","+cons+","+fuelt;
	}
}
