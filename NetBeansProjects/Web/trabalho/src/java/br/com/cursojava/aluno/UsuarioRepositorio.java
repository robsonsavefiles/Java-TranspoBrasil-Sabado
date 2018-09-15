

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cursojava.aluno;
import java.util.List;
import java.util.ArrayList;
import br.com.cursojava.aluno.Aluno;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class UsuarioRepositorio {

    private static List<Aluno> lista = new ArrayList<Aluno>();

    static {
        lista.add(new Aluno(1L,"Robson Ferreira de Melo", "robinhotri@hotmail.com", "348.602.348-98","43.915.694-4","33839482",new Endereco("Rua C","43","Casa","Guaruja","São Paulo","Brazil"),Escolaridade.ENSINO_SUPERIOR,Sexo.MASCULINO));
        
    }

    public List<Aluno> buscarTodos() {
        return lista;
    }

    public Aluno salvar(Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(aluno);
        if (index > -1) {
            lista.set(index, aluno);
        }
        return aluno;
    }

    public boolean remover(Aluno aluno) {
        return lista.remove(aluno);
    }

    public Aluno buscarPorId(Long id) {
        for (Aluno aluno : lista) {
            if (id.equals(aluno.getId())) {
                return aluno;
            }
        }
        return null;
    }

    public Aluno buscarPorEmail(String email) {
        for (Aluno aluno : lista) {
            if (email.equals(aluno.getEmail())) {
                return aluno;
            }
        }
        return null;
    }
}
