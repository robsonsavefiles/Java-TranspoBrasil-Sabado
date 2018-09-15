/*
 * Item.java
 *
 * Created on 11 de Março de 2006, 12:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.org.soujava.teleentrega.model;

import br.org.soujava.teleentrega.util.Formatador;

/**
 *
 * @author vsenger
 */
public class Item {
  private int codigo;
  private String descricao;
  private int quantidade;
  private double valor;
  private Pedido pedido;
  
  /** Creates a new instance of Item */
  public Item() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }
  public String toString() {
    return descricao + " - Qtd: " + quantidade 
        + " - Preço Unitário: R$"  + Formatador.moeda(valor) 
        + " - TOTAL: R$" + Formatador.moeda(valor * quantidade);
  }
 }
