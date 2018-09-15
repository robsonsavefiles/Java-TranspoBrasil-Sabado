/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.turma;

import br.com.cursojava.aluno.Aluno;
import br.com.cursojava.curso.Curso;
import br.com.cursojava.professor.Professor;
import java.util.Date;
import java.util.Objects;
import javax.xml.stream.events.EndDocument;

/**
 *
 * @author 89087
 */
public class Turma {
    
    private Long id;
    private Curso curso;
    private Periodo periodo;
    private Professor professor;
    private Aluno aluno;
    private Status status;

    public Turma() {
    }

    public Turma(Long id, Curso curso, Periodo periodo, Professor professor, Aluno aluno, Status status) {
        this.id = id;
        this.curso = curso;
        this.periodo = periodo;
        this.professor = professor;
        this.aluno = aluno;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", curso=" + curso + ", periodo=" + periodo + ", professor=" + professor + ", aluno=" + aluno + ", status=" + status + '}';
    }
    
    

}