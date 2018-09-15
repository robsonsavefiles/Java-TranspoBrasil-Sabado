
package br.com.oficinaV2.presenter;

import br.com.oficinaV2.modelo.Veiculo;
import br.com.oficinaV2.repositorio.RepositorioVeiculo;
import br.com.oficinaV2.repositorio.RepositorioVeiculoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author 89087
 */
public class TelaCadastrarVeiculoPresenter implements Presenter {

    public static interface Display {

        public String getTextoPesquisa();

        public void configurarAcaoPesquisar(ActionListener listener);

        public void configurarDados(TableModel dados);

        public void mostrar();

        public void ocultar();

    }

    public TelaCadastrarVeiculoPresenter(Display tela) {

        this.tela = tela;
        InicializarDados();
    }

    private Display tela;
    private TableModelVeiculo dados;
    private RepositorioVeiculo repositorio = new RepositorioVeiculoImpl();

    @Override
    public void bind() {
        tela.configurarDados(dados);
        tela.configurarAcaoPesquisar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });

    }

    @Override
    public void mostrar() {
        tela.mostrar();
    }

    @Override
    public void ocultar() {
        tela.ocultar();
    }

    public void InicializarDados() {
        dados = new TableModelVeiculo();
        dados.setVeiculos(repositorio.buscarTodos());

    }

    public void pesquisar() {
        Veiculo veiculo = repositorio.buscarPorPlaca(tela.getTextoPesquisa());
        List<Veiculo> lista = new ArrayList<>();
        if (veiculo != null) {
            lista.add(veiculo);

        }

        dados.setVeiculos(lista);
    }
}
