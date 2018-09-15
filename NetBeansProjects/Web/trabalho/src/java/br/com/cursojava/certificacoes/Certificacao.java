/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.certificacoes;

import br.com.cursojava.professor.Professor;
import java.util.Objects;

/**
 *
 * @author 89087
 */
public class Certificacao extends Professor{
    
    private Long id;
    private String nome;
    private String orgao_expeditor;

    public Certificacao() {
    }

    public Certificacao(Long id, String nome, String orgao_expeditor) {
        this.id = id;
        this.nome = nome;
        this.orgao_expeditor = orgao_expeditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrgao_expeditor() {
        return orgao_expeditor;
    }

    public void setOrgao_expeditor(String orgao_expeditor) {
        this.orgao_expeditor = orgao_expeditor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Certificacao other = (Certificacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certificao{" + "id=" + id + ", nome=" + nome + ", orgao_expeditor=" + orgao_expeditor + '}';
    }
    
    

}
  