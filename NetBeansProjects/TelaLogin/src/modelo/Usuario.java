
package modelo;

import cadastro_hospital.TiposDeUsuario;

/**
 *
 * @author 89087
 */
public class Usuario {
    
    private Long id;
    private String login;
    private String senha;
    private TiposDeUsuario tipo;

    public Usuario(Long id, String login, String senha, TiposDeUsuario tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TiposDeUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
    
  
}
