import java.util.*;

public class Agenda{
	ArrayList<Entrada> ag = new ArrayList<>();

	public void addEntrada(Entrada a){
		ag.add(a);
	}
	public Entrada[] toArray(){
		return ag.toArray(new Entrada[ag.size()]);
	}
	@Override
	public String toString(){
		return ag.toString();
	}
}
