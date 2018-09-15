/*
 * Cliente.java
 *
 * Created on 11 de Março de 2006, 09:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.org.soujava.teleentrega.model;

import java.util.Collection;

/**
 *
 * @author vsenger
 */
public class Cliente {
  private int codigo;
  private String nome="";
  private String endereco="";
  private String telefones="";
  private Collection<Pedido> pedidos;
  /** Creates a new instance of Cliente */
  public Cliente() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  public Collection<Pedido> getPedidos() {
    return pedidos;
    
  }
  public void setPedidos(Collection<Pedido> pedidos) {
    this.pedidos=pedidos;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefones() {
    return telefones;
  }

  public void setTelefones(String telefones) {
    this.telefones = telefones;
  }
  public String toString(){ 
    return nome + "/" + telefones;
  }
  public boolean equals(Object comp) {
    if(!(comp instanceof Cliente)) return false;
    if(comp == null)return false;
    Cliente cliComp = (Cliente) comp;
    if(cliComp.getCodigo()==this.getCodigo() 
       && cliComp.getEndereco().equals(getEndereco()) 
       && cliComp.getNome().equals(getNome()) 
       && cliComp.getTelefones().equals(getTelefones())) {
      return true;
    }
    else return false;
  }


  public int hashCode() {
    String stringona = codigo + getNome() + getEndereco() + getTelefones();
    return stringona.hashCode();
  }
}
