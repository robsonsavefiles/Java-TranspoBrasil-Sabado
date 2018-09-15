package parte2.exercicio02;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Mineradora mineradora = new Mineradora();
//        Scanner scanner = new Scanner(System.in);
//        MenuPrincipal menu = new MenuPrincipal(scanner, mineradora);
//        menu.mostrarMenu();
//        System.exit(0);
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }
        new View(mineradora).setVisible(true);
    }
}
