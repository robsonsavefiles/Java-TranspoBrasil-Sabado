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
public class Calculadora {

    public static void main(String[] args) {

        double num1;
        double num2;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o segundo numero:");

        double n1 = Double.parseDouble(teclado.nextLine());
        System.out.println("Informe o segundo numero");
        double n2 = Double.parseDouble(teclado.nextLine());

        System.out.println("######RESULTADO######");
        System.out.println(somar(n1, n2));
        System.out.println(multiplicar(n1, n2));
        System.out.println(dividir(n1, n2));
        System.out.println(subtrair(n1, n2));

    }

    public static double somar(double n1, double n2) {
        return n1 + n2;
    }

    public static double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public static double dividir(double n1, double n2) {
        return n1 / n2;
    }

    public static double subtrair(double n1, double n2) {
        return n1 - n2;

    }

}
