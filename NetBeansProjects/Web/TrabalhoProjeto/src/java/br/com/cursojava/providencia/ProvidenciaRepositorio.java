/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.providencia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 66463
 */
public class ProvidenciaRepositorio {

    private static List<Providencia> providencias = new ArrayList<>();

    static {

        providencias.add(new Providencia(1L, "Sera feito o reparo com urgencia no dia 22/02/2017", Estagio.ANALISE, "Rafael dos santos"));
        providencias.add(new Providencia(2L, "Reparado agendando com os supervisores  no dia 22/12/2020", Estagio.ANALISE, "Rafael dos santos"));
        providencias.add(new Providencia(3L, "Construçao de codigos com alunos no dia  23/02/2017", Estagio.ANALISE, "Rafael dos santos"));

    }

    public List<Providencia> buscarTodos() {
        return providencias;
    }

    public Providencia salvar(Providencia providencia) {
        if (providencia.getId() == null) {
            providencia.setId(System.currentTimeMillis());
        }
        int indexOf = providencias.indexOf(providencia);
        if (indexOf > -1) {
            providencias.set(indexOf, providencia);
        } else {
            providencias.add(providencia);
        }
        return providencia;
    }

    public boolean remover(Providencia providencia) {
        return providencias.remove(providencia);
    }

    public Providencia buscarPorId(Long id) {
        for (Providencia providencia : providencias) {
            if (id.equals(providencia.getId())) {
                return providencia;
            }
        }
        return null;
    }

}
