package br.com.oficinaV2.repositorio;

import br.com.oficinaV2.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class RepositorioClienteImpl implements RepositorioCliente {

    private static List<Cliente> lista = new ArrayList<>();

    static {
        lista.add(new Cliente("Robson", "348.602.348-98", "13-33839482", "BXZ8990", "Rua C N°43 Santa Clara Guaruja"));

    }

    @Override
    public void salvar(Cliente cliente) {
        if (cliente == null) {
            return;
        }

        int index = lista.indexOf(cliente);
        if (index > -1) {
            lista.set(index, cliente);
        } else {
            lista.add(cliente);
        }
    }

    @Override
    public void remover(Cliente cliente) {
        lista.remove(cliente);
    }

    @Override
    public Cliente buscarPorNome(String nome) {
        for (Cliente cliente : lista) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return lista;

    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : lista) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        return null;
    }

}
