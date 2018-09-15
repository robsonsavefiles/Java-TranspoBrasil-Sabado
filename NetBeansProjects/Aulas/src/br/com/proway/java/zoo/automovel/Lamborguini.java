/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.zoo.automovel;

/**
 *
 * @author 89087
 */
public class Lamborguini extends Carro implements Turbinavel {
    
    
    private Turbinavel turbo;
    
    public Lamborguini(Turbinavel turbo){
        this.turbo = turbo;
    }
    
     public void turbo(){
        System.out.println("Turbo 300");
    }
    
}
