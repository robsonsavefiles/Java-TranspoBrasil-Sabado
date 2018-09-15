package avaliacao;

import java.util.Scanner;

/**
 * Escreva um programa que solicite um texto para o usuário e em seguida escreva a quantidade de consoantes da palavra informada.
 *
 * @author 78522
 */
public class Questao24 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Informe uma palavra:");
            String consoantes = "bcdfghjklmnpqrstvwxyz";
            String palavra = teclado.nextLine();
            int qtd = 0;

            for (int i = 0; i < palavra.length(); i++) {
                if (consoantes.toLowerCase().contains(String.valueOf(palavra.charAt(i)))) {
                    qtd++;
                }
            }

            System.out.println("Quantidade de consoantes = " + qtd);
        }
    }
}
