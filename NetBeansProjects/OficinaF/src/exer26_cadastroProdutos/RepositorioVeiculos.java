/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer26_cadastroProdutos;

import cadastroclientes.ProdutoApp;
import static cadastroclientes.ProdutoApp.CONSTANTE;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 88178
 */
public class RepositorioVeiculos {

    private static ArrayList<Veiculo> lista = new ArrayList<>();

//    salvar;
//    listar;
//    buscarporID
//    buscarTodos
//    buscarPorplaca;
//    buscarpor marca;
//    buscarpor modelo;
//    buscarporAno fabricacao;
//    buscaranomodelo;
//    remover;
    public void salvar(Veiculo veiculo) {
        File file = new File(CONSTANTE);
        Date agora = new Date();

        if (veiculo == null) {
            return;
        }
        if (veiculo.getId() == null) {
            veiculo.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(veiculo);
        if (index > -1) {
            lista.set(index, veiculo);
            veiculo.setDataAltercao(agora);
        } else {
            veiculo.setDataCriacao(agora);
            veiculo.setDataAltercao(agora);
            ProdutoApp.gravarUtilizandoFilerPrintWriter(file, veiculo);
            lista.add(veiculo);
        }

    }

    public void remover(Veiculo veiculo) {
        lista.remove(veiculo);
    }

    public ArrayList<Veiculo> buscarTodos() {
        return lista;

    }

    public ArrayList<Veiculo> listarMarca(String marca) {
        ArrayList<Veiculo> listaMarca = new ArrayList<Veiculo>();
        for (Veiculo novo : lista) {
            if (marca.equalsIgnoreCase(novo.getMarca())) {
                listaMarca.add(novo);
            }

        }
        return listaMarca;
    }

    public ArrayList<Veiculo> listarModelo(String modelo) {
        ArrayList<Veiculo> listaModelo = new ArrayList<Veiculo>();
        for (Veiculo novo : listaModelo) {
            if (modelo.equalsIgnoreCase(novo.getModelo())) {
                listaModelo.add(novo);

            }

        }
        return listaModelo;
    }

    public ArrayList<Veiculo> listarAnoFab(int anoFabricacao) {
        ArrayList<Veiculo> listaAnoFab = new ArrayList<>();
        for (Veiculo novo : listaAnoFab) {
            if (anoFabricacao == (novo.getAnoFabricacao())) {
                listaAnoFab.add(novo);
            }

        }
        return listaAnoFab;
    }

    public ArrayList<Veiculo> listarAnoModelo(int anoModelo) {
        ArrayList<Veiculo> listaAnoModelo = new ArrayList<>();
        for (Veiculo novo : listaAnoModelo) {
            if (anoModelo == (novo.getAnoModelo())) {
                listaAnoModelo.add(novo);
            }

        }
        return listaAnoModelo;
    }

    public Veiculo buscarPorId(Long id) {
        for (Veiculo novo : lista) {
            if (id.equals(novo.getId())) {
                return novo;
            }
        }
        return null;
    }

    public Veiculo buscarPorplacas(String placa) {
        for (Veiculo novo : lista) {
            if (placa.equals(novo.getPlaca())) {
                return novo;
            }
        }
        return null;
    }

}
