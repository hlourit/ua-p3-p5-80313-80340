/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1.prob1_3;

/**
 *
 * @author Utilizador
 */
public class Circulo extends Figure {
    private double raio;
    
    public Circulo(double x, double y, double raio){
        this.raio=raio;
        this.centro=new Ponto(x, y);
    }
    
    public Circulo(Ponto centro, double raio){
        this.centro=centro;
        this.raio=raio;
    }
    
    public double raio(){
        return raio;
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
        return "Circulo; Centro: "+centro.x()+";"+centro.y()+"; Raio: "+raio+"; Area: "+area()+"; Perímetro: "+perimeter()+";";
    }
    
    public boolean equals(Circulo c){
        return this.centro==c.centro&&this.raio==c.raio();
    }
    
    public boolean intercepts(Circulo c){
        return Ponto.dist(this.centro,c.centro)<=(this.raio+c.raio());
    }
}
