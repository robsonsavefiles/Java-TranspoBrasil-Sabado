/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer1While {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int num = 0;

        while (num != 10) {

            System.out.print("Informe um Numero: ");
            num = Integer.parseInt(teclado.nextLine());

        }
        System.out.println("Fim Do Jogo");
        teclado.close();

    }
}
