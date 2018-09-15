/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tiago.comparacao;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioComparacao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Forneça um número:");
        int i = Integer.parseInt(teclado.nextLine());
        System.out.println("O número é maior que 10? " + (i > 10));
        System.out.println("O número é menor que 100? " + (i < 100));
        System.out.println("O número é diferente de 27? " + (i != 27));
        System.out.println("O número é igual a 25? " + (i == 25));
        System.out.println("O número menor ou igual a 50? " + (i <= 50));
        System.out.println("O número maior ou igual a 30? " + (i >= 30));
    }
}
