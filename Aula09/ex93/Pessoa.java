public class Pessoa{
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome,int cc,Data dataNasc){
		this.nome=nome;
		this.cc=cc;
		this.dataNasc=dataNasc;
	}	
	public String getNome(){
		return nome;
	}
	public int getCc(){
		return cc;
	} 
	public Data getBData(){
		return dataNasc;
	}
	@Override
	public String toString(){
		return "Name: "+nome+"\nCC: "+cc+"\nBirth Date: "+dataNasc.toString();
	}
	@Override
	public boolean equals(Object other){
		Pessoa otherp;
		if(other==null) return false;
		if(other==this) return true;
		if(this.getClass()!=other.getClass()) return false;
		otherp=(Pessoa) other;
		if(!nome.equals(otherp.getNome())) return false;
		if(cc!=otherp.getCc()) return false;	
		if(dataNasc!=otherp.getBData()) return false;	
		return true;
	}
}
