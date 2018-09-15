package exercicios.veiculo.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public abstract class Menu {

    private final List<OpcaoMenu> opcoes = new ArrayList();

    private final Scanner teclado;
    private String titulo;

    public List<OpcaoMenu> getOpcoes() {
        return opcoes;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Menu(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        OpcaoMenu opcao;
        do {
            System.out.println(titulo);
            imprimeOpcoes();
            opcao = toOpcao(getInput());
        } while (tratarOpcao(opcao));
    }

    public void imprimeOpcoes() {
        opcoes.stream().forEach((opcoe) -> System.out.println(opcoe.getString()));
    }

    public OpcaoMenu toOpcao(String input) {
        for (OpcaoMenu opcoe : opcoes) {
            if (input.equalsIgnoreCase(String.valueOf(opcoe.getId()))) {
                return opcoe;
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
}
