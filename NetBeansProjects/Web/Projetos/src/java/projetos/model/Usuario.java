package projetos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Usuario extends Entidade implements UsuarioCredencial {

    private String nome;
    private String login;
    private String senha;
    private List<Permissoes> permissoes = new ArrayList();

    public enum Permissoes {
        ADMINISTRADOR,
        SUPORTE,
        DESENVOLVIMENTO,
        QUALIDADE,
        TESTES;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha, List<Permissoes> autorizacoes) {
        super(id);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.permissoes = autorizacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissoes> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", login=" + login + ", senha=" + senha + ", permissoes=" + permissoes + '}';
    }

}
