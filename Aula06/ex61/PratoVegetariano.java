import java.util.*;

public class PratoVegetariano extends Prato implements Vegetariano{

	public PratoVegetariano(String nome){
		super(nome);
	}

	@Override
	public boolean addIngrediente(Alimento al){
		if(al instanceof Vegetariano)
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
	
}
