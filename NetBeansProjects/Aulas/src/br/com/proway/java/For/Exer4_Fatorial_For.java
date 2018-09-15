/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.For;

import java.util.Scanner;

public class Exer4_Fatorial_For {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);
        int num, fat = 1;
        int cont = 1;

        do {
            System.out.println("Digite um numero:");
            num = ent.nextInt();

            for (int i = 1; i <= num; i++) {
                fat = fat * i;
            }

            System.out.println("!" + num + " = " + fat);
            cont++;

        } while (cont < 2);
    }
}
