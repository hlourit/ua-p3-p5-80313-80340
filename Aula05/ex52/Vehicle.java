import java.util.*;

public abstract class Vehicle implements Comparable<Vehicle>{
	private int year;
	private String base_colour;
	private int wheel_cnt;
	private int max_speed;	
	
	public Vehicle(int year,String colour,int wheel,int mspeed){
		this.year=year;
		base_colour=colour;
		wheel_cnt=wheel;
		max_speed=mspeed;
	}
	
	public int getYear(){ return year;}
	public String getBaseColour(){ return base_colour;}
	public int getNrWheels(){ return wheel_cnt;}
	public int getMaxSpeed(){ return max_speed;}

	public int compareTo(Vehicle other) throws NullPointerException{
		if(other==null) throw new NullPointerException();
		return year-other.getYear();
	}
	@Override
	public String toString(){
		return "=>"+year+","+base_colour+","+wheel_cnt+","+max_speed;
	}
}
