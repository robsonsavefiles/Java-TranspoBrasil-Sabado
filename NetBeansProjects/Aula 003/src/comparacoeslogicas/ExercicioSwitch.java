package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioSwitch {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe um número múltiplo de 5 entre 20 e 70:");
        int numero = Integer.parseInt(teclado.nextLine());
        switch (numero) {
            case 20:
            case 25:
            case 30:
            case 35:
            case 40:
            case 45:
            case 50:
            case 55:
            case 60:
            case 65:
            case 70:
                System.out.println(numero + " é um número válido");
                break;
            default:
                System.out.println(numero + " é um número inválido");
        }
    }
}
