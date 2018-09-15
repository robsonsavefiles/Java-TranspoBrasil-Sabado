/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.ArrayList;

public class RepositorioContato {
    
    private static ArrayList<Contato> lista = new ArrayList<Contato>();

    public void salvar(Contato contato) {
        if(contato == null){
            return;
        }
        if(contato.getId() == null){
            contato.setId(System.currentTimeMillis());
        }
       int index = lista.indexOf(contato);
       if(index >-1){
           lista.set(index, contato);
       }
    }
    public void remover(Contato contato){
        lista.remove(contato);
    }
    public ArrayList<Contato> buscarTodos(String nome){
        return null;
        
    }
    public Contato buscarPorNome(String nome) {
        for(Contato atual : lista){
            if(nome.equals(atual.getNome()));
            return atual;
        }
        return null;
        
    }

    public Contato BuscarPorId(Long id) {
        for(Contato atual : lista){
            if(id.equals(atual.getId()));
            return atual;
        }
        return null;
    }

    ArrayList<Contato> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
