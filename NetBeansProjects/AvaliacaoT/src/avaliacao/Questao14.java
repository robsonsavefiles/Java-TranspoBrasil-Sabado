package avaliacao;

/**
 * Escreva um programa que escreva os n�meros primos entre 1 e 1000.(Um n�mero primo � aquele que � divisivel apenas por 1 e por ele mesmo com resto Zero)
 *
 * @author 89087
 */
public class Questao14 {

    public static void main(String[] args) {
        System.out.println("S�o primos:");
        i:
        for (int i = 2; i < 1000; i++) {
            j:
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    continue i;
                }
            }
            System.out.println(i);
        }
    }

}
