package avaliacao.questao26.model;

import java.util.Date;

/**
 *
 * @author 78522
 */
public class PedidoItem extends Entidade {

    private Produto produto;
    private int quantidade;
    private double valor;

    public PedidoItem() {
    }

    public PedidoItem(Date dataCriacao, Date dataAlteracao, Produto produto, int quantidade) {
        this(null, dataCriacao, dataAlteracao, produto, quantidade);
    }

    public PedidoItem(Long id, Date dataCriacao, Date dataAlteracao, Produto produto, int quantidade) {
        super(id, dataCriacao, dataAlteracao);
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.getValor() * quantidade;
    }

    public Produto getProduto() {
        return new Produto(produto.getId(), produto.getDataCriacao(), produto.getDataAlteracao(),
                produto.getCodigo(), produto.getNome(), produto.getDescricao(), produto.getValor());
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setPedidoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        valor = produto.getValor() * quantidade;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "produto=" + produto + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }

}
