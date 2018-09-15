package avaliacao;

/**
 * Escreva um programa que escreva os números pares entre 1 e 1000. Utilize um método recursivo.
 *
 * @author 78522
 */
public class Questao17 {

    public static void main(String[] args) {
        pares(1, 1000);
    }

    private static void pares(int atual, int limite) {
        if (atual < limite) {
            if (atual % 2 > 0) {
                atual++;
            }
            System.out.println(atual);
            pares(atual + 2, limite);
        }
    }
}
