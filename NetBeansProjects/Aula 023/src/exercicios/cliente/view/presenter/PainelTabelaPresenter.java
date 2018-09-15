package exercicios.cliente.view.presenter;

import exemplos.observer.Observador;
import exercicios.cliente.EventoClienteSelecionado;
import exercicios.cliente.NotificadorDeEventos;
import exercicios.cliente.dao.ClienteDao;
import exercicios.cliente.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author 78522
 */
public class PainelTabelaPresenter implements Presenter {

    public static interface Display {

        void configurarTabela(ClienteTableModel model);

        Cliente getSelecionado();

        void setAcaoSelecionar(ListSelectionListener listener);

    }

    private final Display display;

    public PainelTabelaPresenter(Display display) {
        this.display = display;
    }

    @Override
    public void bind() {
        display.configurarTabela(new ClienteTableModel(ClienteDao.getInstance().getTodos()));
        display.setAcaoSelecionar((ListSelectionEvent e) -> {
            NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
            instance.dispararEvento(new EventoClienteSelecionado(display.getSelecionado()));
        });
    }

}
