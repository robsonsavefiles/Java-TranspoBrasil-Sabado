
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        JogoHanoi jogo = new JogoHanoi();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quantos discos?");
        int qtd = Integer.parseInt(teclado.nextLine());
        jogo.comecarJogo(qtd);
        jogo.imprimirTorres();
    }
}
