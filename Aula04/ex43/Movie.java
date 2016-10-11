import java.util.*;

public class Movie{
	private static int nextid=0;
	
	private ArrayList<Integer> req_hist= new ArrayList<>();
	private boolean requested=false;	
	
	private int rating_sum,rating_nr;

	private final int id;
	private String name;
	private String rate;	
	private String genre;

	public Movie(String name,String age,String genre){
		id=nextid++;	
		this.name=name;
		this.rate=age;
		this.genre=genre;
	}

	public int clientHist(int id){
		int acc=0;
		for(int a : req_hist)
			if(a==id)
				acc++; 
		return acc;
	}
	public void checkOut(int ID){	
		requested=true;
		req_hist.add(ID);
	}
	public void checkIn(int rating){
		requested=false;
		rating_sum+=rating;
		rating_nr++;
	}
	public int getRating(){ return rating_sum;}
	public float getMeanRating(){
		if(rating_nr!=0) return (float) rating_sum/rating_nr;
		return 0f;
	}
	public boolean isRequested(){ return requested;}
	public int getLastRequester(){
		if(req_hist.size()>0) return req_hist.get(req_hist.size()-1);
		else return -1;
	}
	public int getId(){ return id;}
	public String getName(){ return name;}
	public String getRate(){ return rate;}
	public String getGenre(){ return genre;}

	@Override
	public String toString(){
		return "ID: "+id+"\nName: "+name+"\nRating: "+rate+"\nGenre: "+genre+"\nIs requested: "+requested+"\nRequest history: "+req_hist.toString()+"\nRating: "+rating_sum+"\nMean rating: "+getMeanRating();
	}
}
