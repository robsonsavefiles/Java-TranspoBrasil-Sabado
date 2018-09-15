package avaliacao;


import java.util.Scanner;

/**
 * Escrever um programa que recebe um numero e escreve o resultado do numero na 2� pot�ncia.
 *
 * @author 78522
 */
public class Questao10 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in);) {
            System.out.println("Forne�a um n�mero:");
            double numero = Double.parseDouble(teclado.nextLine());
            double resultado = Math.pow(numero, 2);
            System.out.println("N�mero na 2� pot�ncia = " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("N�mero inv�lido.");
        }
    }

}
