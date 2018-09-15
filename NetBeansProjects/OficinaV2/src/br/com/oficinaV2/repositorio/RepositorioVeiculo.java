/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficinaV2.repositorio;

import br.com.oficinaV2.modelo.Veiculo;
import java.util.List;

public interface RepositorioVeiculo {

    public void salvar(Veiculo veiculo);

    public void remover(Veiculo veiculo);

    public Veiculo buscarPorId(Long id);

    public List<Veiculo> buscarTodos();

    public Veiculo buscarPorPlaca(String placa);

    public List<Veiculo> buscarPorMarca(String marca);

    public List<Veiculo> buscarPorModelo(String modelo);

    public List<Veiculo> buscarPorAnoFabricacao(int ano);

    public List<Veiculo> buscarPorAnoModelo(int ano);

}
