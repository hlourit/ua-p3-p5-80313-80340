

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Carta {
    private final String tipo;
    
    public Carta(String tipo){
        this.tipo=tipo;
    }
    
    public String tipo(){
        return tipo;
    }
    
    @Override
    public String toString(){
        return "Carta tipo "+tipo;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this==o)
            return true;
        if(!(getClass()==o.getClass()))
            return false;
        return tipo.equals(((Carta) o).tipo());
    }
}
