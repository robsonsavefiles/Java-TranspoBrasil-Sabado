package exercicio_produto;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class AppProduto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroProduto cadastro = new CadastroProduto(teclado);
        cadastro.mostrarMenu();
    }
}
