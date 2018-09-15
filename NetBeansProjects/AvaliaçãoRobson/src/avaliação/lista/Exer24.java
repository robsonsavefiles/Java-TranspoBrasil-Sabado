/*
 24) Escreva um programa que solicite um texto para o usuário e em seguida escreva
 a quantidade de consoantes da palavra informada.
 */
package avaliação.lista;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer24 {
   
    public static void main(String[] args) {
        
        System.out.println("\t\tSistema para Calcular Quantidade de consoantes da palavra Informada\n\n");
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma palavra:");
            String consoantes = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
            String palavra = teclado.nextLine();
            int qtd = 0;

            for (int i = 0; i < palavra.length(); i++) {
                if (consoantes.contains(String.valueOf(palavra.charAt(i)))) {
                    qtd++;
                }
            }

            System.out.println("Quantidade de consoantes = " + qtd);
        }
    }
}

