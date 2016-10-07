
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Rectangulo extends Figure {
    private double largura,comprimento;
    
    public Rectangulo(double largura,double comprimento){
        super(new Ponto(0,0));
        this.largura=largura;
        this.comprimento=comprimento;
    }
    
    public Rectangulo(double x, double y, double largura,double comprimento){
        super(new Ponto(x,y));
        this.largura=largura;
        this.comprimento=comprimento;
    }
    
    public Rectangulo(Rectangulo r){
        super(r.centro());
        this.largura=r.largura();
        this.comprimento=r.comprimento();
    }
    
    public double largura(){
        return largura;
    }
    
    public double largura(double new_largura){
        return largura=new_largura;
    }
    
    public double comprimento(){
        return comprimento;
    }
    
    public double comprimento(double new_comprimento){
        return comprimento=new_comprimento;
    }
    
    @Override
    public double area(){
        return largura*comprimento;
    }
    
    @Override
    public double perimetro(){
       return 2*largura+2*comprimento; 
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o) && largura==((Rectangulo)o).largura() && comprimento==((Rectangulo)o).comprimento();
    }
    
    @Override
    public String toString(){
        return "Rectangulo; Centro: "+centro().x()+";"+centro().y()+"; Largura: "+largura+"; Comprimento: "+comprimento+"; Area: "+area()+"; Perímetro: "+perimetro()+";";
    }
}
