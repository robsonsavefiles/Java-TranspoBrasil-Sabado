/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.certificacoes;

import br.com.cursojava.professor.Professor;
import br.com.cursojava.professor.ProfessorRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class CertificacaoRepositorio {

    private static List<Certificacao> lista = new ArrayList<Certificacao>();

    static {
        CertificacaoRepositorio certificacao = new CertificacaoRepositorio();
        lista.add(new Certificacao(1L,"Lingua Portuguesa Apurada","Academia de letras de São Paulo"));
        lista.add(new Certificacao(2L,"Java","Oracle"));
        lista.add(new Certificacao(3L,"Abap","SAP"));
        lista.add(new Certificacao(4L,"ITIL","Proway"));
        
    }

    public Certificacao salvar(Certificacao certificacao) {
        if (certificacao == null) {
            return null;
        }
        if (certificacao.getId() == null) {
            certificacao.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(certificacao);
        if (index > -1) {
            lista.set(index, certificacao);
        } else {
            lista.add(certificacao);
        }
        return certificacao;
    }

    public boolean remover(Certificacao certificacao) {
        return lista.remove(certificacao);
    }

    public List<Certificacao> buscarTodos() {
        return lista;
    }

    public Certificacao buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        for (Certificacao certificacao : lista) {
            if (id.equals(certificacao.getId())) {
                return certificacao;
            }
        }
        return null;
    }

}
