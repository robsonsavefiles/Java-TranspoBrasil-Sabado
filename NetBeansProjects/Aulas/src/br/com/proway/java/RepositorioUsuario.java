//2)crie um Enum TipoUsuario com os seguintes valores:BASIC, MEDIUM, HARD, ADMIN, em seguida crie um sistema
//de cadastro de usuarios onde podera adicionar listar ou remover usuario. A classe usuario deve possuir os seguintes
//atributos: nome, email, senha, tipo[TipoUsuario];
package br.com.proway.java;

import java.util.ArrayList;

public class RepositorioUsuario {

    private static ArrayList<Usuario> lista = new ArrayList<Usuario>();

    public void salvar(Usuario usuario) {
        if (usuario == null) {
            return;
        }

        if (usuario.getId() == null) {
            usuario.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(usuario);
        if (index > -1) {
            lista.set(index, usuario);
        } else {
            lista.add(usuario);
        }
    }

    public void remover(Usuario usuario) {
        lista.remove(usuario);
    }

    public ArrayList<Usuario> buscarTodos(String nome) {
        return null;

    }

    public Usuario buscarPorNome(String nome) {
        for (Usuario atual : lista) {
            if (nome.equals(atual.getNome()));
            return atual;
        }
        return null;

    }

    public Usuario BuscarPorId(Long id) {
        for (Usuario atual : lista) {
            if (id.equals(atual.getId()));
            return atual;
        }
        return null;
    }

    ArrayList<Usuario> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
