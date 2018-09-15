/*
 *08)
 */
package avaliação.lista;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer8 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean continua = true;

        do {

            try {
                System.out.println("Informe sua idade:");
                int idade = Integer.parseInt(teclado.nextLine());
                int tot_age = idade + 30;
                System.out.println("Sua idade daqui a 30anos é:" + tot_age);
                continua = false;
            } catch (NumberFormatException ex) {
                System.out.println("Informe Novamente Sua Idade:");
            }

        } while (continua);

    }

}
