package hospital.view.controller;

import hospital.GerenciadorLogin;
import hospital.views.ListaPacientes;
import hospital.views.ListaUsuarios;
import hospital.views.ListaVisitantes;
import hospital.views.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 78522
 */
public class MenuPrincipalController {

    public static interface Display {

        void setAcaoMenuPacientes(ActionListener listener);

        void setAcaoMenuVisitantes(ActionListener listener);

        void setAcaoMenuUsuarios(ActionListener listener);

        void setAcaoLogoff(ActionListener listener);

        void setAcessoBtnPacientes(boolean acesso);

        void setAcessoBtnVisitantes(boolean acesso);

        void setAcessoBtnUsuarios(boolean acesso);

        void fechar();
    }

    private final Display tela;

    public MenuPrincipalController(Display tela) {
        this.tela = tela;
        inicializar();
    }

    private void inicializar() {
        configurarVisibilidade();
        tela.setAcaoMenuPacientes((ActionEvent e) -> menuPacientes());
        tela.setAcaoMenuVisitantes((ActionEvent e) -> menuVisitantes());
        tela.setAcaoMenuUsuarios((ActionEvent e) -> menuUsuarios());
        tela.setAcaoLogoff((ActionEvent e) -> logoff());
    }

    private void configurarVisibilidade() {
        switch (GerenciadorLogin.usuarioLogado.getTipo()) {
            case GERENTE:
                tela.setAcessoBtnUsuarios(true);
            case MEDICO:
                tela.setAcessoBtnPacientes(true);
            case ATENDENTE:
                tela.setAcessoBtnVisitantes(true);
                break;
        }
    }

    private void menuPacientes() {
        new ListaPacientes().setVisible(true);
    }

    private void menuVisitantes() {
        new ListaVisitantes().setVisible(true);
    }

    private void menuUsuarios() {
        new ListaUsuarios().setVisible(true);
    }

    private void logoff() {
        GerenciadorLogin.logoff();
        new Login().setVisible(true);
        tela.fechar();
    }

}
