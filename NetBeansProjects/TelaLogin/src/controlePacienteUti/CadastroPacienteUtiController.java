
package controlePacienteUti;

import controleUsuario.*;
import modeloUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import modeloPaciente.Paciente;

public class CadastroPacienteUtiController {
    
    private Display tela;
    private TableModelPaciente modelo;
   
    public static interface Display{
        
        String getSituacao();
        String getNome();
        String getProcedimento();
        Date getData_entrada();
        Date getData_saida();
        void limparCampos();
        void setAcaoSalvar(ActionListener listener);
        void configurarDados(TableModelPaciente modelo);
    } 

    public CadastroPacienteUtiController(Display tela) {
        this.tela = tela;
        inicializar();
    }
    
    private void inicializar(){
        modelo = new TableModelPaciente();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               salvar();
            }
        });
    }

    private void salvar(){
        Paciente paciente = new Paciente(System.currentTimeMillis(),tela.getSituacao(),tela.getNome(),tela.getProcedimento(),
                                                    tela.getData_entrada(),tela.getData_saida()); 
       // modelo.addPaciente(paciente);
        tela.limparCampos();
    }

}
