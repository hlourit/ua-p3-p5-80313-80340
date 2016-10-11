public class Estudante extends Pessoa{
	public static int nextMec=100;
	private Data dataInsc;
	private int nMec;

	public Estudante(String nome,int cc,Data dataNasc,Data dataInsc){
		super(nome,cc,dataNasc);
		this.dataInsc=dataInsc;	
		nMec=nextMec++;
	}	
	public Estudante(String nome,int cc,Data dataNasc){
		super(nome,cc,dataNasc);
		dataInsc=Data.today();	
		nMec=nextMec++;
	}
	public Data getInscData(){
		return dataInsc;
	}
	public int getNMec(){
		return nMec;
	}
	@Override
	public String toString(){
		return super.toString()+"\nNmec: "+nMec+"\nDate of Insc: "+dataInsc.toString();
    }
	@Override
	public boolean equals(Object other){
		return super.equals(other)&&dataInsc.equals(((Estudante) other).getInscData())&&nMec==((Estudante) other).getNMec();	
	}
}
