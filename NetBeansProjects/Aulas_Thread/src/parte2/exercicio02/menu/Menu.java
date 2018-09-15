package parte2.exercicio02.menu;

import parte2.exercicio02.menu.OpcaoMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public abstract class Menu {

    private Scanner scanner;
    private List<OpcaoMenu> opcoes = new ArrayList();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<OpcaoMenu> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<OpcaoMenu> opcoes) {
        this.opcoes = opcoes;
    }

    public void addOpcao(OpcaoMenu opcao) {
        opcoes.add(opcao);
    }

    public void mostrarMenu() {
        OpcaoMenu opcao = null;
        while (tratarOpcao(opcao)) {
            imprimirOpcoes();
            opcao = toOpcao(scanner.nextLine());
        }
    }

    public OpcaoMenu toOpcao(String id) {
        for (OpcaoMenu opcoe : opcoes) {
            if (id.equalsIgnoreCase(opcoe.getId())) {
                return opcoe;
            }
        }
        return null;
    }

    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (!opcoes.contains(opcao) && opcao != null) {
            System.out.println("Opção inválida!");
        }
        return true;
    }

    public void imprimirOpcoes() {
        opcoes.stream().forEach((opcoe) -> System.out.println(opcoe.opcaoString()));
    }
}
