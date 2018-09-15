package arrays;

/**
 *
 * @author 78522
 */
public class ArraysBidimensionais {

    public static void main(String[] args) {

        // Exemplo declaração
        int[][] posicoes1 = new int[3][3];
        int posicoes2[][] = new int[3][3];
        int[] posicoes3[] = new int[3][3];

        // Exemplo For
        int[][] testes = new int[5][];
        testes[0] = new int[10];
        testes[1] = new int[2];
        testes[2] = new int[7];
        testes[3] = new int[5];
        testes[4] = new int[3];

        System.out.println("For");

        for (int i = 0; i < testes.length; i++) {
            for (int j = 0; j < testes[i].length; j++) {
                System.out.print(testes[i][j]);
            }
            System.out.println();
        }

        // Exemplo For Each
        int[][] pontos = new int[2][2];
        pontos[0][0] = 30;
        pontos[0][1] = 25;
        pontos[1][0] = 10;
        pontos[1][1] = 15;

        System.out.println("\nFor Each");

        for (int[] ponto : pontos) {
            for (int i = 0; i < ponto.length; i++) {
                System.out.println(ponto[i]);
            }
        }
    }
}
