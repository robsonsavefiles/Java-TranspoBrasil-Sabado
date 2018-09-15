package avaliacao.questao26.menu;

import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class SubMenu extends Menu {

    private final String titulo;

    private OpcaoMenu opcaoEscolhida;

    public SubMenu(String titulo, Scanner teclado, OpcaoMenu... opcoes) {
        super(teclado);
        this.titulo = titulo;
        for (OpcaoMenu opcao : opcoes) {
            addOpcao(opcao);
        }
    }

    public SubMenu(String titulo, Scanner teclado) {
        super(teclado);
        this.titulo = titulo;
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (getOpcoes().contains(opcao)) {
            opcaoEscolhida = opcao;
            return false;
        }
        return super.tratarOpcao(opcao);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public OpcaoMenu getOpcaoEscolhida() {
        return opcaoEscolhida;
    }

}
