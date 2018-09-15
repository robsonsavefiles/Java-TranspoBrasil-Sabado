/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import cadastro.UsuarioDAO;
import dados.Usuario;
import estado.Tipo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 88178
 */
public class ControleCadastroUsuario {

    private final Display tela;
    private ActionListener listener;

    public static interface Display {

        String getLogin();

        String getSenha();

        Tipo getCredencial();

        void configurarTipo(DefaultComboBoxModel modelo);

        void addAcaoSalvar(ActionListener listener);

        void addAcaoCancelar(ActionListener listener);

        void fecharTela();

    }

    public ControleCadastroUsuario(Display tela, ActionListener listener) {
        this.tela = tela;
        this.listener = listener;
        inicializar();
    }

    public ControleCadastroUsuario(Display tela) {
        this.tela = tela;
        inicializar();
    }

    public void inicializar() {
        tela.addAcaoSalvar((ActionEvent e) -> salvar());
        tela.addAcaoCancelar((ActionEvent e) -> voltar());
        configurarTipo();
    }

    private void salvar() {
        
        Usuario usuario = new Usuario();

        usuario.setLogin(tela.getLogin());
        usuario.setSenha(tela.getSenha());
        usuario.setTipo(tela.getCredencial());

        UsuarioDAO.getInstance().salvar(usuario);

        if (listener != null) {
            listener.actionPerformed(new ActionEvent(tela, ActionEvent.ACTION_PERFORMED, null));
        }
        tela.fecharTela();
    }

    private void voltar() {
        tela.fecharTela();
    }

    private void configurarTipo() {
        tela.configurarTipo(new DefaultComboBoxModel(Tipo.values()));
    }

}
