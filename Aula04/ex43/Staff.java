import java.util.*;

public class Staff extends Client{
	private int nif;
	private int nfunc;

	public Staff(String name,Date dinsc,Date dnasc,int cc,int nfunc,int nif){
		super(name,dinsc,dnasc,cc);
		this.nif=nif;
		this.nfunc=nfunc;		
	}

	public int getNFunc(){ return nfunc;}
	public int getNif(){ return nif;}

	@Override
	public String toString(){
		return "ID: "+getId()+"\nName: "+getName()+"\nRegistration date: "+getDateInsc().toString()+"\nBirth date: "+getDateNasc().toString()+"\nCC: "+getCc()+"\nFunc nr: "+nfunc+"\nNIF: "+nif;
	}
}
