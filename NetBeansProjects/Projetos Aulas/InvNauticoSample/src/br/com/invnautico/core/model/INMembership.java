package br.com.invnautico.core.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * @hibernate.class table="membership"
 */
public class INMembership implements Serializable, Comparable {
    
    private Integer id;
    private String nome;
    private String site;
    private String dados;
    private boolean ativo = true;
    private Collection<INEquipment> equipamentos;
    
    public INMembership() {
    }
    
    public INMembership(Integer id, String descricao, boolean ativo) {
        this.setId(id);
        this.setNome(descricao);
        this.setAtivo(ativo);
    }
    
    /**
     * @hibernate.id column="id" generator-class="native"
     */
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @hibernate.property column="name" type="string"
     */
    public String getNome() {
        return nome;
    }
    
    public void setNome(String descricao) {
        this.nome = descricao;
    }
    
    /**
     * @hibernate.property column="active" type="boolean"
     */
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String toString() {
        return getNome() + " - " + getId();
    }
    

    /**
     * @hibernate.property column="site" type="string"
     */

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @hibernate.property column="member_data" type="string"
     */
    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        boolean result = false;
        if (o instanceof INMembership) {
            INMembership outro = (INMembership) o;
            result = this.getNome() != null && this.getNome().equals(outro.getNome());
        }
        return result;
    }
    
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 41;
        return result;
    }
    
    public int compareTo(Object o) {
        if(o instanceof INMembership) {
            return getNome().compareTo(((INMembership) o).getNome());
        }
        else return -1;
    }    
    /**
     * @hibernate.list cascade="all" inverse="true"
     * @hibernate.index column="index_member"
     * @hibernate.key column="membership_id"
     * @hibernate.one-to-many class="br.com.invnautico.core.model.INEquipment"
     */
    public Collection<INEquipment> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Collection<INEquipment> equipamentos) {
        this.equipamentos = equipamentos;
    }
}