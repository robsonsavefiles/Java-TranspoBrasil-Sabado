package avaliacao.questao26.modelos;

import java.util.Date;

/**
 *
 * @author 89087
 */
public class PedidoItem extends Entidade {

    private Produto produto;
    private int quantidade;
    private double valor;
    private double estoque;

   

    public PedidoItem() {
    }

    public PedidoItem(Date dataCriacao, Date dataAlteracao, Produto produto, int quantidade,double estoque) {
        this(null, dataCriacao, dataAlteracao, produto, quantidade,estoque);
    }

    public PedidoItem(Long id, Date dataCriacao, Date dataAlteracao, Produto produto, int quantidade,double estoque) {
        super(id, dataCriacao, dataAlteracao);
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.getValor() * quantidade;
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return new Produto(produto.getId(), produto.getDataCriacao(), produto.getDataAlteracao(),
                produto.getCodigo(), produto.getNome(), produto.getDescricao(), produto.getValor(),produto.getEstoque());
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }
    
     public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public void setPedidoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        valor = produto.getValor() * quantidade;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "produto=" + produto + ", quantidade=" + quantidade + ", valor=" + valor +",estoque="+ estoque+ '}';
    }

}
