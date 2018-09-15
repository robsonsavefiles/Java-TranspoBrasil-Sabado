
package cadastro_hospital;

import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Usuario {
    
    
    private String login;
    private String senha;
    private TiposDeUsuario tipo;
    

    public Usuario(String login, String senha, TiposDeUsuario tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
       
    }
   

    public Usuario() {
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
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }
    
    
    

}
