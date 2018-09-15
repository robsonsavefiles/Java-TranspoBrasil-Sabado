/*

 13) Fazer um programa que solicite um número entre 1 e 12 e imprima o fatorial número informado 
 (utilize o comando for).
 */
package avaliação.lista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer13 {
    
private final static String OPCAO_SAIR = "S";

   public static void main(String[] args) {
       String sair ="";
       do{
        try (Scanner teclado = new Scanner(System.in)){
            System.out.println("Forneça um número entre 1 e 12:");
            int numero = Integer.parseInt(teclado.nextLine());

            if (numero < 1 || numero > 12) {
                //throw new IllegalArgumentException();
                System.out.println("### Numero invalido ####");
                System.out.println("#### Forneça um número entre 1 e 12 ####:");
                numero = Integer.parseInt(teclado.nextLine());
                
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
    } while (!OPCAO_SAIR.equalsIgnoreCase(sair));
}
}