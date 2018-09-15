/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java.encapsulamento;

import java.util.ArrayList;

/**
 *
 * @author 89087
 */
public class Pedido {
    
    private String cliente;
    private double total;
    private ArrayList<PedidoItem> itens = new ArrayList<PedidoItem>();

    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + ", total=" + getTotal() + ", item=" + itens+ '}';
    }

public void addItem(Produto produto, int quantidade){
    
    itens.add(new PedidoItem(produto, quantidade));
    
}

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        total =0;
        for (PedidoItem item1 : itens) {
            total+= item1.getQuantidade() * item1.getProduto().getPreco();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public Pedido() {
    }
    
    public double getPrecoProduto(int idxItem){
        return itens.get(idxItem).getProduto().getPreco();
    }
    
    public String getNomeProduto(int idxItem){
        return itens.get(idxItem).getProduto().getNome();
    }
    
    public int getQuantidadeItens(){
        return itens.size();
        
        
    }
    
    public Produto getProduto(int index){
       Produto prod = itens.get(index).getProduto();
       return new Produto(prod.getNome(),prod.getPreco());
    }
}