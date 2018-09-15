package executor;

import dao.UsuarioDAO;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author 89087
 */
public class Utilitariologin {

    public static Usuario usuarioLogado;

    public static boolean login(String login, String senha) throws SQLException, ClassNotFoundException {
        UsuarioDAO repositorio = new UsuarioDAO();
        Usuario usuario = repositorio.validarLogin(login,senha);
        if (usuario != null) {
            usuarioLogado = usuario;
            return true;
        }
        return false;

    }
}
