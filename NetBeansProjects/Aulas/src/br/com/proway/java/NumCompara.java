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
public class NumCompara {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o Primeiro numero:");
        String num1 = teclado.nextLine();
        int n1 = Integer.parseInt(num1);

        System.out.print("Informe o Segundo numero:");
        String num2 = teclado.nextLine();
        int n2 = Integer.parseInt(num2);

        System.out.print("Informe o terceiro Numero:");
        String num3 = teclado.nextLine();
        int n3 = Integer.parseInt(num3);

        System.out.print("Informe o Quarto Numero:");
        String num4 = teclado.nextLine();
        int n4 = Integer.parseInt(num4);

        System.out.println(n1 == n4);
        System.out.println(n4 == n3);

    }

}
