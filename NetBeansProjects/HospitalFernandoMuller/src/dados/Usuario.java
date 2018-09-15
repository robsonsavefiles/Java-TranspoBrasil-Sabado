/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import estado.Tipo;
import java.util.Objects;

/**
 *
 * @author 88178
 */
public class Usuario {

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", tipo=" + tipo + ", id=" + id + '}';
    }

    private String login;
    private String senha;
    private Tipo tipo;
    private Long id;

    public Usuario(Long id, String login, String senha, Tipo tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.id = id;
    }

    public Usuario(String login, String senha, Tipo tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

}
