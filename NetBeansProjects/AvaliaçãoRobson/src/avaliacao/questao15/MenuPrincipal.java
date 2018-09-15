package avaliacao.questao15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuPrincipal {

    private final static List<OpcaoMenu> OPCOES = new ArrayList();

    private final static OpcaoMenu OPCAO_CLIENTE = new OpcaoMenu("1", "Cliente");
    private final static OpcaoMenu OPCAO_PRODUTO = new OpcaoMenu("2", "Produto");
    private final static OpcaoMenu OPCAO_PEDIDO = new OpcaoMenu("3", "Pedido");
    private final static OpcaoMenu OPCAO_SAIR = new OpcaoMenu("4", "Sair");

    static {
        OPCOES.add(OPCAO_CLIENTE);
        OPCOES.add(OPCAO_PRODUTO);
        OPCOES.add(OPCAO_PEDIDO);
        OPCOES.add(OPCAO_SAIR);
    }

    private final Scanner teclado;

    public MenuPrincipal(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        do {
            System.out.println("MENU PRINCIPAL");
            OPCOES.stream().forEach((opcaoMenu) -> System.out.println(opcaoMenu.getId() + " - " + opcaoMenu.getDescricao()));
        } while (tratarOpcoes(teclado.nextLine()));
    }

    private boolean tratarOpcoes(String input) {
        OpcaoMenu opcao = toOpcao(input);
        if (opcao != null){
            if (opcao == OPCAO_SAIR){
                return false;
            }
            System.out.println("Você escolheu a Opção:" + opcao.getDescricao());
        } else {
            System.out.println("Opção invalida.");
        }
        return true;
    }

    private OpcaoMenu toOpcao(String input) {
        for (OpcaoMenu opcao : OPCOES) {
            if (opcao.getId().equalsIgnoreCase(input)) {
                return opcao;
            }
        }
        return null;
    }
}
