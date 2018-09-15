package br.com.proway.java;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProduto {

    private Scanner teclado;

    void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao = "";
        do {
            System.out.println("1-Cadastrar Produto");
            System.out.println("2-Listar Produto");
            System.out.println("3-Remover Produto");
            System.out.println("4-Sair");
            opcao = teclado.nextLine();

            tratarOpcoes(opcao);//alt shif + m
        } while (!"s".equalsIgnoreCase(opcao));

    }

    private void tratarOpcoes(String opcao) {
        switch (opcao) {
            case "1":
                novo();
                break;
            case "2":
                listar();
                break;
            case "3":
                remover();
                break;
            case "4":
                break;
        }
    }

    private void novo() {

        System.out.println("CADASTRAR UM NOVO PRODUTO");
        System.out.println("nome:");
        String nome = teclado.nextLine();
        System.out.println("Descriçao:");
        String descricao = teclado.nextLine();
        System.out.println("Valor:");
        String valor = teclado.nextLine();
        novo(nome, descricao, valor);

    }

    private void novo(String nome, String descricao, String valor) {
        RepositorioProduto repositorio = new RepositorioProduto();
        Produto novoProduto = new Produto();
        novoProduto.setNome(nome);
        novoProduto.setDescricao(descricao);
        novoProduto.setValor(valor);

        repositorio.salvar(novoProduto);

    }

    private void listar() {
        System.out.println("LISTAR CONTATO ");
        RepositorioProduto repositorio = new RepositorioProduto();
        ArrayList<Produto> lista = repositorio.buscarTodos();
        
        
        if (lista.isEmpty()) {
            System.out.println("nao existem Produtos ");
        } else {
            System.out.printf("%-19s|%-50s|%-50s|%-11s\r\n", "ID", "NOME", "DESCRIÇÃO", "VALOR");

            for (Produto produto : lista) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor());

            }
        }
    }

    private void editar() {
        System.out.println("EDITAR PRODUTO ");
        System.out.println("Informe o id do contato:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioProduto repositorio = new RepositorioProduto();
        Produto produto = repositorio.BuscarPorId(id);
        if (produto != null) {
            System.out.printf("Informe o nome ou Enter para permanecer %s", produto.getNome());
            String nome = teclado.nextLine();
            System.out.printf("Informe a descriçao ou Enter para permanecer %s", produto.getDescricao());
            String descricao = teclado.nextLine();
            System.out.printf("Informe o  Valor ou Enter para permanecer %s", produto.getValor());
            String valor = teclado.nextLine();

            produto.setNome(!"".equals(nome) ? nome : produto.getNome());
            //produto.setDescricao(!"".equals(descricao) ? descricao : produto.getDescricao());
            //produto.setValor(!"".equals(valor) ? valor : produto.getValor());

            repositorio.salvar(produto);

        } else {
            System.out.println("Produto nao Encontrado");
        }
    }

    private void remover() {
        System.out.println("REMOVER PRODUTO ");
        System.out.println("Informe o id do Produto:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioProduto repositorio = new RepositorioProduto();
        Produto produto = repositorio.BuscarPorId(id);
       
        if (produto != null) {
            repositorio.remover(produto);
        } else {
            System.out.println("Produto nao Encontrado");
        }
    }

}
