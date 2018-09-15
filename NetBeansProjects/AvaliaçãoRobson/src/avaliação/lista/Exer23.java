/*
 23) Escreva um programa que solicite um texto para o usuário e em seguida escreva o texto informado sem as vogais
 */
package avaliação.lista;

import java.util.Scanner;

/**
 * @author 89087
 */
public class Exer23 {

    public static void main(String[] args) {
            System.out.println("\t\tSistema para retirar as vogais do Nome Informado\n\n");
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma Palavra :");
            String palavra = teclado.nextLine();
            String nova  = (palavra.replaceAll("[aeiouAEIOU]", ""));
            System.out.println("Nome Informado sem as vogais é :" + nova);

        }
    }
}
