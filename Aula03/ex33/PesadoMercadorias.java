/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class PesadoMercadorias extends Veiculo {
    private static final String tipo="Pesado de Passageiros";
    private String mercadoria;
    
    public PesadoMercadorias(int cilindrada,int lotacao,double potencia,double peso,Pessoa condutor){
        super(cilindrada,lotacao,potencia,peso,condutor);
        mercadoria="indefinida";
    }
    
    public PesadoMercadorias(int cilindrada,int lotacao,double potencia,double peso,Pessoa condutor, String mercadoria){
        super(cilindrada,lotacao,potencia,peso,condutor);
        this.mercadoria=mercadoria;
    }
    
    @Override
    public String toString(){
        return "Tipo de veículo: "+tipo+"\n"+super.toString()+"**Mercadoria: "+mercadoria+"\n";
    }
    
    public String tipo(){
        return tipo;
    }
    
    public String mercadoria(){
        return mercadoria;
    }
    
    public void mercadoria(String mercadoria){
        this.mercadoria=mercadoria;
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o) && mercadoria.equals(((PesadoMercadorias)o).mercadoria());
    }
}
