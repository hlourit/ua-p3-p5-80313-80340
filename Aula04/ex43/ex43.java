import java.util.*;
import java.text.*;

public class ex43{
	
	private static MovieProvider mov_man = new MovieProvider(1);
	private static Scanner sc = new Scanner(System.in);

	private static int serveMenu(){
		System.out.printf("\n1-Add Student\n2-Add Staff\n");
		System.out.printf("3-Add Movie\n");
		System.out.printf("4-Remove Client\n5-Remove Movie\n");
		System.out.printf("6-List Students\n7-List Staff\n");
		System.out.printf("8-List Movies (ordered by rating)\n9-List Client history\n");
		System.out.printf("10-Checkout Movie\n11-Checkin Movie\n");
		System.out.printf("0-Exit\n");
		try{
			return Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
			return -1;
		}
	}
	private static void addStudent() throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String name;
		Date dnasc;
		int cc,nmec,course;
		try{
			System.out.printf("\nName:");		
			name=sc.nextLine();
			System.out.printf("\nDate of birth (DD/MM/YYYY):");		
			dnasc=df.parse(sc.nextLine());
			System.out.printf("\nNational identification number:");		
			cc=Integer.parseInt(sc.nextLine());
			System.out.printf("\nMechanography number:");		
			nmec=Integer.parseInt(sc.nextLine());
			System.out.printf("\nCourse number:");		
			course=Integer.parseInt(sc.nextLine());
			mov_man.addStudent(new Student(name,new Date(),dnasc,cc,nmec,course));
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		return;
	}
	private static void addStaff() throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String name;
		Date dnasc;
		int cc,nfunc,nif;
		try{
			System.out.printf("\nName:");		
			name=sc.nextLine();
			System.out.printf("\nDate of birth (DD/MM/YYYY):");		
			dnasc=df.parse(sc.nextLine());
			System.out.printf("\nNational identification number:");		
			cc=Integer.parseInt(sc.nextLine());
			System.out.printf("\nStaff number:");		
			nfunc=Integer.parseInt(sc.nextLine());
			System.out.printf("\nFiscal id:");		
			nif=Integer.parseInt(sc.nextLine());
			mov_man.addStaff(new Staff(name,new Date(),dnasc,cc,nfunc,nif));
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		return;
	}
	private static void addMovie(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String name,rate,genre;
		try{
			System.out.printf("\nName:");		
			name=sc.nextLine();
			System.out.printf("\nAge Rating:"); 
			rate=sc.nextLine();
			System.out.printf("\nGenre:");		
			genre=sc.nextLine();
			mov_man.addMovie(new Movie(name,rate,genre));
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		return;
	}
	private static void removeClient(){
		int id;
		String name;
		try{
			System.out.printf("\nUnique ID:");		
			id=Integer.parseInt(sc.nextLine());
			name=mov_man.removeClient(id);
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		if(name==null)
			System.out.printf("No one was found with that ID.\n");
		else
			System.out.printf("\"%s\" was removed.\n",name);
		return;
	}
	private static void removeMovie(){
		int id;
		String name;
		try{
			System.out.printf("\nUnique ID:");		
			id=Integer.parseInt(sc.nextLine());
			name=mov_man.removeMovie(id);
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		if(name==null)
			System.out.printf("No one was found with that ID.\n");
		else
			System.out.printf("\"%s\" was removed.\n",name);
		return;
	}
	private static void checkInMovie(){
		int movId,rating;
		try{
			System.out.printf("\nUnique movie ID:");		
			movId=Integer.parseInt(sc.nextLine());
			System.out.printf("\nMovie rating (1-10):");		
			rating=Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		if(mov_man.checkInMovie(movId,rating))
			System.out.printf("Sucesss.\n");
		else
			System.out.printf("Fail.\n");
		return;

	}
	private static void checkOutMovie(){
		int clId,movId,result;
		try{
			System.out.printf("\nUnique client ID:");		
			clId=Integer.parseInt(sc.nextLine());
			System.out.printf("\nUnique movie ID:");		
			movId=Integer.parseInt(sc.nextLine());
			result=mov_man.checkOutMovie(movId,clId);
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		if(result==0)
			System.out.printf("Sucess.\n");
		else if(result==-1)
			System.out.printf("Invalid client or movie.\n");
		else if(result==-2)
			System.out.printf("Movie is not available.\n");
		else if(result==-3)
			System.out.printf("Client reached maximum requests.\n");
		return;
	}
	private static void clientHist(){
		int clId;
		String str;
		try{
			System.out.printf("\nUnique client ID:");
			clId=Integer.parseInt(sc.nextLine());
			str=mov_man.clientRequestHistToString(clId);
		}
		catch(Exception e){
			System.out.printf("\nInput mismatch.\n");
			return;
		}
		if(str!=null){
			System.out.printf("\n"+str+"\n");
			return;
		}
		else{
			System.out.printf("No such client with that ID.\n");
			return; 
		}
	}
	public static void main(String[] args) throws ParseException{
		int option;
		do{
			option=serveMenu();
			switch(option){
				case 1:
					addStudent();				
					break;
				case 2:
					addStaff();				
					break;
				case 3:
					addMovie();
					break;
				case 4:
					removeClient();
					break;
				case 5:
					removeMovie();
					break;
				case 6:
					System.out.printf("\n"+mov_man.studentsToString()+"\n");
					break;
				case 7:
					System.out.printf("\n"+mov_man.staffsToString()+"\n");
					break;
				case 8:
					mov_man.sortMoviesRating();
					System.out.printf("\n"+mov_man.moviesToString()+"\n");
					break;
				case 9:
					clientHist();
					break;
				case 10:
					checkOutMovie();
					break;
				case 11:
					checkInMovie();
					break;
			}
		}while(option!=0);		
		return;
	}
}
