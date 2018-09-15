/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

import aluno.Aluno;
import certificacoes.Certificacao;
import comuns.Endereco;
import comuns.Escolaridade;
import comuns.Estado;
import comuns.Periodo;
import comuns.Status;
import curso.Curso;
import java.util.ArrayList;
import java.util.List;
import professor.Professor;

/**
 *
 * @author 66463
 */
public class TurmaRepositorio {
    
    private static List<Turma> turmas = new ArrayList<>();
    
    static{
        
        Curso curso1 = new Curso(1L, "Lógica de Programação", "Introdução", null);
        Curso curso2 = new Curso(2L, "HTML 5", "Introdução", null);
        Curso curso3 = new Curso(3L, "Angular", "Introdução", null);
        Curso curso4 = new Curso(4L, "JAVA", "Introdução", null);
        Curso curso5 = new Curso(5L, "Oracle", "Introdução", null);
        Curso curso6 = new Curso(6L, "JQuery", "Introdução", null);
        Curso curso7 = new Curso(7L, "Node JS", "Introdução", null);
        
        Endereco endereco = new Endereco(0, "rua", "complemento", "bairro", "cidade", 0, Estado.amapa);
        
        Aluno aluno1 = new Aluno(1L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno2 = new Aluno(2L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno3 = new Aluno(3L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno4 = new Aluno(4L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno5 = new Aluno(5L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno6 = new Aluno(6L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno7 = new Aluno(7L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        Aluno aluno8 = new Aluno(8L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932", endereco);
        
        List<Certificacao> certificacoes = new ArrayList<>();
        certificacoes.add(new Certificacao(1l,"Java", "Oracle"));
        certificacoes.add(new Certificacao(2l,"Oracle", "Oracle"));
        Professor professor1 = new Professor(1L, "Professor1", "Sobrenome1", "professor1@teste",Escolaridade.superiorCompleto, "123456", "12345678912",endereco,certificacoes );
        Professor professor2 = new Professor(1L, "Professor2", "Sobrenome1", "professor1@teste",Escolaridade.superiorCompleto, "123456", "12345678912",endereco,certificacoes );
        
        
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);
        alunos.add(aluno5);
        alunos.add(aluno6);
        alunos.add(aluno7);
        alunos.add(aluno8);
        
        turmas.add(new Turma(1L, curso7, Periodo.matutino, professor2, Status.aberto, alunos));
        
        turmas.add(new Turma(2L, curso5, Periodo.vespertino, professor1, Status.fechado, alunos));
        
        turmas.add(new Turma(3L, curso2, Periodo.noturno, professor1, Status.andamento, alunos));
        
    }
    
    public List<Turma> buscarTodos() {
        return turmas;
    }

    public Turma salvar(Turma turma) {
        if (turma.getId() == null) {
            turma.setId(System.currentTimeMillis());
        }
        int indexOf = turmas.indexOf(turma);
        if (indexOf > -1) {
            turmas.set(indexOf, turma);
        } else {
            turmas.add(turma);
        }
        return turma;
    }
    
    public boolean remover(Turma turma){
        return turmas.remove(turma);
    }
    
    public Turma buscarPorId(Long id){
        for (Turma turma : turmas) {
            if(id.equals(turma.getId())){
                return turma;
            }
        }
        return null;
    }
    
    
}
