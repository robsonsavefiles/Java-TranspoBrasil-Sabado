package avaliacao.questao26.menus;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuMain extends Menu {

    private static final String TITULO = "MENU PRINCIPAL";

    private final static OpcaoMenu OPCAO_CLIENTE = new OpcaoMenu("1", "Cliente");
    private final static OpcaoMenu OPCAO_PRODUTO = new OpcaoMenu("2", "Produto");
    private final static OpcaoMenu OPCAO_PEDIDO = new OpcaoMenu("3", "Pedido");
    private final static OpcaoMenu OPCAO_SAIR = new OpcaoMenu("4", "Sair");

    public MenuMain(Scanner teclado) {
        super(teclado);
        addOpcao(OPCAO_CLIENTE);
        addOpcao(OPCAO_PRODUTO);
        addOpcao(OPCAO_PEDIDO);
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_PRODUTO) {
            new MenuProduto(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_PEDIDO) {
            new MenuPedido(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_CLIENTE) {
            new MenuCliente(getTeclado()).mostrarMenu();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

    @Override
    public String getTitulo() {
        return TITULO;
    }

}
