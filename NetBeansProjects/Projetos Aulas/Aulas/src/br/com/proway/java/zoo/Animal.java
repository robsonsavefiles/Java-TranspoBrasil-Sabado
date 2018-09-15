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
public interface Animal {

    int CONSTANTE = 1;// CONSTANTE

    void comer();

    void andar();
    
    public default void dormir(){
        System.out.println("Animal dormindo");
    
    
    }

}
