import java.util.*;

public class Staff{
	private Client cl;
	private int nif;
	private int nfunc;

	public Staff(String name,Date dinsc,Date dnasc,int cc,int nfunc,int nif){
		cl=new Client(name,dinsc,dnasc,cc);
		this.nif=nif;
		this.nfunc=nfunc;		
	}

	public int getId(){ return cl.getId();}
	public String getName(){ return cl.getName();}
	public Date getDateInsc(){ return cl.getDateInsc();}
	public Date getDateNasc(){ return cl.getDateNasc();}
	public int getCc(){ return cl.getCc();}
	public int getNFunc(){ return nfunc;}
	public int getNif(){ return nif;}

	@Override
	public String toString(){
		return "ID: "+cl.getId()+"\nName: "+cl.getName()+"\nRegistration date: "+cl.getDateInsc().toString()+"\nBirth date: "+cl.getDateNasc().toString()+"\nCC: "+cl.getCc()+"\nFunc nr: "+nfunc+"\nNIF: "+nif;
	}
}
