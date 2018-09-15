/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.controle;

import br.com.proway.oficina.modelo.Veiculo;
import br.com.proway.oficina.repositorio.RepositorioVeiculo;
import br.com.proway.oficina.repositorio.RepositorioVeiculoFactory;
import br.com.proway.oficina.repositorio.RepositorioVeiculoImplArq;
import br.com.proway.oficina.validador.ValidadorUtil;
import java.util.ArrayList;

/**
 *
 * @author felipe.oliveira
 */
public class CadastroVeiculoControle {

    private Veiculo veiculoAtual = null;
    private ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
    private RepositorioVeiculo repositorio = RepositorioVeiculoFactory.getRepositorioVeiculo();

    public void salvar() {
        repositorio.salvar(veiculoAtual);
        veiculoAtual = null;
    }

    public void novo() {
        veiculoAtual = new Veiculo(null, null, null, null, 0, 0, null, null, null);
    }

    public boolean editar(String placa) {
        veiculoAtual = repositorio.buscarPorPlaca(placa);
        return veiculoAtual != null;
    }

    public String getPlaca() {
        return ValidadorUtil.getValor(veiculoAtual != null ? veiculoAtual.getPlaca() : "");
    }

    public void configurarVeiculo(String placa, String marca, String modelo, String cor, int anoFabricacao, int anoModelo) {
        if (veiculoAtual != null) {
            veiculoAtual.setAnoFabricacao(anoFabricacao);
            veiculoAtual.setAnoModelo(anoModelo);
            veiculoAtual.setCor(cor);
            veiculoAtual.setMarca(marca);
            veiculoAtual.setModelo(modelo);
            veiculoAtual.setPlaca(placa);
        }
    }

    public int contarVeiculos() {
        if(lista.isEmpty()){
            lista = repositorio.buscarTodos();
        }
        return lista.size();
    }

    public String getPlaca(int index) {
        return VeiculoFormat.getPlaca(lista.get(index));
    }

    public String getMarca(int index) {
        return VeiculoFormat.getMarca(lista.get(index));
    }

    public String getModelo(int index) {
        return VeiculoFormat.getModelo(lista.get(index));
    }

    public String getCor(int index) {
         return VeiculoFormat.getCor(lista.get(index));
    }

    public int getAnoFabricacao(int index) {
        return VeiculoFormat.getAnoFabricacao(lista.get(index));
    }

    public int getAnoModelo(int index) {
        return VeiculoFormat.getAnoModelo(lista.get(index));
    }

}
