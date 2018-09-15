package hospital.view.controller;

import hospital.dao.DaoPaciente;
import hospital.model.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 78522
 */
public class CadastroPacienteController {
    
    public static interface Display {
        
        void setAcaoConfirmar(ActionListener listener);
        
        void setAcaoCancelar(ActionListener listener);
        
        void configurarSituacao(DefaultComboBoxModel model);
        
        void configurarProcedimento(DefaultComboBoxModel model);
        
        void setTextNome(String nome);
        
        void setSituacao(Paciente.Situacao situacao);
        
        void setProcedimento(Paciente.Procedimento procedimento);
        
        String getNome();
        
        Paciente.Situacao getSituacao();
        
        Paciente.Procedimento getProcedimento();
        
        void fechar();
        
    }
    
    private final Display tela;
    private final Paciente paciente;
    private ActionListener listener;
    
    public CadastroPacienteController(Display tela) {
        this.tela = tela;
        this.paciente = new Paciente();
        inicializar();
    }
    
    public CadastroPacienteController(Display tela, ActionListener listener) {
        this.tela = tela;
        this.listener = listener;
        this.paciente = new Paciente();
        inicializar();
    }
    
    public CadastroPacienteController(Display tela, ActionListener listener, Paciente paciente) {
        this.tela = tela;
        this.listener = listener;
        this.paciente = paciente;
        inicializar();
    }
    
    private void inicializar() {
        configurarComboBox();
        setCampos();
        tela.setAcaoConfirmar((ActionEvent e) -> confirmar());
        tela.setAcaoCancelar((ActionEvent e) -> cancelar());
    }
    
    private void configurarComboBox() {
        tela.configurarSituacao(new DefaultComboBoxModel(Paciente.Situacao.values()));
        tela.configurarProcedimento(new DefaultComboBoxModel(Paciente.Procedimento.values()));
    }
    
    private void confirmar() {
        setInfoPaciente();
        DaoPaciente.getInstance().salvar(paciente);
        listener.actionPerformed(new ActionEvent(tela, ActionEvent.ACTION_PERFORMED, null));
        tela.fechar();
    }
    
    private void cancelar() {
        tela.fechar();
    }
    
    private void setCampos() {
        if (paciente != null) {
            tela.setTextNome(paciente.getNome());
            tela.setSituacao(paciente.getSituacao());
            tela.setProcedimento(paciente.getProcedimento());
        }
    }
    
    private void setInfoPaciente() {
        paciente.setNome(tela.getNome());
        paciente.setSituacao(tela.getSituacao());
        paciente.setProcedimento(tela.getProcedimento());
    }
}
