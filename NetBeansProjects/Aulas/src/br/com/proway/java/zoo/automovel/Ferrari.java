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
public class Ferrari extends Carro implements Turbinavel{
    
        private final Turbinavel turbo;
    
        Ferrari(Turbinavel turboBasico){
            this.turbo = turboBasico;
        }
        
     public void turbo(){
        turbo.turbo();
    }
    
}