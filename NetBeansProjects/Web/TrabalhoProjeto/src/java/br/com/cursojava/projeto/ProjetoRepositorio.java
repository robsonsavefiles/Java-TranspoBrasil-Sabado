/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.projeto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class ProjetoRepositorio {

    private static List<Projeto> projetos = new ArrayList<>();

    static {

        projetos.add(new Projeto(1L, "Projeto Java", "Introduçao a programaçao java a estudantes Carentes"));
        projetos.add(new Projeto(2L, "Projeto Criança Feliz", "Projeto Social a  estudantes Carentes"));
        projetos.add(new Projeto(3L, "Projeto Sem Fronteiras", "Oportunidade de Intercâmbio a paises da Europa"));

    }

    public List<Projeto> buscarTodos() {
        return projetos;
    }

    public Projeto salvar(Projeto projeto) {
        if (projeto.getId() == null) {
            projeto.setId(System.currentTimeMillis());
        }
        int indexOf = projetos.indexOf(projeto);
        if (indexOf > -1) {
            projetos.set(indexOf, projeto);
        } else {
            projetos.add(projeto);
        }
        return projeto;
    }

    public boolean remover(Projeto projeto) {
        return projetos.remove(projeto);
    }

    public Projeto buscarPorId(Long id) {
        for (Projeto projeto : projetos) {
            if (id.equals(projeto.getId())) {
                return projeto;
            }
        }
        return null;
    }

}
