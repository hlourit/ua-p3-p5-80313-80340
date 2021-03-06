
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class Ponto {
    private final double x,y;
    
    public Ponto(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    public double x(){
        return x;
    }
    
    public double y(){
        return y;
    }
    
    public static double dist(Ponto p1,Ponto p2){
        double x =p1.x()-p2.x(),y=p1.y()-p2.y();
        return Math.sqrt(x*x+y*y);
    }
    
    @Override
    public String toString(){
        return "Ponto: ("+x+";"+y+")\n";
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this==o)
            return true;
        if(getClass()!=o.getClass())
            return false;
        return x==((Ponto)o).x() && y==((Ponto)o).y();
    }
}
