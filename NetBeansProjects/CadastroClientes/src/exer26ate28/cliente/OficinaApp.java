package exer26ate28.cliente;

import exer26ate28.cadastro.MenuMain;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class OficinaApp {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            MenuMain menuMain = new MenuMain(teclado);
            menuMain.mostrarMenu();
        }
    }
}
