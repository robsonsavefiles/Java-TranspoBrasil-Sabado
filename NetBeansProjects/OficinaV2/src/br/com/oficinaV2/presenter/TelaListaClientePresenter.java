package br.com.oficinaV2.presenter;

import br.com.oficinaV2.modelo.Cliente;
import br.com.oficinaV2.modelo.Veiculo;
import br.com.oficinaV2.repositorio.RepositorioClienteImpl;
import br.com.oficinaV2.repositorio.RepositorioVeiculo;
import br.com.oficinaV2.repositorio.RepositorioVeiculoImpl;
import com.sun.xml.internal.ws.client.ContentNegotiation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author 89087
 */
public class TelaListaClientePresenter implements Presenter {

    private Display tela;
    private TableModelCliente modelo;
    private RepositorioClienteImpl repositorio;

    public static interface Display {

        public String getTextoPesquisa();

        void setAcaoPesquisar(ActionListener listener);

        void configurarDados(TableModel modelo);

        public void mostrar();

        public void ocultar();
    }

    public TelaListaClientePresenter(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {

        modelo = new TableModelCliente();
        tela.configurarDados(modelo);
        modelo.setCliente(repositorio.buscarTodos());

    }

    @Override
    public void bind() {
        tela.configurarDados(modelo);
        tela.setAcaoPesquisar(new ActionListener() {

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

    private void pesquisar() {
        Cliente cliente = repositorio.buscarPorNome(tela.getTextoPesquisa());
        List<Cliente> lista = new ArrayList<>();
        if(cliente != null){
            lista.add(cliente);
        }
        modelo.setCliente(lista);
        
    }
}
