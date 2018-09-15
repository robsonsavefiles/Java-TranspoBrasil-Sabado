package exercicio_veiculo.cadastro;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class Cadastro {

    private static final String OPCAO_VEICULOS = "1";
    private static final String OPCAO_MODELOS = "2";
    private static final String OPCAO_MARCAS = "3";
    private static final String OPCAO_SAIR = "4";

    private Scanner teclado;

    public Cadastro(Scanner teclado) {
        this.teclado = teclado;
    }

    public Cadastro() {
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("MENU PRINCIPAL");
            System.out.println(OPCAO_VEICULOS + " - Menu de veículos");
            System.out.println(OPCAO_MODELOS + " - Menu de modelos");
            System.out.println(OPCAO_MARCAS + " - Menu de marcas");
            System.out.println(OPCAO_SAIR + " - Sair");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!OPCAO_SAIR.equalsIgnoreCase(opcao));
    }

    public void tratarOpcoes(String opcao) {
        switch (opcao) {
            case OPCAO_VEICULOS:
                new CadastroVeiculo(teclado).mostrarMenu();
                break;
            case OPCAO_MODELOS:
                new CadastroModelo(teclado).mostrarMenu();
                break;
            case OPCAO_MARCAS:
                new CadastroMarca(teclado).mostrarMenu();
                break;
        }
    }
}
