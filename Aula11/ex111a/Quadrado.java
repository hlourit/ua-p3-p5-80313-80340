
public class Quadrado extends Rectangulo {
    private double lado;
    
    public Quadrado(double x,double y, double lado){
        super(x,y,lado,lado);
        this.lado=lado;
    }
    
    public Quadrado(double lado){
        super(lado,lado);
        this.lado=lado;
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
