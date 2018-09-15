package controle;

import cadastro.UsuarioDAO;
import dados.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tabela.UsuarioTableModel;
import tela.CadastroUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * tabela - configurar Cadastrar - definir o que fazer Remover - definir o que
 * fazer Voltar - definir o que fazer Tela - Como fechar
 *
 * @author 88178
 */
public class ControleLista implements ActionListener {

    private final Display tela;
    private UsuarioTableModel modelo;

    public static interface Display {
        
        Usuario getSelecionado();

        void configurarTabela(UsuarioTableModel model);

        void addAcaoCadastrar(ActionListener listener);

        void addAcaoRemover(ActionListener listener);

        void addAcaoVoltar(ActionListener listener);

        void fecharTela();
    }

    public ControleLista(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {       
        this.modelo = new UsuarioTableModel(UsuarioDAO.getInstance().buscarTodos());
        tela.configurarTabela(modelo);
        tela.addAcaoCadastrar((ActionEvent e) -> cadastrar());
        tela.addAcaoRemover((ActionEvent e) -> remover());
        tela.addAcaoVoltar((ActionEvent e) -> voltar());
    }

    private void cadastrar() {
        new CadastroUsuario(this).setVisible(true);
    }

    private void remover() {
        
        Usuario usuario = tela.getSelecionado();
        if (usuario != null) {
            UsuarioDAO.getInstance().removerUsuario(usuario);
            atualizarTabela();
        }
    }

    private void voltar() {
        tela.fecharTela();
    }
 

    @Override
    public void actionPerformed(ActionEvent e) {
        atualizarTabela();
    }

    private void atualizarTabela() {       
        modelo.atualizarTabela(UsuarioDAO.getInstance().buscarTodos());
    }
}
