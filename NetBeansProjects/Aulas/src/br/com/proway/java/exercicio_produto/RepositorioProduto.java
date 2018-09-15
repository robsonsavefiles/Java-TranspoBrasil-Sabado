package exercicio_produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class RepositorioProduto {

    private final static ArrayList<Produto> produtos = new ArrayList<>();
    private Scanner teclado;

    public RepositorioProduto() {
    }

    public RepositorioProduto(Scanner teclado) {
        this.teclado = teclado;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public List<Produto> listar() {
        return produtos;
    }

    public void salvar(Produto produto) {
        if (produto == null) {
            return;
        }

        if (produto.getId() == null) {
            produto.setId(System.currentTimeMillis());
        }

        int index = produtos.indexOf(produto);

        if (index > -1) {
            produtos.set(index, produto);
        } else {
            produtos.add(produto);
        }
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public Produto getPorId(Long id) {
        for (Produto produto : produtos) {
            if (Objects.equals(id, produto.getId())) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> getPorNome(String nome) {
        ArrayList<Produto> retorno = new ArrayList<>();
        produtos.stream().filter((produto) -> (produto.getNome().toLowerCase().contains(nome.toLowerCase()))).forEach((produto) -> retorno.add(produto));
        return retorno;
    }
}
