package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Switch {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe um dia da semana");
        String dia = teclado.nextLine();

        switch (dia.toLowerCase()) {
            case "segunda":
                System.out.println("Bad");
                break;
            case "terça":
                System.out.println("Meio bad");
                break;
            case "quarta":
                System.out.println("Meio bad ainda");
                break;
            case "quinta":
                System.out.println("Quase bom");
                break;
            case "sexta":
                System.out.println("Ae");
                break;
            case "sábado":
                System.out.println("Aw yeah");
                break;
            case "domingo":
                System.out.println("Droga");
                break;
            default:
                throw new AssertionError();
        }

        teclado.close();
    }
}
