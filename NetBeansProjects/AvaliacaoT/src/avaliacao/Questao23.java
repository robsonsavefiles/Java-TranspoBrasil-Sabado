package avaliacao;

import java.util.Scanner;

/**
 * Escreva um programa que solicite um texto para o usuário e em seguida escreva o texto informado sem as vogais
 *
 * @author 78522
 */
public class Questao23 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Forneça um texto:");
        String nome = teclado.nextLine();
        System.out.println("Texto sem vogais:");
        System.out.println(nome.replaceAll("[aeiouAEIOU]", ""));
    }
}
