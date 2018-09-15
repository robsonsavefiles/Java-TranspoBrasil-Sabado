/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.zoo;

/**
 *
 * @author 89087
 */
public class ZooTeste {
    
    public static void main(String[] args) {
        
        //polimorfimo(apontando para o objeto animal)
        Animal animal = new Vegano();
        Vertebrados vertebrados = new Vegano();
        Humano humano = new Vegano();
        
        Animal animal2 = vertebrados;
        Vertebrados vertebrados2 = humano;
        humano.dormir();
        
        
    }
    
}
