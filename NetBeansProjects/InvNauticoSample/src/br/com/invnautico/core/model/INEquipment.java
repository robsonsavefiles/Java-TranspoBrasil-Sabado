package br.com.invnautico.core.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * @hibernate.class table="equipment"
 */
public class INEquipment implements Serializable{
    private Integer id;
    
    private INLocation localizacao;
    private String nome;
    private String descricao;
    private String documentacao;
    private Collection<INComponent> componentes;
    
    
    public INEquipment(){
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
     * @hibernate.property column="short_name" type="string"
     */
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome= nome;
    }
    
    /**
     * @hibernate.property column="description" type="string"
     */
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    
    /**
     * @hibernate.property column="documentation" type="string"
     */
    public String getDocumentacao(){
        return documentacao;
    }
    
    public void setDocumentacao(String documentacao){
        this.documentacao=documentacao;
    }
    
    /**
     * @hibernate.list cascade="all" inverse="true"
     * @hibernate.index column="index_equipment"
     * @hibernate.key column="equipment_id"
     * @hibernate.one-to-many class="br.com.invnautico.core.model.INComponent"
     */
    public Collection<INComponent> getComponentes(){
        return componentes;
    }
    public void setComponentes(Collection<INComponent> componentes) {
        this.componentes=componentes;
    }
    
    /**
     * @hibernate.many-to-one column="location_id" not-null="false"
     */
    public INLocation getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(INLocation localizacao) {
        this.localizacao = localizacao;
    }
    public String toString() {
        return getNome() != null ? getNome().toString() : null;
    }
    
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        boolean result = false;
        if(o instanceof INEquipment) {
            INEquipment outro = (INEquipment) o;
            result = this.getNome() != null &&
                    this.getDescricao() != null &&
                    this.getNome().equals(outro.getNome()) &&
                    this.getDescricao().equals(outro.getDescricao());
        }
        return result;
    }
    
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 41;
        result = (getDescricao() != null ? getDescricao().hashCode() : 37) + 23 * result;
        return result;
    }
}