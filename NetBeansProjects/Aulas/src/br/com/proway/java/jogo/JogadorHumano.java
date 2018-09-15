/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.jogo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class JogadorHumano extends Jogador {

    private Scanner teclado;

    public Palpite palpitar() {

        System.out.print(" Informe um Numero Jogador:");
        int num = Integer.parseInt(teclado.nextLine());
        return new Palpite(num);

    }

    public JogadorHumano(Scanner teclado) {
        this.teclado = teclado;
    }

}
