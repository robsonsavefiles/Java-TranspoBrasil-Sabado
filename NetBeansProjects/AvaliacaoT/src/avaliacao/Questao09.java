package avaliacao;


import java.util.Scanner;

/**
 * Escrever um programa que recebe dois numeros B e C e escreve o Valor de A dada a formula A² = B² + C²
 *
 * @author 78522
 */
public class Questao09 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in);) {
            System.out.println("Cálculo de A, onde A² = B² + C².");
            System.out.println("Forneça o valor de B:");
            double variavelB = Double.parseDouble(teclado.nextLine());
            System.out.println("Forneça o valor de C:");
            double variavelC = Double.parseDouble(teclado.nextLine());

            double resultado = Math.pow(variavelB, 2) + Math.pow(variavelC, 2);
            resultado = Math.sqrt(resultado);

            System.out.println("A = " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
        }
    }
}
