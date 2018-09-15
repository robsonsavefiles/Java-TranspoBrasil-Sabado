package avaliacao.questao26.menus;

import avaliacao.questao26.validacoes.Erro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public abstract class Menu {

    private final List<OpcaoMenu> opcoes = new ArrayList();

    private final Scanner teclado;

    public List<OpcaoMenu> getOpcoes() {
        return opcoes;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public Menu(Scanner teclado) {
        this.teclado = teclado;
    }

    public abstract String getTitulo();

    public void mostrarMenu() {
        OpcaoMenu opcao;
        do {
            System.out.println(getTitulo());
            imprimeOpcoes();
            opcao = toOpcao(getInput());
        } while (tratarOpcao(opcao));
    }

    public void imprimeOpcoes() {
        opcoes.stream().forEach((opcoe) -> System.out.println(opcoe.getString()));
    }

    public OpcaoMenu toOpcao(String input) {
        for (OpcaoMenu opcao : opcoes) {
            if (input.equalsIgnoreCase(String.valueOf(opcao.getId()))) {
                return opcao;
            }
        }
        return null;
    }

    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == null) {
            System.out.println("Opção inválida!");
        }
        return true;
    }

    public void addOpcao(OpcaoMenu opcao) {
        opcoes.add(opcao);
    }

    public String getInput() {
        return teclado.nextLine();
    }

    public void imprimirErros(List<Erro> erros) {
        erros.stream().forEach((erro) -> System.out.println(erro.getMensagem()));
    }
}
