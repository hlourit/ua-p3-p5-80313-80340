
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class Figure {
    private Ponto centro;
    
    public Figure(Ponto centro){
        this.centro=centro;
    }
    
    public Ponto centro(){
        return centro;
    }
    
    public Ponto centro(Ponto new_centro){
        centro=new_centro;
        return centro;
    }
    
    public double area(){
        return 0;
    }
    public double perimetro(){
        return 0;
    }
    @Override
    public String toString(){
        return"Figura; Centro: "+centro.x()+";"+centro.y();
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this==o)
            return true;
        if(getClass()!=o.getClass())
            return false;
        return centro.equals(((Figure)o).centro());
    }
}
