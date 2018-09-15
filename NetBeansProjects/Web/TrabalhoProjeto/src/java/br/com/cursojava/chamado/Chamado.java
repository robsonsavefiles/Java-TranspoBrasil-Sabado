/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.chamado;

import br.com.cursojava.projeto.Projeto;
import br.com.cursojava.providencia.Providencia;
import java.util.Objects;

/**
 *
 * @author 89087
 */
public class Chamado {

    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private Providencia providencias;
    private Projeto projeto;

    public Chamado() {
    }

    public Chamado(Long id, String titulo, String descricao, Status status, Providencia providencias, Projeto projeto) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.providencias = providencias;
        this.projeto = projeto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Providencia getProvidencias() {
        return providencias;
    }

    public void setProvidencias(Providencia providencias) {
        this.providencias = providencias;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chamado{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", status=" + status + ", providencias=" + providencias + ", projeto=" + projeto + '}';
    }

}
