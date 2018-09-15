/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import cadastro.UsuarioDAO;
import cadastro.UtilitarioLogin;
import dados.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tela.TelaInicial;

/**
 *
 * @author 88178
 */
public class ControladorLogin {
    
    private Display tela;
    private ActionListener listener;
    
    public static interface Display{
        String getLogin();
        
        String getSenha();
        
        void addAcaoEntrar(ActionListener listener);
        
        void addAcaoCancelar(ActionListener listener);
        
        void fecharTela();
    }

    public ControladorLogin(Display tela) {
        this.tela = tela;
        inicializar();
    }
    
    public void inicializar(){
        tela.addAcaoEntrar((ActionEvent e) -> validar() );
        tela.addAcaoCancelar((ActionEvent e) -> cancelar());
    }
    
    public void cancelar(){
        new TelaInicial().setVisible(true);
        tela.fecharTela();
    }
    
    public void validar(){
        UtilitarioLogin.login(tela.getLogin(),tela.getSenha());
          
    }
    
}
