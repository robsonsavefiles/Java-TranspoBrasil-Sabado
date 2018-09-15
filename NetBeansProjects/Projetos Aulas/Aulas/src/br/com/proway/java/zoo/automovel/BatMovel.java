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
public class BatMovel extends Carro implements Turbinavel, Blindavel {

    public BatMovel() {
        blindar();
    }
    
    @Override
    public void turbo() {
        System.out.println("Velocidade 160");
    }
    @Override
    public void blindar() {
        System.out.println("Blindagem BatMovel ativida");

    }

}
