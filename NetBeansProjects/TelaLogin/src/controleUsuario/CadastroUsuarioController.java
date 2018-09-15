
package controleUsuario;

import modeloUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioController {
    
    private Display tela;
    private TableModelUsuario modelo;
    //interface de comunicação entre o controller e a view
    public static interface Display{
        
        String getLogin();
        String getSenha();
        String getTipo();
        void limparCampos();
        void setAcaoSalvar(ActionListener listener);
        void configurarDados(TableModelUsuario modelo);
    } 

    public CadastroUsuarioController(Display tela) {
        this.tela = tela;
        inicializar();
    }
    
    private void inicializar(){
        modelo = new TableModelUsuario();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               salvar();
            }
        });
    }

    private void salvar(){
        Usuario usuario = new Usuario(System.currentTimeMillis(),tela.getLogin(),tela.getSenha(),tela.getTipo()); 
        modelo.addContato(usuario);
        tela.limparCampos();
    }

}
