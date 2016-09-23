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
public abstract class Figure {
    Ponto centro;
    
    public abstract double area();
    public abstract double perimeter();
    @Override
    public abstract String toString();
}
