package exercicios.veiculo.cadastro;

import exercicios.veiculo.model.InfoCampo;
import exercicios.veiculo.repositorio.Repositorio;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuOrdenacao extends Menu {

    public static final OpcaoMenu OPCAO_ORDERNAR_SAIR = new OpcaoMenu(0, "Voltar ao menu anterior");

    private final Repositorio repositorio;

    public MenuOrdenacao(String titulo, Scanner teclado, Repositorio repositorio, Collection<InfoCampo> campos) {
        super(teclado);
        setTitulo(titulo);
        this.repositorio = repositorio;
        int i = 0;
        for (InfoCampo campo : campos) {
            addOpcao(new OpcaoMenu(i, "Ordenar por " + campo.getNome(), campo));
            i++;
        }
        OPCAO_ORDERNAR_SAIR.setId(i);
        addOpcao(OPCAO_ORDERNAR_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_ORDERNAR_SAIR) {
            return false;
        }
        if (getOpcoes().contains(opcao)) {
            listar(opcao.getCampo());
            return false;
        }
        return super.tratarOpcao(opcao);
    }

    public void listar(InfoCampo campo) {
        System.out.println(repositorio.infoString(repositorio.getTodos(campo)));
    }

}
