public class Professor extends Pessoa{
	private Data dataAdmissao;
	private int nfunc;
		
	public Professor(Data dataAdmissao,int nfunc,String nome,int cc,Data dataNasc){
		super(nome,cc,dataNasc);
		this.dataAdmissao=dataAdmissao;
		this.nfunc=nfunc;
	}
	public Professor(String nome,int cc,Data dataNasc){
		super(nome,cc,dataNasc);
		dataAdmissao=new Data(0,0,0);
		nfunc=0;
	}
	public void setNFunc(int nfunc){
		this.nfunc=nfunc;
	}
	public void setAdmissionDate(Data d){
		dataAdmissao=d;
	}
	public int getNFunc(){
		return nfunc;
	}
	public Data getDataAdmissao(){
		return dataAdmissao;
	}
	public String toString(){
		return super.toString()+"\nAdmision date: "+dataAdmissao.toString()+"\nFunc nr: "+nfunc;
	}
}
