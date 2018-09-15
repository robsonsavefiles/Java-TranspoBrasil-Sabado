/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.For;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer3_For {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o primeiro Numero:");
        int num1 = Integer.parseInt(teclado.nextLine());

        int num2 = num1;

        do {
            System.out.println("Informe o Segundo Numero:");
            int n2 = Integer.parseInt(teclado.nextLine());
        } while (num2 <= num1);
        for (; num1 <= num2; num1 = num1 + 1) {
            if (num1 % 2 == 0) {
                System.out.println(num1);

            }

        }
    }
}
