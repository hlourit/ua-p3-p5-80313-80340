
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utilizador
 */
public class Teste {

    public static void main(String[] args) {
        Circulo c1 = new Circulo(2);
        Circulo c2 = new Circulo(1, 3, 2);
        Circulo c3 = new Circulo(c1);
        System.out.println(c1 );
        System.out.println(c3 );
        System.out.println("c1 equals to c3? ->"  + c1.equals(c3)); // True
        Quadrado q1 = new Quadrado(2);
        Quadrado q2 = new Quadrado(3, 4, 2);
        Quadrado q3 = new Quadrado(q2);
        System.out.println(q1 );
        System.out.println(q3 );
        System.out.println("q1 equals to q3? ->"  + q1.equals(q3)); // False
        Rectangulo r1 = new Rectangulo(2, 3);
        Rectangulo r2 = new Rectangulo(3, 4, 2, 3);
        Rectangulo r3 = new Rectangulo(r2);
        System.out.println(r1 );
        System.out.println(r3 );
        System.out.println("r2 equals to r3? ->"  + r2.equals(r3)); // True
    }
}
