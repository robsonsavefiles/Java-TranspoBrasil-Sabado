
package controle;

import modelo.Contato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroContatoController {
    
    private Display tela;
    private TableModelContato modelo;
  
    public static interface Display{
        
    
        String getNome();
        String getTelefone();
        String getCpf();
        String getNumero();
        String getBairro();
        String getCidade();
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
        Contato contato = new Contato(tela.getNome(),tela.getCpf(),tela.getTelefone(),tela.getNumero(),tela.getBairro(),tela.getCidade()); 
        modelo.addContato(contato);
        tela.limparCampos();
    }

}
