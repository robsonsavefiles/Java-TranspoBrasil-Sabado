package avaliacao;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Escreva um programa que receba um número entre 1 e 7 e escreva o dia da semana referente ao dia informado. Utilize a classe Calendar para pegar o nome do
 * dia.
 *
 * @author 78522
 */
public class Questao16 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in);) {
            System.out.println("Forneça um número entre 1 e 7:");
            int numero = Integer.parseInt(teclado.nextLine());

            if (numero < 1 || numero > 7) {
                throw new IllegalArgumentException();
            }

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_WEEK, numero);

            System.out.println("Dia da Semana: " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("O número deve estar entre 1 e 7");
        }
    }
}
