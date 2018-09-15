package avaliacao;

import java.util.Scanner;

/**
 * Escreva um programa que solicite o nome do usuário e escreva aquantidade de caracteres do nome informado.
 *
 * @author 78522
 */
public class Questao22 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Forneça seu nome:");
        String nome = teclado.nextLine();
        System.out.println("Quantidade de caracteres: " + nome.length());
    }
}
