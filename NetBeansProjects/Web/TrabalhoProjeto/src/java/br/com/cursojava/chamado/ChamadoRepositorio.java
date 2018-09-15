/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.chamado;

import br.com.cursojava.projeto.Projeto;
import br.com.cursojava.projeto.ProjetoRepositorio;
import br.com.cursojava.providencia.ProvidenciaRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class ChamadoRepositorio {

    private static List<Chamado> chamados = new ArrayList<>();

    static {
        ProjetoRepositorio projeto = new ProjetoRepositorio();
        ProvidenciaRepositorio providencia = new ProvidenciaRepositorio();

        chamados.add(new Chamado(1L, "Reparo nos codigos", "fazer reparos nos codigos com erros", Status.ABERTO, providencia.buscarTodos().get(0), projeto.buscarTodos().get(0)));
        chamados.add(new Chamado(2L, "Incidente ", "Computadores da sala nao ligam", Status.ABERTO, providencia.buscarTodos().get(1), projeto.buscarTodos().get(0)));
        chamados.add(new Chamado(3L, "Desenvolvimento", "Criar novas funcionalidades para sistema Tasy", Status.FECHADO, providencia.buscarTodos().get(2), projeto.buscarTodos().get(0)));

    }

    public List<Chamado> buscarTodos() {
        return chamados;
    }

    public Chamado salvar(Chamado chamado) {
        if (chamado.getId() == null) {
            chamado.setId(System.currentTimeMillis());
        }
        int indexOf = chamados.indexOf(chamado);
        if (indexOf > -1) {
            chamados.set(indexOf, chamado);
        } else {
            chamados.add(chamado);
        }
        return chamado;
    }

    public boolean remover(Chamado chamado) {
        return chamados.remove(chamado);
    }

    public Chamado buscarPorId(Long id) {
        for (Chamado chamado : chamados) {
            if (id.equals(chamado.getId())) {
                return chamado;
            }
        }
        return null;
    }

    public List<Chamado> buscarPorProjeto(Long id) {
        List<Chamado> listaProjeto = new ArrayList<>();
        for(Chamado chamado:chamados) {
            if (id.equals(chamado.getProjeto().getId())) {
                listaProjeto.add(chamado);
            }
        }
        return listaProjeto;
    }
}
