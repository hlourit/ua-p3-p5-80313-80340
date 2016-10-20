public class Bicycle extends Vehicle{
	private int front_gear_count;
	private int back_gear_count;

    public Bicycle(int year,String colour,int wheel,int mspeed,int fgear,int bgear){
		super(year,colour,wheel,mspeed);
		front_gear_count=fgear;
		back_gear_count=bgear;
	}

	public int getFrontGearCount(){ return front_gear_count;}
	public int getBackGearCount(){ return back_gear_count;}

	@Override
	public String toString(){
		return super.toString()+","+front_gear_count+","+back_gear_count;
	}
}
