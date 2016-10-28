
public class Circulo extends Figure {
    private double raio;
    
    public Circulo(double x, double y, double raio){
       super(new Ponto(x,y));
        this.raio=raio;
    }
    
    public Circulo(double raio){
        super(new Ponto(0,0));
        this.raio=raio;
    }
    
    public Circulo(Circulo c){
        super(c.centro());
        this.raio=c.raio();
    }
    
    public double raio(){
        return raio;
    }
    
    public double raio(double new_raio){
        return raio=new_raio;
    }
    
    @Override
    public double area(){
        return Math.PI*Math.pow(raio, 2);
    }
    
    @Override
    public double perimeter(){
       return 2*Math.PI*raio; 
    }
    
    @Override
    public String toString(){
        return "Circulo; Centro: "+centro().x()+";"+centro().y()+"; Raio: "+raio+"; Area: "+area()+"; Perímetro: "+perimeter()+";";
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o)&&this.raio==((Circulo) o).raio();
    }
    
    public boolean intercepts(Circulo c){
        return Ponto.dist(this.centro(),c.centro())<=(this.raio+c.raio());
    }
}
