package br.com.oficinaV2.presenter;

import br.com.oficinaV2.base.EventosNavegacao;
import br.com.oficinaV2.base.NotificadorDeEventos;
import br.com.OficinaV2.base.Telas;
import com.sun.glass.ui.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 89087
 */
public class TelaPrincipalPresenter implements Presenter {

    public static interface Display {

        public void setAcaoListarVeiculo(ActionListener listener);

        public void setAcaoNovoVeiculo(ActionListener listener);

        public void setAcaoListarCliente(ActionListener listener);

        public void setAcaoNovoCliente(ActionListener listener);

        public void setAcaoListarOrdemServico(ActionListener listener);

        public void setAcaoNovaOrdemServico(ActionListener listener);
        
         public void mostrar();
         public void esconder();

    }

    private Display tela;

    public TelaPrincipalPresenter(Display tela) {
        this.tela = tela;
    }

    @Override
    public void bind() {
        tela.setAcaoListarVeiculo((ActionEvent e) -> {
            NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
            instance.dispararEvento(new EventosNavegacao(Telas.LISTA_VEICULOS));
        });
         tela.setAcaoNovoVeiculo((ActionEvent e) -> {
             NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
             instance.dispararEvento(new EventosNavegacao(Telas.CADASTRO_VEICULOS));
        });
         tela.setAcaoListarCliente((ActionEvent e) -> {
             NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
             instance.dispararEvento(new EventosNavegacao(Telas.LISTA_CLIENTE));
        });
          tela.setAcaoNovoCliente((ActionEvent e) -> {
              NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
              instance.dispararEvento(new EventosNavegacao(Telas.CADASTRAR_CLIENTE));
        });
         tela.setAcaoListarOrdemServico((ActionEvent e) -> {
             NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
             instance.dispararEvento(new EventosNavegacao(Telas.LISTA_ORDEM));
        });
         tela.setAcaoNovaOrdemServico((ActionEvent e) -> {
             NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
             instance.dispararEvento(new EventosNavegacao(Telas.CADASTRAR_ORDEM));
        });

    }

    @Override
    public void mostrar() {
        tela.mostrar();
   
    }

    @Override
    public void ocultar() {
        
         tela.esconder();
    }

}
