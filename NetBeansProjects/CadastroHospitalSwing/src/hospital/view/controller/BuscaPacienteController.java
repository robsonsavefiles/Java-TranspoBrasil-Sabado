package hospital.view.controller;

import dao.PacienteUtiDAO;
import modelo.Paciente;
import hospital.views.CadastroPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscaPacienteController implements ActionListener {

    public static interface Display {

        void setAcaoAdd(ActionListener listener);

        void setAcaoCancel(ActionListener listener);

        void setAcaoSelecionar(ActionListener listener);

        void configurarTabela(TableModelPaciente model);

        Paciente getSelected();

        void fechar();
    }

    private final Display tela;
    private TableModelPaciente model;
    private PacienteSelectionListener listener;

    public BuscaPacienteController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    public BuscaPacienteController(Display tela, PacienteSelectionListener listener) {
        this.tela = tela;
        this.listener = listener;
        inicializar();
    }

    private void inicializar() {
        model = new TableModelPaciente(getDados());
        tela.configurarTabela(model);
        tela.setAcaoAdd((ActionEvent e) -> add());
        tela.setAcaoSelecionar((ActionEvent e) -> selecionar());
        tela.setAcaoCancel((ActionEvent e) -> cancel());
    }

    private void add() {
        new CadastroPaciente(this).setVisible(true);
    }

    private void selecionar() {
        Paciente pacienteSelecionado = tela.getSelected();
        if (pacienteSelecionado != null) {
            listener.pacienteSelected(pacienteSelecionado);
            tela.fechar();
        }
    }

    private void cancel() {
        tela.fechar();
    }

    private List<Paciente> getDados() {
        return PacienteUtiDAO.getInstance().getTodosSemSaida();
    }

    private void updateTabela() {
        model.updateLista(getDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTabela();
    }

}