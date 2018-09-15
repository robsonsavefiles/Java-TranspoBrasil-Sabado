/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.encapsulamento;

/**
 *
 * @author 89087
 */
public class PedidoItem {
    
    private Produto produto;
    private int quantidade;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public PedidoItem() {
    }

    public PedidoItem(Produto produto, int quantidade) {
        this.produto = new Produto(produto.getNome(),produto.getPreco());
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
    
    
}
