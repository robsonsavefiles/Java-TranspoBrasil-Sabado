package hospital.view.controller;

import hospital.model.Usuario;

/**
 *
 * @author 78522
 */
public interface TableInfoUsuario {

    public static String[] getColunas() {
        return new String[]{"ID", "Nome", "Login", "Tipo"};
    }

    default Object[] getLinha() {
        return new Object[]{getId(), getNome(), getLogin(), getTipo()};
    }

    public Long getId();

    public String getNome();

    public String getLogin();

    public Usuario.Tipo getTipo();

}
