/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.turma;

import br.com.cursojava.aluno.AlunoRepositorio;
import br.com.cursojava.curso.CursoRepositorio;
import br.com.cursojava.professor.ProfessorRepositorio;
import java.util.List;
import java.util.ArrayList;

public class TurmaRepositorio {

    private static List<Turma> lista = new ArrayList<Turma>();

    static {
        CursoRepositorio curso = new CursoRepositorio();
        ProfessorRepositorio professor = new ProfessorRepositorio();
        AlunoRepositorio aluno = new AlunoRepositorio();

        lista.add(new Turma(1L, curso.buscarTodos().get(0), Periodo.MATUTINO, professor.buscarTodos().get(0), aluno.buscarTodos().get(0), Status.ABERTO));
        lista.add(new Turma(2L, curso.buscarTodos().get(1), Periodo.VESPERTINO, professor.buscarTodos().get(1), aluno.buscarTodos().get(1), Status.FECHADO));
        lista.add(new Turma(3L, curso.buscarTodos().get(2), Periodo.NOTURNO, professor.buscarTodos().get(2), aluno.buscarTodos().get(2), Status.EM_ANDAMENTO));

    }

    public List<Turma> buscarTodos() {
        return lista;
    }

    public Turma salvar(Turma turma) {
        if (turma.getId() == null) {
            turma.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(turma);
        if (index > -1) {
            lista.set(index, turma);
        }
        return turma;
    }

    public boolean remover(Turma turma) {
        return lista.remove(turma);
    }

    public Turma buscarPorId(Long id) {
        for (Turma turma : lista) {
            if (id.equals(turma.getId())) {
                return turma;
            }
        }
        return null;
    }

    public Turma buscarPorPeriodo(Periodo periodo) {
        for (Turma turma : lista) {
            if (periodo == (periodo.MATUTINO)) {
                return turma;
            }
            if (periodo == (periodo.VESPERTINO)) {
                return turma;
            }
            if (periodo == (periodo.NOTURNO)) {
                return turma;
            }
        }
        return null;
    }
}
