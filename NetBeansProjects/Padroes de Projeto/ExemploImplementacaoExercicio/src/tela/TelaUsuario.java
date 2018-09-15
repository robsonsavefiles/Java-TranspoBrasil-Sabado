
package tela;

import dao.UsuarioDAO;
import enuns.DAOS;
import factory.DAOFactory;
import interfaces.DAO;

public class TelaUsuario {
    
    public static void main(String[] args) {
        DAO dao = DAOFactory.getDAO(DAOS.USUARIO);
        dao.inserir();
    }

}
