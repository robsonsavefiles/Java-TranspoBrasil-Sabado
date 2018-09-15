/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclientes;

import cadastroclientes.ClientesGravar;
import static cadastroclientes.ClientesGravar.CONSTANTE;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class RepositorioClientes {
    
     private static ArrayList<Cliente> lista = new ArrayList<>();
    
        public void salvar(Cliente cliente) {
            File file = new File(CONSTANTE);
            Date agora = new Date();
            

        if (cliente == null) {
            return;
        }
        if (cliente.getId() == null) {
            cliente.setId(System.currentTimeMillis());
        }
        int index = lista.indexOf(cliente);
        if (index > -1) {
            lista.set(index, cliente);
            cliente.setDataAltercao(agora);
        } else {
            //cliente.setDataCriacao(agora);
            cliente.setDataAltercao(agora);
            ClientesGravar.gravarUtilizandoFilerPrintWriter(file, cliente);
            
            lista.add(cliente);
        }

    }

    public void remover(Cliente cliente) {
        lista.remove(cliente);
    }

    public ArrayList<Cliente> buscarTodos() {
        return lista;

    }

//    public ArrayList<Cliente> listarPorCpf(String cpf) {
//        ArrayList<Cliente> listaCPF = new ArrayList<Cliente>();
//        for (Cliente novo : lista) {
//           if (cpf.equalsIgnoreCase()) {
//                listaCPF.add(novo);
//            }
//
//        }
//        return listaCPF;
//    }

    public ArrayList<Cliente> listarNome(String nome) {
        ArrayList<Cliente> listaNome = new ArrayList<Cliente>();
        for (Cliente novo : listaNome) {
            if (nome.equalsIgnoreCase(novo.getNome())) {
                listaNome.add(novo);
                
            }

        }
        return listaNome;
    }

    public Cliente buscarPorId(Long id) {
        for (Cliente novo : lista) {
            if (id.equals(novo.getId())) {
                return novo;
            }
        }
        return null;
    }
    

    
}

    

