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
public class Exer1_SwitchCase {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe um Numero: ");
        int num = Integer.parseInt(teclado.nextLine());

        switch (num) {
            case 20:
                System.out.println("20 esta dentro do Range");
                break;
            case 25:
                System.out.println("25 esta dentro do Range");
                break;
            case 30:
                System.out.println("30 esta dentro do Range");
                break;
            case 35:
                System.out.println("35 esta dentro do Range");
                break;
            case 40:
                System.out.println("40 esta dentro do Range");
                break;
            case 45:
                System.out.println("45 esta dentro do Range");
                break;
            case 50:
                System.out.println("50 esta dentro do Range");
                break;
            case 55:
                System.out.println("55 esta dentro do Range");
                break;
            case 60:
                System.out.println("60 esta dentro do Range");
                break;
            case 65:
                System.out.println("65 esta dentro do Range");
                break;
            case 70:
                System.out.println("70 esta dentro do Range");
                break;

            default:

                if (num < 20 || num > 70) {
                    System.out.println("Numero Invalido");

                }

        }

    }

}
