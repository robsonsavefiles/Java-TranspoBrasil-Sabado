/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.providencia;

import java.util.Objects;

/**
 *
 * @author 89087
 */
public class Providencia {

    private Long id;
    private String descricao;
    private Estagio estagio;
    private String autor;

    public Providencia() {
    }

    public Providencia(Long id, String descricao, Estagio estagio, String autor) {
        this.id = id;
        this.descricao = descricao;
        this.estagio = estagio;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Providencia other = (Providencia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Providencia{" + "id=" + id + ", descricao=" + descricao + ", estagio=" + estagio + ", autor=" + autor + '}';
    }

}
