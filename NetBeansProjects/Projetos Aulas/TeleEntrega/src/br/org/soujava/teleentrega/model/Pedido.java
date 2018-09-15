/*
 * Pedido.java
 *
 * Created on 11 de Março de 2006, 12:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.org.soujava.teleentrega.model;

import br.org.soujava.teleentrega.util.Formatador;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author vsenger
 */
public class Pedido {
  private int codigo;
  private Cliente cliente;
  private java.util.Date dataPedido = new java.util.Date();
  private String observacoes;
  private Collection<Item> itens = new ArrayList<Item>();
  
  /** Creates a new instance of Pedido */
  public Pedido() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public java.util.Date getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(java.util.Date dataPedido) {
    this.dataPedido = dataPedido;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Collection<Item> getItens() {
    return itens;
  }

  public void setItens(Collection<Item> itens) {
    this.itens = itens;
  }
  public float calcularTotal() {
    float r=0;
    for(Item item : itens) {
      r+=item.getValor() * item.getQuantidade();
    }
    return r;
  }
  public String toString() {
    return Formatador.dataSimplesParaString(getDataPedido()) + " - " + cliente.getNome() ;
  }
}
