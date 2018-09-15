package hospital.view.controller;

import executor.GerenciadorLogin;
import hospital.views.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController {

    public static interface Display {

        void setAcaoLogin(ActionListener listener);

        void setAcaoCancelar(ActionListener listener);

        String getLogin();

        String getSenha();

        void fechar();
    }

    private final Display tela;

    public LoginController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        tela.setAcaoLogin((ActionEvent e) -> login());
        tela.setAcaoCancelar((ActionEvent e) -> cancelar());
    }

    private void login() {
        if (GerenciadorLogin.verificaLogin(tela.getLogin(), tela.getSenha())) {
            new Principal().setVisible(true);
            tela.fechar();
        }
    }

    private void cancelar() {
        tela.fechar();
    }
}
