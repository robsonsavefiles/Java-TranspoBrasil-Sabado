package br.com.tiagodws.hospital.view.controller;

import br.com.tiagodws.hospital.dao.DaoVisitante;
import br.com.tiagodws.hospital.model.Visitante;
import br.com.tiagodws.hospital.view.CadastroVisitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ListaVisitantesController implements ActionListener {

    public static interface Display {

        void setAcaoAdd(ActionListener listener);

        void setAcaoEdit(ActionListener listener);

        void setAcaoRemove(ActionListener listener);

        void setAcaoEntrada(ActionListener listener);

        void setAcaoEspera(ActionListener listener);

        void setAcaoSaida(ActionListener listener);

        void configurarTabela(TableModelVisitante model);

        Visitante getSelected();
    }

    private final Display tela;
    private TableModelVisitante model;

    public ListaVisitantesController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        model = new TableModelVisitante(getDados());
        tela.configurarTabela(model);
        tela.setAcaoAdd((ActionEvent e) -> add());
        tela.setAcaoEdit((ActionEvent e) -> edit());
        tela.setAcaoRemove((ActionEvent e) -> remove());
        tela.setAcaoEntrada((ActionEvent e) -> entrada());
        tela.setAcaoEspera((ActionEvent e) -> espera());
        tela.setAcaoSaida((ActionEvent e) -> saida());
    }

    private void add() {
        new CadastroVisitante(this).setVisible(true);
    }

    private void edit() {
        Visitante visitanteSelecionado = tela.getSelected();
        if (visitanteSelecionado != null) {
            new CadastroVisitante(this, visitanteSelecionado).setVisible(true);
        }
    }

    private void remove() {
        Visitante visitanteSelecionado = tela.getSelected();
        if (visitanteSelecionado != null) {
            DaoVisitante.getInstance().delete(visitanteSelecionado);
            updateTabela();
        }
    }

    private void entrada() {
        updateStatus(Visitante.Status.ENTRADA);
    }

    private void espera() {
        updateStatus(Visitante.Status.ESPERA);
    }

    private void saida() {
        updateStatus(Visitante.Status.SAIDA);
    }

    private void updateStatus(Visitante.Status status) {
        Visitante visitanteSelecionado = tela.getSelected();
        if (visitanteSelecionado != null) {
            visitanteSelecionado.setStatus(status);
            DaoVisitante.getInstance().salvar(visitanteSelecionado);
            updateTabela();
        }
    }

    private List<Visitante> getDados() {
        return DaoVisitante.getInstance().getTodos();
    }

    private void updateTabela() {
        model.updateLista(getDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTabela();
    }

}
