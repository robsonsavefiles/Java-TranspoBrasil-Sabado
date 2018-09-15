package br.com.proway.java.eventbus;

import br.com.proway.java.builder.Cliente;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author 89087
 */
public class TabelaClientesPresenter implements Presenter {

    private Display view;
    private ConfigurarTabela dados;
    
    static interface Display {

        int getItemSelecionado();
        void setDados(ClienteTableModel dados);
        void setAcaoSelecionar(ListSelectionEvent listener);
            
    }

    @Override
    public void bind() {
        
        view.setAcaoSelecionar(new ListSelectionEvent(){
            @Override
            public void valueChanged(ListSelectionEvent e){
            Cliente item = dados.getItem(view.getItemSelecionado());
            NotificadorEventos instance = NotificadorEventos.getInstance();
            instance.disparaEventos(new EventosClienteSelecionado(item));
            
            }
            )};

    }
}
