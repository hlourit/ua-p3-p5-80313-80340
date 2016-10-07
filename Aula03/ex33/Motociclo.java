/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Motociclo extends Veiculo {
    private static final String tipo="Motociclo";
    
    public Motociclo(int cilindrada,double potencia,double peso,Pessoa condutor){
        super(cilindrada,2,potencia,peso,condutor);
    }
    
    public Motociclo(int cilindrada,double potencia,double peso,Pessoa condutor, String mercadoria){
        super(cilindrada,2,potencia,peso,condutor);
    }
    
    @Override
    public String toString(){
        return "Tipo de veículo: "+tipo+"\n"+super.toString();
    }
    
    public String tipo(){
        return tipo;
    }
    //  
    // NÃO PRECISO DE FAZER OVERRIDE À FUNÇÃO EQUALS PORQUE O ÚNICO ATRIBUTO DESTA SUBCLASSE É STATIC E FINAL
    //
}