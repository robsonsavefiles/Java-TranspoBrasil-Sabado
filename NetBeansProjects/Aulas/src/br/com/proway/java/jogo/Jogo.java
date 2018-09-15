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
public class Jogo {

    private  Palpite secreto = new Palpite(new Random().nextInt(100));
    private static final int MAX_TENTATIVAS = 5;
    private int tentativas = 1;
    private Jogador computador;

    public void Iniciar() {
        computador = new Jogador();
        boolean acertou = false;

        do {
            System.out.println("Informe um numero entre 0 e 100");
            Palpite palpite = computador.palpitar();
            System.out.println(palpite.getValor());
            if (secreto.equals(palpite)) {
                acertou = true;
            }
            tentativas++;
        } while (!acertou && tentativas <= MAX_TENTATIVAS);
            
        if(acertou){
            System.out.println("Parabens voce acertou");
        }else {
            System.out.println("nao foi dessa vez, quem sabe da proxima ");
            System.out.println("O Numero  era "+secreto.getValor());
        }
        
    }

}
