public class Bolseiro extends Estudante{
	private int bolsa=0;

	public Bolseiro(String nome,int cc,Data dataNasc,Data dataInsc,int bolsa){
		super(nome,cc,dataNasc,dataInsc);
		this.bolsa=bolsa;
	}
	public Bolseiro(String nome,int cc,Data dataNasc,int bolsa){
		super(nome,cc,dataNasc);
		this.bolsa=bolsa;
	}
	public Bolseiro(String nome,int cc,Data dataNasc){
		super(nome,cc,dataNasc);
	}
	public int getBolsa(){
		return bolsa;
	}
	public void setBolsa(int bolsa){
		this.bolsa=bolsa;
	}

	@Override
    public String toString(){
        return super.toString()+"\nBolsa: "+bolsa;
    }
    @Override
    public boolean equals(Object other){
        return super.equals(other)&&bolsa==((Bolseiro)other).getBolsa();
    }
}
