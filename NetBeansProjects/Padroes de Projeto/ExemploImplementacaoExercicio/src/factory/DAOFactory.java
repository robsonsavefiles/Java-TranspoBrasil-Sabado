
package factory;

import dao.UsuarioDAO;
import enuns.DAOS;
import interfaces.DAO;

public class DAOFactory {
    
    public static DAO getDAO(DAOS dao) {
        if (dao == DAOS.USUARIO) {
            return new UsuarioDAO();
        } 
        return null;
    }

}
