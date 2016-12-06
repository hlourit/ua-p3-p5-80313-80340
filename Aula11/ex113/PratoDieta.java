import java.util.*;

public class PratoDieta extends Prato {
	
	private final double cal_lim;

	public PratoDieta(String nome,double calm){
		super(nome);
		cal_lim=calm;
	}

	@Override
	public boolean addIngrediente(Alimento al){
		if(caloriasTot()+al.calorias()<=cal_lim)
			return super.addIngrediente(al);
		return false;
	}

	@Override 
	public boolean equals(Object other){
		if(other==null) return false;
		if(other.getClass()!=getClass()) return false;
		Prato p = (Prato) other;
		return p.nome().equals(nome())&&Arrays.equals(p.alimentos(),alimentos());
	}
	@Override 
    public int hashCode(){ 
        return super.hashCode()+(int)cal_lim; 
    }
	@Override 
	public String toString(){
		return super.toString()+","+cal_lim;
	}
}
