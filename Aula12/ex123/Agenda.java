import java.util.*;
import java.io.*;

public class Agenda{
	ArrayList<Entrada> ag = new ArrayList<>();
	ArrayList<IOagenda> io = new ArrayList<>();
	String dir;

	public Agenda(){ this("plugins");}

	public Agenda(String dir){
		Class<?> ioInterface;
		Class<?> tmp_class;
		this.dir=dir;
		try{
			ioInterface= IOagenda.class;

	
		for(String tmp : (new File(dir)).list()){
			try{
				if(tmp.split("\\.")[tmp.split("\\.").length-1].equals("class")){
					tmp_class=Class.forName(tmp.substring(0,tmp.lastIndexOf('.')));
	
					io.add((IOagenda)tmp_class.newInstance());
				}
			}
			catch(Exception e){e.printStackTrace();}
		}
		}catch(Exception e){e.printStackTrace();}
	}

	public void addEntrada(Entrada a){	
		ag.add(a);
	}
	public void addEntradas(File a){
		Agenda tmp=null;
		for(IOagenda b : io){
			try{
				tmp=b.readFile(a);
				break;
			}catch(Exception e){}		
		}
		if(tmp!=null){
			for(Entrada e : tmp.toArray())
				ag.add(e);
		}
	}
	public Entrada[] toArray(){
		return ag.toArray(new Entrada[ag.size()]);
	}
	@Override
	public String toString(){
		return ag.toString();
	}
}
