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
    
    private String cliente ;
    private double total;
    
    private ArrayList<PedidoItem> itens  = new ArrayList<PedidoItem>();
    
    
    public Pedido(){
        
    }

    Pedido(String maria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

   

    public double getTotal() {
        for (PedidoItem item : itens){
            total+= item.getQuantidade() + item.getProduto().getPreco();
        }
    
       public void addItem(Produto produto, int quantidade){
           itens.add(new PedidoItem(produto,quantidade));
       }
    

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<PedidoItem> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cliente=" + cliente + ", total=" + total + ", itens=" + itens + '}';
    }
    
 
   
    
}
