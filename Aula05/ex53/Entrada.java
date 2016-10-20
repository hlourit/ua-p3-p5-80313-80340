import java.util.*;
import java.text.*;

public class Entrada{

	private String name;
	private int num;
	private Date birth;

	public Entrada(String name,int num,Date birth){
		this.name=name;
		this.num=num;
		this.birth=birth;
	}

	public String getName(){return name;}
	public int getNum(){return num;}
	public Date getBirthD(){return birth;}

	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return name+","+num+","+df.format(birth);
	}
}
