package controleVisitante;

import controleUsuario.*;
import modeloUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeloVisitante.Visitante;

public class CadastroVisitanteController {

    private Display tela;
    private TableModelVisitante modelo;

    //interface de comunicação entre o controller e a view

    public static interface Display {

        String getIdPaciente();

        String getNome();

        String getStatus();

        void limparCampos();

        void setAcaoSalvar(ActionListener listener);

        void configurarDados(TableModelVisitante modelo);
    }

    public CadastroVisitanteController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        modelo = new TableModelVisitante();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
    }

    private void salvar() {
        Visitante visitante = new Visitante(System.currentTimeMillis(), tela.getIdPaciente(), tela.getNome(), tela.getStatus());
        modelo.addVisitante(visitante);
        tela.limparCampos();
    }

}
