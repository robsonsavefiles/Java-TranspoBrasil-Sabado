
package br.com.app.controle;

import br.com.app.modelo.Contato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroContatoController {
    
    private Display tela;
    private TableModelContato modelo;
    //interface de comunicação entre o controller e a view
    public static interface Display{
        
        String getNome();
        String getTelefone();
        void limparCampos();
        void setAcaoSalvar(ActionListener listener);
        void configurarDados(TableModelContato modelo);
    } 

    public CadastroContatoController(Display tela) {
        this.tela = tela;
        inicializar();
    }
    
    private void inicializar(){
        modelo = new TableModelContato();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               salvar();
            }
        });
    }
    
    private void salvar(){
        Contato contato = new Contato(System.currentTimeMillis(),tela.getNome(),tela.getTelefone()); 
        modelo.addContato(contato);
        tela.limparCampos();
    }

}
