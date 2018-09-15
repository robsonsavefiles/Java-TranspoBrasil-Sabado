package turma;

import aluno.Aluno;
import comuns.Periodo;
import comuns.Status;
import curso.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import professor.Professor;

/**
 *
 * @author 66463
 */
public class Turma {

    private Long id;
    private Curso curso;
    private Periodo periodo;
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();
    private Status status;

    public Turma() {
    }

    public Turma(Long id, Curso curso, Periodo periodo, Professor professor, Status status, List<Aluno> alunos) {
        this.id = id;
        this.curso = curso;
        this.periodo = periodo;
        this.professor = professor;
        this.status = status;
        this.alunos = alunos;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        return "Turma{" + "id=" + id + ", curso=" + curso + ", periodo=" 
                + periodo + ", professor=" + professor + ", alunos=" + alunos 
                + ", status=" + status + '}';
    }
    
    
    
    
}
