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
public class PedidoTest {
    
    public static void main(String[] args) {
        
        Produto arroz= new Produto("arroz tio joão",2.57);
        Produto feijao = new Produto("Feijão",2.10);
        Produto farinha = new Produto("Farinha",4.57);
        Produto tranquinas = new Produto("Traquinas",7.57);
        Produto fandangos = new Produto("Fandangos",8.57);
        Produto alcatra = new Produto("Alcatra",29.57);
        Produto cafe = new Produto("Cafe",3.57);
        Produto cocacola = new Produto("Coca Cola",8.57);
        Produto peixe = new Produto("Peixe",10.57);
        
        
        Pedido pedido = new Pedido("MARIA");
        PedidoItem pedidoItem = new PedidoItem(arroz,2);
        pedido.addItem().add(new PedidoItem(arroz,2));
        pedido.addItem().add(new PedidoItem(feijao,1));
        pedido.addItem().add(new PedidoItem(cocacola,1));
        
        System.out.println(pedido);
        pedidoItem.setQuantidade(100);
        
        
    }
    
    
}
