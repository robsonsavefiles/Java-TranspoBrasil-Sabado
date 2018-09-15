//2)crie um Enum TipoUsuario com os seguintes valores:BASIC, MEDIUM, HARD, ADMIN, em seguida crie um sistema
//de cadastro de usuarios onde podera adicionar listar ou remover usuario. A classe usuario deve possuir os seguintes
//atributos: nome, email, senha, tipo[TipoUsuario];
package br.com.proway.java;

import java.util.ArrayList;

public class RepositorioProduto {

    private static ArrayList<Produto> lista = new ArrayList<Produto>();

    public void salvar(Produto produto) {
        if (produto == null) {
            return;
        }
        if (produto.getId() == null) {
            produto.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(produto);
        if (index > -1) {
            lista.set(index, produto);
        }
    }

    public void remover(Produto produto) {
        lista.remove(produto);
    }

    public ArrayList<Contato> buscarTodos(String nome) {
        return null;

    }

    public Produto buscarPorNome(String nome) {
        for (Produto atual : lista) {
            if (nome.equals(atual.getNome()));
            return atual;
        }
        return null;

    }

    public Produto BuscarPorId(Long id) {
        for (Produto atual : lista) {
            if (id.equals(atual.getId()));
            return atual;
        }
        return null;
    }

    ArrayList<Produto> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
