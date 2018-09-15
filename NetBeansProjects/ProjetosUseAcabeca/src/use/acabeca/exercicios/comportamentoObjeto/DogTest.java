/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.exercicios.comportamentoObjeto;

/**
 *
 * @author Robinho
 */
public class DogTest {
    public static void main(String[] args) {
        Dog one = new Dog();
        one.size = 70;
        Dog two = new Dog();
        two.size = 8;
        Dog three = new Dog();
        three.size = 15;
        
        one.bark();
        two.bark();
        three.bark();
        
    }
    
}
