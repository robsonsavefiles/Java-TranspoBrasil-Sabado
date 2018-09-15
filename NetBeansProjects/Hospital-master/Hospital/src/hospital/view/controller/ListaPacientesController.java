package hospital.view.controller;

import hospital.dao.DaoPaciente;
import hospital.model.Paciente;
import hospital.views.CadastroPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ListaPacientesController implements ActionListener {

    public static interface Display {

        void setAcaoAdd(ActionListener listener);

        void setAcaoEdit(ActionListener listener);

        void setAcaoRemove(ActionListener listener);

        void setAcaoSaida(ActionListener listener);

        void configurarTabela(TableModelPaciente model);

        Paciente getSelected();
    }

    private final Display tela;
    private TableModelPaciente model;

    public ListaPacientesController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        model = new TableModelPaciente(getDados());
        tela.configurarTabela(model);
        tela.setAcaoAdd((ActionEvent e) -> add());
        tela.setAcaoEdit((ActionEvent e) -> edit());
        tela.setAcaoRemove((ActionEvent e) -> remove());
        tela.setAcaoSaida((ActionEvent e) -> saida());
    }

    private void add() {
        new CadastroPaciente(this).setVisible(true);
    }

    private void edit() {
        Paciente pacienteSelecionado = tela.getSelected();
        if (pacienteSelecionado != null) {
            new CadastroPaciente(this, pacienteSelecionado).setVisible(true);
        }
    }

    private void remove() {
        Paciente pacienteSelecionado = tela.getSelected();
        if (pacienteSelecionado != null) {
            DaoPaciente.getInstance().delete(pacienteSelecionado);
            updateTabela();
        }
    }

    private void saida() {
        Paciente pacienteSelecionado = tela.getSelected();
        if (pacienteSelecionado != null) {
            pacienteSelecionado.setDataSaida(LocalDateTime.now());
            DaoPaciente.getInstance().salvar(pacienteSelecionado);
            updateTabela();
        }
    }

    private List<Paciente> getDados() {
        return DaoPaciente.getInstance().getTodosSemSaida();
    }

    private void updateTabela() {
        model.updateLista(getDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTabela();
    }

}
