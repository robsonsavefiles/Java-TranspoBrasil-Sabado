/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.matriz;

/**
 *
 * @author Robinho
 */
public class Dog {

    String name;

    public static void main(String[] args) {
        //cria um objeto Dog e o Acessa

        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";
        //Agora cria uma matriz Dog
        Dog[] myDogs = new Dog[3];
        //and put some dogs in it
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;
         //agora acessa os objetos Dog
        //usando as referencias da matriz
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";
        //hummm qual nome de myDogs[2]?
        System.out.println("O nome do ultimo cao é" + myDogs[2].name);
        //agora executa um loop pela matriz
        // e pede a todos os cães para latirem

        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }

    }

    public void bark() {
        System.out.println(name + "dif Ruff!!");
    }

    public void eat() {
    }

    public void chaseCat() {
    }

}
