/*
 *10)Escrever um programa que recebe um numero e escreve o resultado do numero na 2ª potência.
 */
package avaliação.lista;

import static java.lang.Math.*;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer10 {

    public static void main(String[] args) {

      
        boolean continua = true;

        do {
            System.out.println("\t\t======Calcular A potência de um Numero====\n");
            
            try (Scanner teclado = new Scanner(System.in);) {
                System.out.println("Informe um Numero:");
                double num = Double.parseDouble(teclado.nextLine());

                double result = Math.pow(num, 2);

                System.out.println("Potencia do numero informado é :" + result);
                continua = false;
            } catch (NumberFormatException ex) {
                System.out.println("Informe um numero novamente:");
            }

        } while (continua);

    }

}
