package exemplo_cadastro_contato;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class AppContato {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            CadastroContato cadastro = new CadastroContato(teclado);
            cadastro.mostrarMenu();
        }
    }

}
