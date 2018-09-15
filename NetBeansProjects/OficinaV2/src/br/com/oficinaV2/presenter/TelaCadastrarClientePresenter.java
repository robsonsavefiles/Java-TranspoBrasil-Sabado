package br.com.oficinaV2.presenter;

import br.com.oficinaV2.modelo.Cliente;
import br.com.oficinaV2.modelo.Veiculo;
import br.com.oficinaV2.repositorio.RepositorioClienteImpl;
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
public class TelaCadastrarClientePresenter implements Presenter {

    private Display tela;
    private Cliente cliente;
    private RepositorioClienteImpl repositorio;

    //interface de comunicação entre o controller e a view
    public static interface Display {

        String getNome();

        String getCpf();

        String getTelefone();

        String getPlacaVeiculo();

        String getOrdemServico();

        void limparCampos();

        void setAcaoSalvar(ActionListener listener);

        void mostrar();

        void ocultar();
    }

    public TelaCadastrarClientePresenter(Display tela){
        this.tela = tela;

    }

    @Override
    public void bind() {
        tela.setAcaoSalvar((ActionEvent e) -> salvar());
    }

    @Override
    public void mostrar() {
        tela.mostrar();

    }

    @Override
    public void ocultar() {
        tela.ocultar();

    }

    private void salvar() {
        configurarCliente();
        repositorio.salvar(cliente);
        ocultar();

    }

    public void configurarCliente() {
        cliente = new Cliente();
        cliente.setNome(tela.getNome());
        cliente.setCpf(tela.getCpf());
        cliente.setPlacadocarro(tela.getPlacaVeiculo());
        cliente.setTelefone(tela.getTelefone());

    }

}
