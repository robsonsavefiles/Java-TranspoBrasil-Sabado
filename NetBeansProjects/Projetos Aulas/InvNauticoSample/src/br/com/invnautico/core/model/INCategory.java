package br.com.invnautico.core.model;

import java.io.Serializable;

/**
 * @hibernate.class table="category"
 */
public class INCategory implements Serializable, INBasicEntity, Comparable{

  private Integer id;
  private String descricao;
  private boolean ativo = true;

  public INCategory() {
  }

  public INCategory(Integer id, String descricao, boolean ativo) {
    this.id = id;
    this.descricao = descricao;
    this.ativo = ativo;
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
   * @hibernate.property column="description" type="string"
   */
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
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
    return getDescricao() + " - " + getId();
  }

  public boolean equals(Object o) {
    if (o == null) return false;
    if (this == o) return true;
    boolean result = false;
    if (o instanceof INCategory) {
      INCategory outro = (INCategory) o;
      result = this.getDescricao() != null && this.getDescricao().equals(outro.getDescricao());
    }
    return result;
  }

  public int hashCode() {
    int result = getDescricao() != null ? getDescricao().hashCode() : 41;
    return result;
  }
    public int compareTo(Object o) {
        if(o instanceof INCategory) {
            return getDescricao().compareTo(((INCategory) o).getDescricao());
        }
        else return -1;
    }
}