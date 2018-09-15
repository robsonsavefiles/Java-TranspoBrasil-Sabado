package exercicio_produto;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class CadastroProduto {

    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_LISTAR = "2";
    private static final String OPCAO_EDITAR = "3";
    private static final String OPCAO_BUSCAR = "4";
    private static final String OPCAO_REMOVER = "5";
    private static final String OPCAO_SAIR = "6";

    private Scanner teclado;

    public CadastroProduto() {
    }

    public CadastroProduto(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("MENU PRINCIPAL");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar produto");
            System.out.println(OPCAO_LISTAR + " - Listar produto");
            System.out.println(OPCAO_EDITAR + " - Editar produto");
            System.out.println(OPCAO_BUSCAR + " - Buscar produto por nome");
            System.out.println(OPCAO_REMOVER + " - Remover produto");
            System.out.println(OPCAO_SAIR + " - Sair");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!OPCAO_SAIR.equalsIgnoreCase(opcao));
    }

    public void tratarOpcoes(String opcao) {
        switch (opcao) {
            case OPCAO_CADASTRAR:
                cadastrar();
                break;
            case OPCAO_LISTAR:
                listar();
                break;
            case OPCAO_EDITAR:
                editar();
                break;
            case OPCAO_REMOVER:
                remover();
                break;
            case OPCAO_BUSCAR:
                buscarPorNome();
                break;
        }
    }

    private void cadastrar() {
        System.out.println("\nCADASTRO DE PRODUTO");

        System.out.println("Nome:");
        String nome = teclado.nextLine();
        System.out.println("Descrição:");
        String descricao = teclado.nextLine();
        System.out.println("Valor:");
        double valor = Double.parseDouble(teclado.nextLine());

        cadastrar(nome, descricao, valor);
    }

    private void cadastrar(String nome, String descricao, double valor) {
        RepositorioProduto repositorioProduto = new RepositorioProduto();
        Produto produto = new Produto(nome, descricao, valor);
        repositorioProduto.salvar(produto);
    }

    private void listar() {
        System.out.println("\nLISTA DE PRODUTOS");
        RepositorioProduto repositorioProduto = new RepositorioProduto();

        List<Produto> produtos = repositorioProduto.listar();
        imprimeLista(produtos);
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE PRODUTO");
        RepositorioProduto repositorioProduto = new RepositorioProduto();

        System.out.println("Forneça o ID do produto:");
        Long id = Long.parseLong(teclado.nextLine());
        Produto produto = repositorioProduto.getPorId(id);
        if (produto != null) {
            System.out.println("Informe o novo nome ou enter para permanecer " + produto.getNome());
            String nome = teclado.nextLine();

            System.out.println("Informe a nova descricao ou enter para permanecer " + produto.getDescricao());
            String descricao = teclado.nextLine();

            System.out.println("Informe o novo valor ou enter para permanecer " + produto.getValor());
            String valor = teclado.nextLine();

            produto.setNome(!"".equalsIgnoreCase(nome) ? nome : produto.getNome());
            produto.setDescricao(!"".equalsIgnoreCase(descricao) ? descricao : produto.getDescricao());
            produto.setValor(!"".equalsIgnoreCase(valor) ? Double.parseDouble(valor) : produto.getValor());
            repositorioProduto.salvar(produto);
            System.out.println("Produto editado com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE PRODUTO");
        RepositorioProduto repositorioProduto = new RepositorioProduto();

        System.out.println("Forneça o ID do produto:");
        Long id = Long.parseLong(teclado.nextLine());
        Produto produto = repositorioProduto.getPorId(id);
        if (produto != null) {
            repositorioProduto.remover(produto);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

    private void buscarPorNome() {
        System.out.println("\nBUSCA DE PRODUTO");
        RepositorioProduto repositorioProduto = new RepositorioProduto();

        System.out.println("Informe o nome inteiro ou parcial do produto que procura:");
        String nome = teclado.nextLine();
        List<Produto> resultados = repositorioProduto.getPorNome(nome);

        if (!resultados.isEmpty()) {
            imprimeLista(resultados);
        } else {
            System.out.println("Não foi encontrado nenhum produto.");
        }
    }

    private void imprimeLista(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.printf("%-20s|%-50s|%-80s|%-20s\r\n",
                    "ID", "NOME", "DESCRICAO", "VALOR");
            produtos.stream().forEach((produto) -> System.out.printf("%-20s|%-50s|%-80s|%-20s\r\n",
                    produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor()));
        }
    }
}
