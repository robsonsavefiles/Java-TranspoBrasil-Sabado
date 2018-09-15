package modelo;

import hospital.view.controller.TableInfoUsuario;
import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public class Usuario extends Pessoa implements TableInfoUsuario {

    public enum Tipo {

        MEDICO, GERENTE, ATENDENTE;
    }

    private String login;
    private String senha;
    private Tipo tipo;

    public Usuario(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome, String login, String senha, Tipo tipo) {
        super(id, dataCriacao, dataAlteracao, nome);
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String nome, String login, String senha, Tipo tipo) {
        this(null, null, null, nome, login, senha, tipo);
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


    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
