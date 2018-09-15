package executor;

import modelo.Usuario;
import dao.UsuarioDAO;
import hospital.views.Login;


public class GerenciadorLogin {

    public static Usuario usuarioLogado = null;

    public static boolean isLogado() {
        return usuarioLogado != null;
    }

    public static boolean verificaLogin(String username, String senha) {
        Usuario usuario = UsuarioDAO.getInstance().verificaLogin(username, senha);
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
