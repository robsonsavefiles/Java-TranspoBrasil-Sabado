package exemplos.encapsulamento2;

import java.util.ArrayList;

/**
 *
 * @author 78522
 */
public class Pedido {

    private String cliente;
    private ArrayList<PedidoItem> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public Pedido(String cliente) {
        this();
        this.cliente = cliente;
    }

    public Pedido(String cliente, ArrayList<PedidoItem> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        double total = 0;
        for (PedidoItem item : itens) {
            total += item.getTotal();
        }
        return total;
    }

    public void addItem(Produto produto, int quantidade) {
        itens.add(new PedidoItem(produto, quantidade));
    }

}
