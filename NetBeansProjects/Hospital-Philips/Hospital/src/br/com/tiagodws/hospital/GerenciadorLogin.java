package br.com.tiagodws.hospital;

import br.com.tiagodws.hospital.model.Usuario;
import br.com.tiagodws.hospital.dao.DaoUsuario;
import br.com.tiagodws.hospital.view.Login;

/**
 *
 * @author 78522
 */
public class GerenciadorLogin {

    public static Usuario usuarioLogado = null;

    public static boolean isLogado() {
        return usuarioLogado != null;
    }

    public static boolean verificaLogin(String username, String senha) {
        Usuario usuario = DaoUsuario.getInstance().verificaLogin(username, senha);
        if (usuario != null) {
            usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    public static void logoff() {
        usuarioLogado = null;
        new Login().setVisible(true);
    }
}
