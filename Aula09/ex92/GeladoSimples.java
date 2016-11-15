public class GeladoSimples implements Gelado{
	
	private String base;

	public GeladoSimples(String base){
		this.base=base;
	}

	@Override
	public void base(int i){
		if(i==1)
			System.out.printf("\n1 bola de gelado de %s ",base);
		else
			System.out.printf("\n%d bolas de gelado de %s ",i,base);
	}
}
