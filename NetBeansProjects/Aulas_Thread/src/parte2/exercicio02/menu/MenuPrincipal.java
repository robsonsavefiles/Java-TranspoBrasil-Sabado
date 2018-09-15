package parte2.exercicio02.menu;

import java.util.Scanner;
import parte2.exercicio02.Mineradora;

/**
 *
 * @author 78522
 */
public class MenuPrincipal extends Menu {

    private static final OpcaoMenu OPCAO_MAQUINAS = new OpcaoMenu("1", "Adicionar ou Remover Maquinas");
    private static final OpcaoMenu OPCAO_OPERARIOS = new OpcaoMenu("2", "Adicionar ou Remover Operarios");
    private static final OpcaoMenu OPCAO_SITUACAO = new OpcaoMenu("3", "Visualizar Situação dos Recursos");
    private static final OpcaoMenu OPCAO_ATIVOS = new OpcaoMenu("4", "Visualizar Máquinas e Operários Ativos");
    private static final OpcaoMenu OPCAO_PRODUTIVIDADE_MAQUINAS = new OpcaoMenu("5", "Visualizar Produtividade e Gasto de Máquinas");
    private static final OpcaoMenu OPCAO_PRODUTIVIDADE_OPERARIOS = new OpcaoMenu("6", "Visualizar Produtividade de Operários");
    private static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("7", "Sair");

    private final Mineradora mineradora;

    public MenuPrincipal(Scanner scanner, Mineradora mineradora) {
        super(scanner);
        this.mineradora = mineradora;
        addOpcao(OPCAO_MAQUINAS);
        addOpcao(OPCAO_OPERARIOS);
        addOpcao(OPCAO_SITUACAO);
        addOpcao(OPCAO_ATIVOS);
        addOpcao(OPCAO_PRODUTIVIDADE_MAQUINAS);
        addOpcao(OPCAO_PRODUTIVIDADE_OPERARIOS);
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_MAQUINAS) {
            MenuMaquinas menu = new MenuMaquinas(getScanner(), mineradora);
            menu.mostrarMenu();
        }
        if (opcao == OPCAO_OPERARIOS) {
            MenuOperarios menu = new MenuOperarios(getScanner(), mineradora);
            menu.mostrarMenu();
        }
        if (opcao == OPCAO_SITUACAO) {
            System.out.println(mineradora.getSituacao());
        }
        if (opcao == OPCAO_ATIVOS) {
            System.out.println(mineradora.getAtivos());
        }
        if (opcao == OPCAO_PRODUTIVIDADE_MAQUINAS) {
            System.out.println(mineradora.getProdutividadeMaquinas());
        }
        if (opcao == OPCAO_PRODUTIVIDADE_OPERARIOS) {
            System.out.println(mineradora.getProdutividadeOperarios());
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

}
