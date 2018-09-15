
package br.com.proway.java.eventbus;

import br.com.proway.java.eventbus.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroContatoController {
    
    private Display tela;
    private TableModelCliente modelo;
  
    public static interface Display{
        
    
        String getNome();
        String getTelefone();
        String getCpf();
        String getNumero();
        String getBairro();
        String getCidade();
        void limparCampos();
        void setAcaoSalvar(ActionListener listener);
        void configurarDados(TableModelCliente modelo);
    } 

    public CadastroContatoController(Display tela) {
        this.tela = tela;
        inicializar();
    }
    
    private void inicializar(){
        modelo = new TableModelCliente();
        tela.configurarDados(modelo);
        tela.setAcaoSalvar(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               salvar();
            }
        });
    }
    
    private void salvar(){
        Cliente contato = new Cliente(tela.getNome(),tela.getCpf(),tela.getTelefone(),tela.getNumero(),tela.getBairro(),tela.getCidade()); 
        modelo.addContato(contato);
        tela.limparCampos();
    }

}
