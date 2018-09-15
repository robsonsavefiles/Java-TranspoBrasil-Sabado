/*
 *09) Escrever um programa que recebe dois numeros B e C  e escreve o Valor de A dada a formula A² = B² + C²
 */
package avaliação.lista;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 *
 * @author 89087
 */
public class Exer9 {

    public static void main(String[] args) {

        try (Scanner teclado = new Scanner(System.in);) {
            System.out.println("Cálculo de A, onde A² = B² + C²\n");
            System.out.println("O valor de B:");
            double vB = Double.parseDouble(teclado.nextLine());

            System.out.println("O valor de C:");
            double vC = Double.parseDouble(teclado.nextLine());

            double total = Math.pow(vB, 2) + Math.pow(vC, 2);

            total = Math.sqrt(total);
            
            System.out.println("O valor de A² é:" + total);
        } catch (NumberFormatException ex) {
            System.out.println("Informe Novamente:");

        }

    }
}
