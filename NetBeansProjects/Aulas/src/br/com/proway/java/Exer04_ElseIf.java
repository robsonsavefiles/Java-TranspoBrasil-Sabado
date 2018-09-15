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
public class Exer04_ElseIf {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe a primeira nota:");
        int n1 = Integer.parseInt(teclado.nextLine());
        System.out.print("Informe a segunda nota:");
        int n2 = Integer.parseInt(teclado.nextLine());
        System.out.print("Informe a segunda nota:");
        int n3 = Integer.parseInt(teclado.nextLine());

        double media = (n1 + n2 + n3) / 3;

        if (media >= 9) {

            System.out.println("Conceito A");

        } else if (media < 9 && media >= 7) {
            System.out.println("Conceito B");

        } else if (media < 7 && media >= 6) {
            System.out.println("Conceito C");

        } else if (media < 6) {
            System.out.println("Conceito D");
        }
    }

}
