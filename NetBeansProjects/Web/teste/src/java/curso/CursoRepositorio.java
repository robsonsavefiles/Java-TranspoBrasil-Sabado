/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class CursoRepositorio {
    
    private static List<Curso> cursos = new ArrayList<>();
    
    static{
        
        cursos.add(new Curso(1L, "Lógica de Programação", "Introdução", null));
        cursos.add(new Curso(2L, "HTML 5", "Introdução", null));
        cursos.add(new Curso(3L, "Angular", "Introdução", null));
        cursos.add(new Curso(4L, "JAVA", "Introdução", null));
        cursos.add(new Curso(5L, "Oracle", "Introdução", null));
        cursos.add(new Curso(6L, "JQuery", "Introdução", null));
        cursos.add(new Curso(7L, "Node JS", "Introdução", null));
        
    }
    
    public List<Curso> buscarTodos() {
        return cursos;
    }

    public Curso salvar(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(System.currentTimeMillis());
        }
        int indexOf = cursos.indexOf(curso);
        if (indexOf > -1) {
            cursos.set(indexOf, curso);
        } else {
            cursos.add(curso);
        }
        return curso;
    }
    
    public boolean remover(Curso curso){
        return cursos.remove(curso);
    }
    
    public Curso buscarPorId(Long id){
        for (Curso curso : cursos) {
            if(id.equals(curso.getId())){
                return curso;
            }
        }
        return null;
    }
    
}
