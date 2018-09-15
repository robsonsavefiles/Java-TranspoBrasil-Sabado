/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroContato {

    private Scanner teclado;
    
    void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }
    
    public void menu() {
        String opcao = "";
        do {
            System.out.println("1-Cadastrar Contato");
            System.out.println("2-Listar Contato");
            System.out.println("3-Editar Contato");
            System.out.println("4-Remover Contato");
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
                editar();
                break;
            case "4":
                remover();
                break;
        }
    }
    
    private void novo() {
        
        System.out.println("Cadastra Contato Novo");
        System.out.println("nome:");
        String nome = teclado.nextLine();
        System.out.println("email:");
        String email = teclado.nextLine();
        System.out.println("Telefone:");
        String telefone = teclado.nextLine();
        novo(nome, email, telefone);
        
    }

    private void novo(String nome, String email, String telefone) {
        RepositorioContato repositorio = new RepositorioContato();
        Contato novoContato = new Contato();
        novoContato.setNome(nome);
        novoContato.setEmail(email);
        novoContato.setTelefone(telefone);
        
        repositorio.salvar(novoContato);
        
    }
    
    private void listar() {
        System.out.println("LISTAR CONTATO ");
        RepositorioContato repositorio = new RepositorioContato();
        ArrayList<Contato> lista = repositorio.buscarTodos();
        if (lista.isEmpty()) {
            System.out.println("nao existem contatos ");
        } else {
            System.out.printf("%-19s|%-50s|%-50s|%-11s\r\n", "ID", "NOME", "EMAIL", "TELEFONE");
            
            for (Contato contato : lista) {
                System.out.printf("% -19s|%-50s|%-11s\r\n", contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone());
                
            }
        }
    }
    
    private void editar() {
        System.out.println("LISTA CONTATO ");
        System.out.println("Informe o id do contato:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioContato repositorio = new RepositorioContato();
        Contato contato = repositorio.BuscarPorId(id);
        if (contato != null) {
            System.out.printf("Informe o nome ou Enter para permanecer %s", contato.getNome());
            String nome = teclado.nextLine();
            System.out.printf("Informe o Email ou Enter para permanecer %s", contato.getEmail());
            String email = teclado.nextLine();
            System.out.printf("Informe o nome ou Enter para permanecer %s", contato.getTelefone());
            String telefone = teclado.nextLine();
            
            contato.setNome(!"".equals(nome) ? nome : contato.getNome());
            contato.setEmail(!"".equals(email) ? email : contato.getEmail());
            contato.setTelefone(!"".equals(telefone) ? telefone : contato.getEmail());
            
            repositorio.salvar(contato);
            
        } else {
            System.out.println("Contato nao Encontrado");
        }
    }

    private void remover() {
        System.out.println("REMOVE CONTATO ");
        System.out.println("Informe o id do contato:");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioContato repositorio = new RepositorioContato();
        Contato contato = repositorio.BuscarPorId(id);
        if (contato != null) {
            repositorio.remover(contato);
        } else {
            System.out.println("Contato nao Encontrado");
        }
    }
    
//    private void novo(String nome, String email, String telefone) {
//        
//    }
}
