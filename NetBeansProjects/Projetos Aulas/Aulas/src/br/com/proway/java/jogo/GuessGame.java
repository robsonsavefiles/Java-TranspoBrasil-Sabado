/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.jogo;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class GuessGame {

    Scanner teclado = new Scanner(System.in);

    private Palpite secreto = new Palpite(new Random().nextInt(100));
    private static final int MAX_TENTATIVAS = 5;
    private int tentativas = 1;
    public int num;
    private Jogador computador;
    private Jogador humano;

    private int tentativascomputador = 1;
    private int tentativashumano = 1;

    public void Iniciar() {
        Scanner teclado = new Scanner(System.in);
        computador = new Jogador();
        boolean acertou = false;

        humano = new JogadorHumano(teclado);
        boolean itsRight = false;

        do {
            System.out.println("Computador Informou:");
            Palpite palpite = computador.palpitar();
            System.out.println(palpite.getValor());
            if (secreto.equals(palpite)) {
                acertou = true;
            }else{
                System.out.println(" Vez do humano:");
                palpite = humano.palpitar();
                System.out.println(palpite.getValor());
            }
            
            } while (!acertou && tentativas <= MAX_TENTATIVAS);
            if (secreto.equals(num)) {
                acertou = true;
            }
            tentativas++;
            tentativascomputador++;
        
        if (acertou) {
            System.out.println("Parabens voce acertou ");
        } else {
            System.out.println("Jogador Errou  ");
            System.out.println("O Numero  era " + secreto.getValor());
        }
        System.out.println("TOTAL DE TENTATIVAS COMPUTADOR:"+tentativascomputador);
        System.out.println("TOTAL DE TENTATIVAS HUMANO:"+tentativashumano);
    }
        
}
