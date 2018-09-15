package hospital.view.controller;

import hospital.dao.DaoUsuario;
import hospital.model.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author 78522
 */
public class CadastroUsuarioController {

    public static interface Display {

        void setAcaoConfirmar(ActionListener listener);

        void setAcaoCancelar(ActionListener listener);

        void configurarTipo(DefaultComboBoxModel model);

        void setTextNome(String nome);

        void setTextLogin(String login);

        void setTextSenha(String senha);

        void setTipo(Usuario.Tipo tipo);

        String getNome();

        String getLogin();

        String getSenha();

        Usuario.Tipo getTipo();

        void fechar();

    }

    private final Display tela;
    private final Usuario usuario;
    private ActionListener listener;

    public CadastroUsuarioController(Display tela) {
        this.tela = tela;
        this.usuario = new Usuario();
        inicializar();
    }

    public CadastroUsuarioController(Display tela, ActionListener listener) {
        this.tela = tela;
        this.listener = listener;
        this.usuario = new Usuario();
        inicializar();
    }

    public CadastroUsuarioController(Display tela, ActionListener listener, Usuario usuario) {
        this.tela = tela;
        this.listener = listener;
        this.usuario = usuario;
        inicializar();
    }

    private void inicializar() {
        configurarComboBox();
        setCampos();
        tela.setAcaoConfirmar((ActionEvent e) -> confirmar());
        tela.setAcaoCancelar((ActionEvent e) -> cancelar());
    }

    private void configurarComboBox() {
        tela.configurarTipo(new DefaultComboBoxModel(Usuario.Tipo.values()));
    }

    private void confirmar() {
        setInfoUsuario();
        DaoUsuario.getInstance().salvar(usuario);
        listener.actionPerformed(new ActionEvent(tela, ActionEvent.ACTION_PERFORMED, null));
        tela.fechar();
    }

    private void cancelar() {
        tela.fechar();
    }

    private void setCampos() {
        if (usuario != null) {
            tela.setTextNome(usuario.getNome());
            tela.setTextLogin(usuario.getLogin());
            tela.setTextSenha(usuario.getSenha());
            tela.setTipo(usuario.getTipo());
        }
    }

    private void setInfoUsuario() {
        usuario.setNome(tela.getNome());
        usuario.setLogin(tela.getLogin());
        usuario.setSenha(tela.getSenha());
        usuario.setTipo(tela.getTipo());
    }
}
