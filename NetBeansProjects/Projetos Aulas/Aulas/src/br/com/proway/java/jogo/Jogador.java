/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.jogo;

import java.util.Random;

/**
 *
 * @author 89087
 */
public class Jogador {

    static Random random = new Random();

    public Palpite palpitar() {
    return new Palpite(random.nextInt(100));
        
        
    }

}
