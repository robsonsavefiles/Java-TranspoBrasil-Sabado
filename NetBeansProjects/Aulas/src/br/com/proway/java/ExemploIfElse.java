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
public class ExemploIfElse {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um numero");
        int numero = Integer.parseInt(teclado.nextLine());

        if (numero > 50) {
            System.out.print("o numero informado é maio que 50");
        } else if (numero >= 25) {
            System.out.println("o numero informado é igual ou menor que 50 e maior ou igual a 25");
        } else {
            System.out.println("O numero informdado é igual ou menor que 50");
        }
        System.out.println("Fim da Aplicação");

    }

}
