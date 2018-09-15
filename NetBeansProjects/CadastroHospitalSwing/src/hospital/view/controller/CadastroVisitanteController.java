package hospital.view.controller;

import dao.VisitanteDAO;
import modelo.Paciente;
import modelo.Visitante;
import hospital.views.BuscaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 78522
 */
public class CadastroVisitanteController implements PacienteSelectionListener {

    public static interface Display {

        void setAcaoConfirmar(ActionListener listener);

        void setAcaoCancelar(ActionListener listener);

        void setAcaoAddPaciente(ActionListener listener);

        void configurarStatus(DefaultComboBoxModel model);

        void setTextNome(String nome);

        void setTextPaciente(String paciente);

        void setStatus(Visitante.Status status);

        String getNome();

        Visitante.Status getStatus();

        void fechar();

    }

    private final Display tela;
    private final Visitante visitante;
    private ActionListener listener;

    public CadastroVisitanteController(Display tela) {
        this.tela = tela;
        this.visitante = new Visitante();
        inicializar();
    }

    public CadastroVisitanteController(Display tela, ActionListener listener) {
        this.tela = tela;
        this.listener = listener;
        this.visitante = new Visitante();
        inicializar();
    }

    public CadastroVisitanteController(Display tela, ActionListener listener, Visitante visitante) {
        this.tela = tela;
        this.listener = listener;
        this.visitante = visitante;
        inicializar();
    }

    private void inicializar() {
        configurarComboBox();
        setCampos();
        tela.setAcaoConfirmar((ActionEvent e) -> confirmar());
        tela.setAcaoCancelar((ActionEvent e) -> cancelar());
        tela.setAcaoAddPaciente((ActionEvent e) -> addPaciente());
    }

    private void configurarComboBox() {
        tela.configurarStatus(new DefaultComboBoxModel(Visitante.Status.values()));
    }

    private void confirmar() {
        setInfoVisitante();
       VisitanteDAO.getInstance().salvar(visitante);
        listener.actionPerformed(new ActionEvent(tela, ActionEvent.ACTION_PERFORMED, null));
        tela.fechar();
    }

    private void cancelar() {
        tela.fechar();
    }

    private void addPaciente() {
        new BuscaPaciente(this).setVisible(true);
    }

    @Override
    public void pacienteSelected(Paciente paciente) {
        visitante.setPaciente(paciente);
        tela.setTextPaciente(paciente.getNome());
    }

    private void setCampos() {
        if (visitante != null) {
            tela.setTextNome(visitante.getNome());
            if (visitante.getPaciente() != null) {
                tela.setTextPaciente(visitante.getPaciente().getNome());
            }
            tela.setStatus(visitante.getStatus());
        }
    }

    private void setInfoVisitante() {
        visitante.setNome(tela.getNome());
        visitante.setStatus(tela.getStatus());
    }
}
