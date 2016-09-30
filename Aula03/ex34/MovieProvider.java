import java.util.*;

public class MovieProvider{
	ArrayList<Movie> movies = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Staff> staffs = new ArrayList<>();
	int maxActiveReq;
	
	public MovieProvider(int i){
		maxActiveReq=i;
	}
	
	private int getMovieWithId(int id){
		for(int i=0;i<movies.size();i++)
			if(movies.get(i).getId()==id)
				return i;
		return -1;
	}
	private int getStudentWithId(int id){
		for(int i=0;i<students.size();i++)
			if(students.get(i).getId()==id)
				return i;
		return -1;
	}
	private int getStaffWithId(int id){
		for(int i=0;i<staffs.size();i++)
			if(staffs.get(i).getId()==id)
				return i;
		return -1;
	}
	public boolean clientExists(int id){
		return getStudentWithId(id)!=-1||getStaffWithId(id)!=-1;
	}
	public boolean checkInMovie(int movId,int rating){
		int index=getMovieWithId(movId);
		if(index!=-1){
			if(!movies.get(index).isRequested()||rating>10||rating<1) return false;
			movies.get(index).checkIn(rating);
			return true;
		}
		return false;
	}
	public int checkOutMovie(int movId,int clId){
		int valid=nrOfRequested(clId);
		int index=getMovieWithId(movId);
		
		if(valid!=-1&&index!=-1){
			if(movies.get(index).isRequested()) return -2;
			if(valid>=maxActiveReq) return -3;
			movies.get(index).checkOut(clId);
			return 0;
		}
		
		return -1;
	}
	public void addMovie(Movie m){
		movies.add(m);
	}
	public String removeMovie(int id){
		int index=getMovieWithId(id);
		if(index!=-1)
			return movies.remove(index).getName();		
		return null;
	}
	public void addStudent(Student st){
		students.add(st);
	}
	public void addStaff(Staff st){
		staffs.add(st);
	}
	public String removeClient(int id){
		int index=getStudentWithId(id);
		if(index!=-1){
			return students.remove(index).getName();
		}
		index=getStaffWithId(id);
		if(index!=-1){
			return staffs.remove(index).getName();
		}
		return null;
	}
	public void sortMoviesRating(){ movies.sort(compareRating);}
	public int nrOfRequested(int id){
		int acc=0;
		Movie tmp_mov;
		if(clientExists(id)){
			for(int i=0;i<movies.size();i++){
				tmp_mov=movies.get(i);
				if(tmp_mov.getLastRequester()==id&&tmp_mov.isRequested())
					acc++;
			}
			return acc;
		}
		return -1;
	}
	public String clientRequestHistToString(int id){
		Movie tmp_mov;
		int occ;
		String str="";
		if(clientExists(id)){
			for(int i=0;i<movies.size();i++){
				tmp_mov=movies.get(i);
				occ=tmp_mov.clientHist(id);	
				if(occ!=0)
					str+="("+tmp_mov.getId()+") "+tmp_mov.getName()+" "+occ+"x\n";
			}
			return str;
		}
		return null;
	}
	public String moviesToString(){
		String tmp="-----\n";
		for(Movie m : movies){
			tmp+=m.toString()+"\n-----\n";
		}
		return tmp;	
	}
	public String studentsToString(){
		String tmp="-----\n";
		for(Student s: students){
			tmp+=s.toString()+"\n-----\n";
		}
		return tmp;	
	}
	public String staffsToString(){
		String tmp="-----\n";
		for(Staff s : staffs){
			tmp+=s.toString()+"\n-----\n";
		}
		return tmp;	
	}
	private static Comparator<Movie> compareRating = new Comparator<Movie>() {

		@Override
		public int compare(Movie m1,Movie m2){
			return m2.getRating()-m1.getRating();
		}
	};
}
