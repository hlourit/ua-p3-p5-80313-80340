import java.util.*;

public class Student{
	private Client cl;
	private int nmec;
	private int course;

	public Student(String name,Date dinsc,Date dnasc,int cc,int nmec,int course){
		cl=new Client(name,dinsc,dnasc,cc);
		this.nmec=nmec;
		this.course=course;		
	}

	public int getId(){ return cl.getId();}
	public String getName(){ return cl.getName();}
	public Date getDateInsc(){ return cl.getDateInsc();}
	public Date getDateNasc(){ return cl.getDateNasc();}
	public int getCc(){ return cl.getCc();}
	public int getNMec(){ return nmec;}
	public int getCourse(){ return course;}
	
	@Override
	public String toString(){
		return "ID: "+cl.getId()+"\nName: "+cl.getName()+"\nRegistration date: "+cl.getDateInsc().toString()+"\nBirth date: "+cl.getDateNasc().toString()+"\nCC: "+cl.getCc()+"\nMech nr: "+nmec+"\nCourse nr: "+course;
	}
}
