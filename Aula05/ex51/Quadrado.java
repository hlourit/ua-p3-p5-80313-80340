
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Quadrado extends Figure {
    private double lado;
    
    public Quadrado(double x,double y, double lado){
        super(new Ponto(x,y));
        this.lado=lado;
    }
    
    public Quadrado(double lado){
        super(new Ponto(0,0));
        this.lado=lado;
    }
    
    public Quadrado(Quadrado q){
        super(q.centro());
        this.lado=q.lado();
    }
    
    public double lado(){
        return lado;
    }
    
    @Override
    public double area(){
        return Math.pow(lado, 2);
    }
    
    @Override
    public double perimeter(){
       return 4*lado; 
    }
    
    @Override
    public String toString(){
        return "Quadrado; Centro: "+centro().x()+";"+centro().y()+"; Lado: "+lado+"; Area: "+area()+"; Perímetro: "+perimeter()+";";
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o)&&((Quadrado)o).lado()==lado;
    }
}
