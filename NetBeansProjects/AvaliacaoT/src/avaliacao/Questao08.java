package avaliacao;


import java.util.Scanner;

/**
 * Escreva um programa que solicite a idade do usu�rio e escreva qual ser� sua idade daqui a 30 anos.
 *
 *@9087
 */
public class Questao08 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Forne�a sua idade:");
            int idade = Integer.parseInt(teclado.nextLine());
            System.out.println("Idade daqui 30 anos: " + (idade + 30));
        } catch (NumberFormatException e) {
            System.out.println("Idade inv�lida.");
        }
    }

}
