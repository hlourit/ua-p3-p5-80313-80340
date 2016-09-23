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
public class Quadrado extends Figure {
    private double lado;
    
    public Quadrado(Ponto centro, double lado){
        this.centro=centro;
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
        return "Quadrado; Centro: "+centro.x()+";"+centro.y()+"; Lado: "+lado+"; Area: "+area()+"; Perímetro: "+perimeter()+";";
    }
}