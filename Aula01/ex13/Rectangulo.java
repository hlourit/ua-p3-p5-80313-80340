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
public class Rectangulo extends Figure {
    private double largura,comprimento;
    
    public Rectangulo(Ponto centro, double largura,double comprimento){
        this.centro=centro;
        this.largura=largura;
        this.comprimento=comprimento;
    }
    
    public double largura(){
        return largura;
    }
    
    public double comprimento(){
        return comprimento;
    }
    
    @Override
    public double area(){
        return largura*comprimento;
    }
    
    @Override
    public double perimeter(){
       return 2*largura+2*comprimento; 
    }
    
    @Override
    public String toString(){
        return "Rectangulo; Centro: "+centro.x()+";"+centro.y()+"; Largura: "+largura+"; Comprimento: "+comprimento+"; Area: "+area()+"; Perímetro: "+perimeter()+";";
    }
}
