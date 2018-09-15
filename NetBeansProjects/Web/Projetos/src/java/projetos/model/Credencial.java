package projetos.model;

/**
 *
 * @author 78522
 */
public class Credencial implements UsuarioCredencial {

    private String login;
    private String senha;

    @Override
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
