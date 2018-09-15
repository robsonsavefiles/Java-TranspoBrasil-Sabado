package exemplos.observer;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ObserverApp app = new ObserverApp(teclado);
        app.menu();
    }
}
