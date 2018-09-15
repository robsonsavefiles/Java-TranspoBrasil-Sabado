package hospital.view.controller;

import hospital.dao.DaoUsuario;
import hospital.model.Usuario;
import hospital.views.CadastroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ListaUsuariosController implements ActionListener {

    public static interface Display {

        void setAcaoAdd(ActionListener listener);

        void setAcaoEdit(ActionListener listener);

        void setAcaoRemove(ActionListener listener);

        void configurarTabela(TableModelUsuario model);

        Usuario getSelected();
    }

    private final Display tela;
    private TableModelUsuario model;

    public ListaUsuariosController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        model = new TableModelUsuario(getDados());
        tela.configurarTabela(model);
        tela.setAcaoAdd((ActionEvent e) -> add());
        tela.setAcaoEdit((ActionEvent e) -> adit());
        tela.setAcaoRemove((ActionEvent e) -> remove());
    }

    private void add() {
        new CadastroUsuario(this).setVisible(true);
    }

    private void adit() {
        Usuario usuarioSelecionado = tela.getSelected();
        if (usuarioSelecionado != null) {
            new CadastroUsuario(this, usuarioSelecionado).setVisible(true);
        }
    }

    private void remove() {
        Usuario usuarioSelecionado = tela.getSelected();
        if (usuarioSelecionado != null) {
            DaoUsuario.getInstance().delete(usuarioSelecionado);
            updateTabela();
        }
    }

    private List<Usuario> getDados() {
        return DaoUsuario.getInstance().getTodos();
    }

    private void updateTabela() {
        model.updateLista(getDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTabela();
    }

}
