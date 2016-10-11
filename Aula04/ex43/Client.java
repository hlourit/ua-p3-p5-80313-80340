import java.util.*;

public class Client{
	private static int nextid=0;
	
	private final int id;
	private String name;
	private Date dinsc;	
	private Date dnasc;	
	private int cc;

	public Client(String name,Date dinsc,Date dnasc,int cc){
		id=nextid++;	
		this.name=name;
		this.dinsc=dinsc;
		this.dnasc=dnasc;
		this.cc=cc;
	}

	public int getId(){ return id;}
	public String getName(){ return name;}
	public Date getDateInsc(){ return dinsc;}
	public Date getDateNasc(){ return dnasc;}
	public int getCc(){ return cc;}
}
