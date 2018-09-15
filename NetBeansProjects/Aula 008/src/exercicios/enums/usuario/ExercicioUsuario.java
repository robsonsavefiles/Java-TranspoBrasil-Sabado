package exercicios.enums.usuario;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class ExercicioUsuario {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroUsuario cadastro = new CadastroUsuario(teclado);
        cadastro.mostrarMenu();
    }
}
