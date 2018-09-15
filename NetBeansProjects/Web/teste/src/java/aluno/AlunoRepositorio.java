/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import comuns.Endereco;
import comuns.Escolaridade;
import comuns.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class AlunoRepositorio {
    
    private static List<Aluno> alunos = new ArrayList<>();


static {
        alunos.add(new Aluno(1L,"aluno1","aluno1@teste",Escolaridade.fundamentalCompleto, "99999999","12345678932",
                new Endereco(119, "flavio da silva","N/consta","Dom bosco","Luiz Alves",89115000,Estado.santaCatarina)));
        alunos.add(new Aluno(2L,"aluno2","aluno2@teste",Escolaridade.medioCompleto,"99999999","12345678932",
                 new Endereco(119,"flavio da silva","N/consta","Dom bosco","Luiz Alves",89115000,Estado.amapa)));
        alunos.add(new Aluno(3L,"aluno3","aluno3@teste",Escolaridade.superiorIncompleto, "99999999","12345678932",
                 new Endereco(119,"flavio da silva","N/consta","Dom boscos","Luiz Alves",89115000,Estado.espiritoSanto)));
    }

    public List<Aluno> buscarTodos() {
        return alunos;
    }

    public Aluno salvar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(System.currentTimeMillis());
        }
        int indexOf = alunos.indexOf(aluno);
        if (indexOf > -1) {
            alunos.set(indexOf, aluno);
        } else {
            alunos.add(aluno);
        }
        return aluno;
    }
    
    public boolean remover(Aluno aluno){
        return alunos.remove(aluno);
    }
    
    public Aluno buscarPorId(Long id){
        for (Aluno aluno : alunos) {
            if(id.equals(aluno.getId())){
                return aluno;
            }
        }
        return null;
    }

    public Aluno buscarPorEmail(String email){
        for (Aluno aluno : alunos) {
            if(email.equals(aluno.getEmail())){
                return aluno;
            }
        }
        return null;
    }
    
    
}
