package avaliacao.questao26.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Pedido extends Entidade {

    private String codigo;
    private Cliente cliente;
    private List<PedidoItem> itens;
    private double total;

    public Pedido() {
        itens = new ArrayList();
    }

    public Pedido(Date dataCriacao, Date dataAlteracao, String codigo, Cliente cliente, List<PedidoItem> itens) {
        this(null, dataCriacao, dataAlteracao, codigo, cliente, itens);
    }

    public Pedido(Long id, Date dataCriacao, Date dataAlteracao, String codigo, Cliente cliente, List<PedidoItem> itens) {
        super(id, dataCriacao, dataAlteracao);
        this.codigo = codigo;
        this.cliente = cliente;
        this.itens = itens;
        this.total = calcularTotal();
    }

    public void addItem(PedidoItem item) {
        itens.add(item);
        total += item.getValor();
    }

    public List<PedidoItem> getItens() {
        List<PedidoItem> retorno = new ArrayList();
        itens.stream().forEach((item) -> {
            retorno.add(new PedidoItem(item.getId(), item.getDataCriacao(), item.getDataAlteracao(), item.getProduto(), item.getQuantidade()));
        });
        return retorno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    private double calcularTotal() {
        double soma = 0;
        soma = itens.stream().map((item) -> item.getValor()).reduce(soma, (accumulator, _item) -> accumulator + _item);
        return soma;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", itens=" + itens + ", total=" + total + '}';
    }

}
