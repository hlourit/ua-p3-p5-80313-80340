import java.util.*;

public class Disciplina{
	private String name;
	private String area;
	private int ECTS;
	private Professor chief;
	private ArrayList<Estudante> students;	
	
	public Disciplina(String name,String area,int ects,Professor pf){
		this.name=name;
		this.area=area;
		ECTS=ects;
		chief=pf;
		students=new ArrayList<Estudante>();
	}
	
	public boolean addAluno(Estudante est){
		return students.add(est);
	}
	public boolean delAluno(int nmec){
		for(Estudante std : students)
			if(std.getNMec()==nmec)
				return students.remove(std);
		return false;
	}
	public boolean alunoInscrito(int nmec){
		for(Estudante std : students)
			if(std.getNMec()==nmec)
				return true;
		return false;
	}
	public int numAlunos(){
		return students.size();
	}
	public Estudante[] getAlunos(){
		return students.toArray(new Estudante[students.size()]);
	}
	public Estudante[] getAlunos(String type){
		ArrayList<Estudante> tmp=new ArrayList<Estudante>();
		for(Estudante std : students)
			if(std.getClass().getSimpleName().equals(type))
				tmp.add(std);
		return tmp.toArray(new Estudante[tmp.size()]);
	}

	@Override
	public String toString(){
		return "Name: "+name+"\nArea: "+area+"\nECTs: "+ECTS+"\nProfessor: "+chief.toString()+"\nStudents: "+students.toString();
	} 
}
