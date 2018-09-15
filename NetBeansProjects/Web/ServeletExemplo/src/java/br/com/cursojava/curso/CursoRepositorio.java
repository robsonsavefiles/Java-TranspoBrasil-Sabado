/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.curso;

import br.com.cursojava.professor.Professor;
import br.com.cursojava.professor.ProfessorRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class CursoRepositorio {

    private static List<Curso> lista = new ArrayList<Curso>();

    static {
        ProfessorRepositorio professor = new ProfessorRepositorio();
        
        lista.add(new Curso(1L, "Logica de programação", "Introduçao a programação utilizando  algoritimos",professor.buscarTodos().get(0)));
        lista.add(new Curso(2L, "Formçao Java ", "Introduçao a programação a programação Orientadada a Objeto", professor.buscarTodos().get(1)));
        lista.add(new Curso(3L, "Angular JS", "Introduçao a programação a framework da Google", professor.buscarTodos().get(2)));
        lista.add(new Curso(4L, "ABAP", "Introduçao a programação SAP ABAP", professor.buscarTodos().get(3)));
    }

    public Curso salvar(Curso curso) {
        if (curso == null) {
            return null;
        }
        if (curso.getId() == null) {
            curso.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(curso);
        if (index > -1) {
            lista.set(index, curso);
        } else {
            lista.add(curso);
        }
        return curso;
    }

    public boolean remover(Curso curso) {
        return lista.remove(curso);
    }

    public List<Curso> buscarTodos() {
        return lista;
    }

    public Curso buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        for (Curso curso : lista) {
            if (id.equals(curso.getId())) {
                return curso;
            }
        }
        return null;
    }

}
