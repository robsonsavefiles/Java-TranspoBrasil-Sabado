//2)crie um Enum TipoUsuario com os seguintes valores:BASIC, MEDIUM, HARD, ADMIN, em seguida crie um sistema
//de cadastro de usuarios onde podera adicionar listar ou remover usuario. A classe usuario deve possuir os seguintes
//atributos: nome, email, senha, tipo[TipoUsuario];
package br.com.proway.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class CadastrarUsuario {

    private Scanner teclado;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao = "";
        do {
            System.out.println("1-Adicionar Usuario");
            System.out.println("2-Listar Usuario");
            System.out.println("3-Tipo de Usuario");
            System.out.println("\t B- BASIC");
            System.out.println("\t M- MEDIUM");
            System.out.println("\t H- HARD");
            System.out.println("\t A- ADMIN");
            System.out.println("4-Remover Usuario");
            System.out.println("5-Sair");
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
                System.out.println("TIPO DE USUARIO");
            case "B":
                System.out.println(TipoUsuario.BASIC);
                break;
            case "M":
                System.out.println(TipoUsuario.MEDIUM);
                break;
            case "H":
                System.out.println(TipoUsuario.HARD);
                break;
            case "A":
                System.out.println(TipoUsuario.ADMIM);
                break;
            case "4":
                remover();
                break;
            default:

        }
    }

    private void novo() {

        System.out.println("CADASTRAR UM NOVO USUARIO");
        System.out.println("nome:");
        String nome = teclado.nextLine();
        System.out.println("Email:");
        String email = teclado.nextLine();
        System.out.println("Informe Sua Senha:");
        int senha = Integer.parseInt(teclado.nextLine());
        System.out.println("Tipo de Usuario: BASIC,MEDIUM,HARD,ADMIM;");
        String tipo = teclado.nextLine();
        novo(nome, email, tipo, senha);

    }

    private void novo(String nome, String email, int senha, TipoUsuario tipo) {
        RepositorioUsuario repositorio = new RepositorioUsuario();
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setTipo(tipo);
        novoUsuario.setSenha(senha);

        repositorio.salvar(novoUsuario);

    }

    private void listar() {
        System.out.println("LISTAR USUARIO");
        RepositorioUsuario repositorio = new RepositorioUsuario();
        ArrayList<Usuario> lista = repositorio.buscarTodos();

        if (lista.isEmpty()) {
            System.out.println("nao existem Usuarios ");
        } else {
            System.out.printf("%-19s|%-50s|%-50s|%-11s\r\n", "ID", "NOME", "EMAIL", "TIPO");

            for (Usuario usuario : lista) {
                System.out.printf("%-19s|%-50s|%-50s|%-11s\r\n", usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());

            }
        }
    }

//    private void editar() {
//        System.out.println("EDITAR USUARIO ");
//        System.out.println("Informe o id do Usuario:");
//        Long id = Long.parseLong(teclado.nextLine());
//        RepositorioUsuario repositorio = new RepositorioUsuario();
//        Usuario usuario = repositorio.BuscarPorId(id);
//        if (usuario != null) {
//            System.out.printf("Informe o nome ou Enter para permanecer %s", usuario.getNome());
//            String nome = teclado.nextLine();
//            System.out.printf("Informe o email ou Enter para permanecer %s", usuario.getEmail());
//            String descricao = teclado.nextLine();
//            System.out.printf("Informe o tipo ou Enter para permanecer %s", usuario.getTipo());
//            String valor = teclado.nextLine();
//
//            usuario.setNome(!"".equals(nome) ? nome : usuario.getNome());
//            //produto.setDescricao(!"".equals(descricao) ? descricao : produto.getDescricao());
//            //produto.setValor(!"".equals(valor) ? valor : produto.getValor());
//
//            repositorio.salvar(usuario);
//
//        } else {
//            System.out.println("Usuario nao Encontrado");
//        }
//    }
    private void remover() {
        System.out.println("REMOVER USUARIO ");
        System.out.println("Informe o id do Produto:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioUsuario repositorio = new RepositorioUsuario();
        Usuario usuario = repositorio.BuscarPorId(id);

        if (usuario != null) {
            repositorio.remover(usuario);
        } else {
            System.out.println("Usuario nao Encontrado");
        }
    }

    private void novo(String nome, String email, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void novo(String nome, String email, String tipo, int senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
