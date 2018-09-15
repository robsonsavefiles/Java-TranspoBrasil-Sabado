package comparacoeslogicas;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class IfElse {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um número");
        int numero = Integer.parseInt(teclado.nextLine());

        //System.out.println(numero > 50 ? "O número informado é maior que 50" : "O número informado não é maior que 50");
        if (numero > 50) {
            System.out.println("O número informado é maior que 50");
        } else if (numero >= 25) {
            System.out.println("O número informado é igual ou menor que 50 e maior ou igual a 25");
        } else {
            System.out.println("O número informado é menor que 25");
        }
        System.out.println("Fim da aplicação");
    }
}
