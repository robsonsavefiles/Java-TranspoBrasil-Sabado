/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroclientes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ValidadorCliente {
    private String cpf;
   

    public ArrayList<ErroCliente> getErros(Cliente cliente) {

        ArrayList<ErroCliente> lista = new ArrayList<>();
        lista.add(validarNome(cliente));
        lista.add(validarCPF(cliente));
    

        for (ErroCliente retorno : lista) {
            if (retorno == null) {
                lista.remove(retorno);
            }
            
        }
        return lista;
    }

    public ErroCliente validarNome(Cliente cliente) {

        if (cliente.getNome().equalsIgnoreCase("")) {
            //ErroCliente err1 = new ErroCliente("Nome", "Nome Invalido");
            
           // return err1;
        }
        return null;
    }

   
    public ErroCliente validarCPF(Cliente cliente) {
       
       if (cliente.getCpf(cpf).equalsIgnoreCase("")) {
            //ErroCliente err2 = new ErroCliente("CPF", "CPF Invalido");
            
           // return err2;
        }
        return null;
    }
      
      public ErroCliente validarTelefone(Cliente cliente) {

        if (cliente.getTelefone().equalsIgnoreCase("")) {
            //ErroCliente err3 = new ErroCliente("Telefone", "Telefone Invalido");
            
            //return err3;
        }
        return null;
    }


    public int pegarDataAtual() {

        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();

        int ano = calendar.get(Calendar.YEAR);

        return ano;
    }

}

