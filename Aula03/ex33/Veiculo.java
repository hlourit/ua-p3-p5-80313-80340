/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Veiculo {
    private int cilindrada,lotacao;
    private double potencia,peso;
    private Pessoa condutor;
    
    public Veiculo(int cilindrada,int lotacao,double potencia,double peso,Pessoa condutor){
        this.cilindrada=cilindrada;
        this.lotacao=lotacao;
        this.potencia=potencia;
        this.peso=peso;
        this.condutor=condutor;
                
    }
    
    public Pessoa condutor(){
        return condutor;
    }
    
    public void condutor(Pessoa condutor){
        this.condutor=condutor;
    }
    
    public int cilindrada(){
        return cilindrada;
    }
    
    public void cilindrada(int cilindrada){
        this.cilindrada=cilindrada;
    }
    
    public int lotacao(){
        return lotacao;
    }
    
    public void lotacao(int lotacao){
        this.lotacao=lotacao;
    }
    
    public double potencia(){
        return potencia;
    }
    
    public void potencia(double potencia){
        this.potencia=potencia;
    }
    
    public double peso(){
        return peso;
    }
    
    public void peso(double peso){
        this.peso=peso;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this==o)
            return true;
        if(getClass()!=o.getClass())
            return false;
        return condutor.equals(((Veiculo)o).condutor()) && cilindrada==((Veiculo)o).cilindrada() && lotacao==((Veiculo)o).lotacao() && potencia==((Veiculo)o).potencia() && peso==((Veiculo)o).peso();
    }
    
    @Override
    public String toString(){
        return "**Condutor e respetiva carta: "+condutor.nome()+", "+condutor.carta()+"\n**Cilindrada: "+cilindrada+"\n**Lotação: "+lotacao+"\n**Potência: "+potencia+"\n**Peso: "+peso+"\n";
    }
}
