package br.com.oficinaV2.base;

import br.com.oficinaV2.presenter.Presenter;
import br.com.oficinaV2.presenter.TelaPrincipalPresenter;
import br.com.oficinaV2.visualizacao.TelaPrincipal;
import javax.swing.JOptionPane;
import br.com.OficinaV2.base.Telas;
import br.com.oficinaV2.presenter.TelaListaClientePresenter;
import br.com.oficinaV2.presenter.TelaListaVeiculoPresenter;
import br.com.oficinaV2.visualizacao.TelaListaCliente;
import br.com.oficinaV2.visualizacao.TelaListaVeiculo;

/**
 *
 * @author 89087
 */
public class AppController implements OuvinteDeEventos<EventosNavegacao> {

    @Override
    public void onEventoDisparado(EventosNavegacao evento) {
        Telas destino = evento.getDestino();
        Presenter presenter = null;

        if (Telas.PRINCIPAL == destino) {
            //cria o presenter para a tela principal.
            presenter = new TelaPrincipalPresenter(new TelaPrincipal());
        }

        if (Telas.LISTA_VEICULOS == destino) {
            presenter = new TelaListaVeiculoPresenter(new TelaListaVeiculo());

        }
         if (Telas.LISTA_CLIENTE == destino) {
            presenter = new TelaListaClientePresenter(new TelaListaCliente());

        }
        if (Telas.CADASTRO_VEICULOS == destino) {
            JOptionPane.showConfirmDialog(null, "Novo veiculo");
        }
        if (presenter != null) {
            presenter.bind();
            presenter.mostrar();
        }
    }

    @Override
    public String getTipo() {
        return EventosNavegacao.class.getName();
    }

}
