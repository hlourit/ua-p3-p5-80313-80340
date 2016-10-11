import java.util.*;

public class Student extends Client{
	private int nmec;
	private int course;

	public Student(String name,Date dinsc,Date dnasc,int cc,int nmec,int course){
		super(name,dinsc,dnasc,cc);
		this.nmec=nmec;
		this.course=course;		
	}

	public int getNMec(){ return nmec;}
	public int getCourse(){ return course;}
	
	@Override
	public String toString(){
		return "ID: "+getId()+"\nName: "+getName()+"\nRegistration date: "+getDateInsc().toString()+"\nBirth date: "+getDateNasc().toString()+"\nCC: "+getCc()+"\nMech nr: "+nmec+"\nCourse nr: "+course;
	}
}
