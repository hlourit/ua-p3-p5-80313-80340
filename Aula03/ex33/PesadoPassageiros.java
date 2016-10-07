/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class PesadoPassageiros extends Veiculo {
    private static final String tipo="Pesado de Passageiros";
    
    public PesadoPassageiros(int cilindrada,int lotacao,double potencia,double peso,Pessoa condutor){
        super(cilindrada,lotacao,potencia,peso,condutor);
    }
    
    @Override
    public String toString(){
        return "Tipo de veículo: "+tipo+"\n"+super.toString();
    }
    
    public String tipo(){
        return tipo;
    }
    //  
    // NÃO PRECISO DE OVERRIDE DA FUNÇÃO EQUALS PORQUE O ÚNICO ATRIBUTO DESTA SUBCLASSE É STATIC E FINAL
    //
}
