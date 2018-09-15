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
public class Caveirao extends Carro implements Blindavel {

    public Caveirao() {
        blindar();
    }

    @Override
    public void blindar() {
        System.out.println("Caveirao Blindado");
    }

}
