package exercicios.veiculo.cadastro;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuMain extends Menu {

    private static final String TITULO = "MENU PRINCIPAL";

    public static final OpcaoMenu OPCAO_VEICULOS = new OpcaoMenu(0, "Menu de veículos");
    public static final OpcaoMenu OPCAO_MODELOS = new OpcaoMenu(1, "Menu de modelos");
    public static final OpcaoMenu OPCAO_MARCAS = new OpcaoMenu(2, "Menu de marcas");
    public static final OpcaoMenu OPCAO_CLIENTES = new OpcaoMenu(3, "Menu de clientes");
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(4, "Sair");

    public MenuMain(Scanner teclado) {
        super(teclado);
        setTitulo(TITULO);
        addOpcao(OPCAO_VEICULOS);
        addOpcao(OPCAO_MODELOS);
        addOpcao(OPCAO_MARCAS);
        addOpcao(OPCAO_CLIENTES);
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_VEICULOS) {
            new MenuVeiculo(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_MODELOS) {
            new MenuModelo(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_MARCAS) {
            new MenuMarca(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_CLIENTES) {
            new MenuCliente(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

}
