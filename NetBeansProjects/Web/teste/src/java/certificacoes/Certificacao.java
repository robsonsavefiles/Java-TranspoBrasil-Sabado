/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificacoes;

import java.util.Objects;

/**
 *
 * @author 66463
 */
public class Certificacao {
    
    private Long id;
    private String nome;
    private String orgaoExpeditor;

    public Certificacao() {
    }
    
    public Certificacao(Long id,String nome, String orgaoExpeditor) {
        this.id = id;
        this.nome = nome;
        this.orgaoExpeditor = orgaoExpeditor;
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

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        return "Certificacao{" + "nome=" + nome + ", orgaoExpeditor=" + orgaoExpeditor + '}';
    }
    
    
    
}
