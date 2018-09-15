/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.controllers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class UsuarioRepositorio {

    private static List<Usuario> usuarios = new ArrayList<>();

    static {

        usuarios.add(new Usuario(1L, "Alison", "alison.lierti@gmail.com", "papainoel"));
        usuarios.add(new Usuario(2L, "Sidneia Rafaela Biz", "sidnei@gmail.com", "biz"));
        usuarios.add(new Usuario(3L, "João da Silva", "joaodilva@gmail.com", "jsilva"));

    }

    public List<Usuario> buscarTodos() {
        return usuarios;
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(System.currentTimeMillis());
        }
        int indexOf = usuarios.indexOf(usuario);
        if (indexOf > -1) {
            usuarios.set(indexOf, usuario);
        } else {
            usuarios.add(usuario);
        }
        return usuario;
    }
    
    public boolean remover(Usuario usuario){
        return usuarios.remove(usuario);
    }
    
    public Usuario buscarPorId(Long id){
        for (Usuario usuario : usuarios) {
            if(id.equals(usuario.getId())){
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarPorEmail(String email){
        for (Usuario usuario : usuarios) {
            if(email.equals(usuario.getEmail())){
                return usuario;
            }
        }
        return null;
    }
    
}
