/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficinaV2.repositorio;

import br.com.oficinaV2.modelo.Cliente;
import java.util.List;

public interface RepositorioCliente {

    public void salvar(Cliente cliente);

    public void remover(Cliente veiculo);

    public Cliente buscarPorNome(String nome);

    public List<Cliente> buscarTodos();

    public Cliente buscarPorCpf(String cpf);

    
}
