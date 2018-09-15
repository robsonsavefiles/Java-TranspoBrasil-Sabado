/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Interruptor interruptor  = new Interruptor((Dispositivos) new Lampada());
        
        interruptor.ligar();
        interruptor.desligar();
       
        interruptor.setDispositivo(new Ventilador());
        
        interruptor.ligar();
        interruptor.desligar();
        
        
        
    }
    
}
