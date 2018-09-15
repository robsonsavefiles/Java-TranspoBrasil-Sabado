package br.cursojava.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class Chamado extends Entidade {

    private String titulo;
    private Projeto projeto;
    private String descricao;
    private Status status;
    private List<Providencia> providencias = new ArrayList();

    public enum Status {
        ABERTO,
        FECHADO;
    }

    public Chamado() {
    }

    public Chamado(Long id, String titulo, Projeto projeto, String descricao, Status status, List<Providencia> providencias) {
        super(id);
        this.titulo = titulo;
        this.projeto = projeto;
        this.descricao = descricao;
        this.status = status;
        this.providencias = providencias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Providencia> getProvidencias() {
        return providencias;
    }

    public void setProvidencias(List<Providencia> providencias) {
        this.providencias = providencias;
    }

    @Override
    public String toString() {
        return "Chamado{" + "titulo=" + titulo + ", projeto=" + projeto + ", descricao=" + descricao + ", status=" + status + ", providencias=" + providencias + '}';
    }
}
