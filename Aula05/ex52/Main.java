import java.util.*;

public class Main{
	
	public static void main(String[] args){
		ArrayList<Vehicle> vehicles=new ArrayList<>();
		
		vehicles.add(((Vehicle)new PoliceMotocycle(2012,"Red",2,200,"12-PS-42",180.0f,100,3,"Petrol",PType.GNR,"Mota1")));
		vehicles.add(((Vehicle)new PoliceMotocycle(2042,"Blue",2,210,"13-PS-42",180.1f,120,3.4f,"Petrol",PType.GNR,"Mota2")));

		vehicles.add(((Vehicle)new PoliceCar(1997,"White",4,220,"13-PP-42","Camaro",300,3.4f,"Petrol",PType.GNR,"Carro1")));
		vehicles.add(((Vehicle)new PoliceCar(1990,"Black",3,100,"23-CP-69","Reliant Robin",90,5.4f,"Nightmare",PType.PJ,"Junk1")));

		vehicles.add(((Vehicle)new PoliceBicycle(2103,"Pink",2,300,10,5,PType.PJ,"Bike1")));
		vehicles.add(((Vehicle)new PoliceBicycle(213,"Grey",2,10,1,1,PType.INEM,"Bike2")));
		

		for(Vehicle v : vehicles)
			System.out.println(v);

		System.out.println("==================");
		Vehicle vh[]=vehicles.toArray(new Vehicle[vehicles.size()]);
		UtilCompare.sortArray(vh);
		
		for(Vehicle v : vh)
			System.out.println(v);
	}
}
