package br.com.invnautico.core.model;

import java.io.Serializable;

/**
 * @hibernate.class table="component"
 */
public class INComponent implements Serializable{
    
    private Integer id;
    private INEquipment equipamento;
    private String nome;
    private String descricao;
    private double preco;
    private boolean containerComponent;
    private INCategory categoria;
    private INLocation localizacao;
    private INBrand marca;
    
    
    
    public INComponent(){
    }
    
    
    /**
     * @hibernate.id column="id" generator-class="native"
     */
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
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
     * @hibernate.property column="full_description" type="string"
     */
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    
    /**
     * @hibernate.many-to-one column="equipment_id" not-null="false"
     */
    public INEquipment getEquipamento(){
        return equipamento;
    }
    
    public void setEquipamento(INEquipment equipo){
        this.equipamento=equipo;
    }
    
    public String toString() {
        return getNome() +  (getDescricao()==null ? "" : " - " + getDescricao());
        
    }
    
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        boolean result = false;
        if (o instanceof INComponent){
            INComponent outro = (INComponent) o;
            result = this.getNome().equals(outro.getNome()) &&
                    this.getDescricao().equals(outro.getDescricao());
        }
        return result;
    }
    
    public int hashCode() {
        int result = getNome().hashCode();
        result = (getDescricao() != null ? getDescricao().hashCode() : 41) + 23 * result;
        return result;
    }
    /**
     * @hibernate.property column="price" type="double"
     */
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    /**
     * @hibernate.property column="container_component" type="boolean"
     */
    public boolean isContainerComponent() {
        return containerComponent;
    }
    
    public void setContainerComponent(boolean containerComponent) {
        this.containerComponent = containerComponent;
    }
    /**
     * @hibernate.many-to-one column="category_id" not-null="false"
     */
    public INCategory getCategoria() {
        return categoria;
    }
    
    public void setCategoria(INCategory categoria) {
        this.categoria = categoria;
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
    /**
     * @hibernate.many-to-one column="brand_id" not-null="false"
     */
    public INBrand getMarca() {
        return marca;
    }
    
    public void setMarca(INBrand marca) {
        this.marca = marca;
    }
}