package exemplos.excecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número inteiro:");

        try {
            int numero = Integer.parseInt(teclado.nextLine());
            System.out.printf("O número digitado foi %d \r\n", numero);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
        }

        System.out.println("\nDigite uma data (dd/mm/aaaa):");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(teclado.nextLine());
        } catch (ParseException ex) {
            System.out.println("Data inválida.");
        }
    }
}
