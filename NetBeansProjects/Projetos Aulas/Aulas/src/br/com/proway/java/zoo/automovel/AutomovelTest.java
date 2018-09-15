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
public class AutomovelTest {
    
    public static void main(String[] args) {
        
        Carro a1 = new Fusca();
        Carro a2 = new Lamborguini(new TurboBasico());
        Carro a3 = new Ferrari(new TurboJato());
        
        chamarTurbo(a1);
        chamarTurbo(a2);
        chamarTurbo(a3);
        
        
    }
    private static void chamarTurbo(Carro carro){
        if(carro instanceof Turbinavel){
            ((Turbinavel)carro).turbo();
        }
   
    }
    
}
