package executor;

import dao.UsuarioDAO;
import dao.VisitanteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paciente;
import modelo.Usuario;

/**
 *
 * @author 89087
 */
public class Executor {

    public static void main(String[] args) {

        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario usuario;

        try {
            usuario = usuDAO.buscar("439156944");
            System.out.println(usuario.getId());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
