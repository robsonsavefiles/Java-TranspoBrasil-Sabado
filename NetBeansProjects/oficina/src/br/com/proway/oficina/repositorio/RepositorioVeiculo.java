/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.oficina.repositorio;

import br.com.proway.oficina.modelo.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author felipe.oliveira
 */
public interface RepositorioVeiculo {

    public void salvar(Veiculo veiculo);

    public void remover(Veiculo veiculo);

    public Veiculo buscarPorId(Long id);

    public ArrayList<Veiculo> buscarTodos();

    public Veiculo buscarPorPlaca(String placa);

    public ArrayList<Veiculo> buscarPorMarca(String marca);

    public ArrayList<Veiculo> buscarPorModelo(String modelo);

    public ArrayList<Veiculo> buscarPorAnoFabricacao(int ano);

    public ArrayList<Veiculo> buscarPorAnoModelo(int ano);

}
