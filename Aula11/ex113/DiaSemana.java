public enum DiaSemana{
	Domingo(1),Segunda(2),Terça(3),Quarta(4),Quinta(5),Sexta(6),Sabado(7);
	private int num;
	private DiaSemana(int n){
		num=n;
	}
	
	public static DiaSemana rand(){
		return values()[((int)(Math.random()*7))];
	}
}
