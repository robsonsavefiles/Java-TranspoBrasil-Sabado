

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cursojava.professor;
import br.com.cursojava.certificacoes.CertificacaoRepositorio;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 89087
 */
public class ProfessorRepositorio {

    private static List<Professor> lista = new ArrayList<Professor>();

    static {
        CertificacaoRepositorio certificacao = new CertificacaoRepositorio();
        
        lista.add(new Professor(1L,"Robson Ferreira de Melo", "Ferreira", "348.602.348-98","robinhoprof@hotmail.com",new Endereco("Rua C","43","Casa","Guaruja","São Paulo","Brasil"),"88174389",Escolaridade.ENSINO_SUPERIOR,certificacao.buscarTodos().get(0)));
        lista.add(new Professor(2L,"Felipe de Oliveira ", "Oliveira", "200.456.345-78","felipe.oliveria@gmail.com",new Endereco("Rua D","54","Apartamento","Blumenau","Santa Catarina","Brasil"),"789456123",Escolaridade.ENSINO_SUPERIOR,certificacao.buscarTodos().get(1)));
        lista.add(new Professor(3L,"Marciliano Perreira Fox ", "Perreira", "100.100.100-10","marcilianoprof@hotmail.com",new Endereco("Rua E","171","Fundos","D1","Dublin","Ireland"),"35392698974",Escolaridade.ENSINO_SUPERIOR,certificacao.buscarTodos().get(2)));
        lista.add(new Professor(4L,"Girafales Ce é Loko Safadao ", "Ce é Loko", "133.133.133-13","ceelokoprof@hotmail.com",new Endereco("Rua G","158","Comercial","D1","Dublin","Ireland"),"35392698974",Escolaridade.ENSINO_SUPERIOR,certificacao.buscarTodos().get(3)));
        
    }

    public List<Professor> buscarTodos(){
        return lista;
    }

    public Professor salvar(Professor professor) {
        if (professor.getId() == null) {
            professor.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(professor);
        if (index > -1) {
            lista.set(index, professor);
        }
        return professor;
    }

    public boolean remover(Professor professor) {
        return lista.remove(professor);
    }

    public Professor buscarPorId(Long id) {
        for (Professor professor : lista) {
            if (id.equals(professor.getId())) {
                return professor;
            }
        }
        return null;
    }

    public Professor buscarPorEmail(String email) {
        for (Professor professor : lista) {
            if (email.equals(professor.getEmail())) {
                return professor;
            }
        }
        return null;
    }
}
