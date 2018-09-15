package br.cursojava.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  89087
 */
public class Usuario extends Entidade implements UsuarioCredencial {

    private String nome;
    private String login;
    private String senha;
    private List<Autorizacao> autorizacoes = new ArrayList();

    public enum Autorizacao {
        USER,
        ADM;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha, List<Autorizacao> autorizacoes) {
        super(id);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.autorizacoes = autorizacoes;
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

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", login=" + login + ", senha=" + senha + ", autorizacoes=" + autorizacoes + '}';
    }

}
