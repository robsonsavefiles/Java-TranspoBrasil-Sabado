package avaliacao;


import java.util.Scanner;

/**
 * Escrever um programa que tendo como dados de entrada a altura e o sexo de uma pessoa ("M" - masculino e "F" - feminino), calcule seu peso ideal, utilizando
 * as seguintes f�rmulas: para homens =(72.7* h )-58 para mulheres = (62.1 * h) - 44.7
 *
 * @author 78522
 */
public class Questao11 {

    private enum Sexo {

        MASCULINO("M"), FEMININO("F");
        private final String id;

        private Sexo(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double altura;
        Sexo sexo;
        String input;

        while (true) {
            try {
                System.out.println("Informe sua altura:");
                input = teclado.nextLine();
                altura = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Altura inv�lida.");
            }
        }

        while (true) {
            System.out.println("Informe seu sexo (" + Sexo.MASCULINO.getId() + "/" + Sexo.FEMININO.getId() + "):");
            input = teclado.nextLine();
            if (input.equalsIgnoreCase(Sexo.MASCULINO.getId())) {
                sexo = Sexo.MASCULINO;
                break;
            } else if (input.equalsIgnoreCase(Sexo.FEMININO.getId())) {
                sexo = Sexo.FEMININO;
                break;
            } else {
                System.out.println("Sexo inv�lido.");
            }
        }

        System.out.println("Seu peso ideal �: " + pesoIdeal(sexo, altura) + "Kg");

        teclado.close();
    }

    private static double pesoIdeal(Sexo sexo, double altura) {
        switch (sexo) {
            case MASCULINO:
                return (72.7 * altura) - 58;
            case FEMININO:
                return (62.1 * altura) - 44.7;
            default:
                throw new AssertionError();
        }
    }
}
