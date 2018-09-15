package avaliacao;


import java.util.Scanner;

/**
 * Fazer um programa que solicite um número entre 1 e 12 e imprima o fatorial número informado (utilize o comando for).
 *
 * @author 78522
 */
public class Questao13 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in);) {
            System.out.println("Forneça um número entre 1 e 12:");
            int numero = Integer.parseInt(teclado.nextLine());

            if (numero < 1 || numero > 12) {
                throw new IllegalArgumentException();
            }

            int resultado = 1;
            for (int i = 1; i <= numero; i++) {
                resultado *= i;
            }

            System.out.println("!" + numero + " = " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("O número deve estar entre 1 e 12");
        }
    }
}
