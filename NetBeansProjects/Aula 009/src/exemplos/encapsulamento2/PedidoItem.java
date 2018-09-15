package exemplos.encapsulamento2;

/**
 *
 * @author 78522
 */
public class PedidoItem {

    private Produto produto;
    private int quantidade;

    public PedidoItem() {
    }

    public PedidoItem(Produto produto, int quantidade) {
        this.produto = new Produto(produto.getNome(), produto.getPreco());
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

    public double getTotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "produto=" + produto + ", quantidade=" + quantidade + '}';
    }

}
