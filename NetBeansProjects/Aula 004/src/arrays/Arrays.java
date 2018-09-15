package arrays;

/**
 *
 * @author 78522
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] idades = new int[5];

        idades[0] = 34;
        idades[1] = 25;
        idades[2] = 12;
        idades[3] = 40;
        idades[4] = 17;

        for (int i = 0; i < idades.length; i++) {
            System.out.println(i + " - " + idades[i]);
        }

        for (int idade : idades) {
            System.out.println(idade);
        }
    }

}
