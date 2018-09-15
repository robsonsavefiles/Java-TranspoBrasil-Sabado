package br.com.proway.java.adapter;

import br.com.proway.java.adapter.sistema1.Cliente;
import br.com.proway.java.builder.Nome;

/**
 *
 * @author 89087
 */
public class ClienteSistema1 implements ClienteAdapter {

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteSistema1(Cliente cliente) {
        this.cliente = cliente;
    }
     public Cliente getCliente() {
        return cliente;
    }
    @Override
    public String getNomeCompleto() {
        return cliente.getNome();
    }

    @Override
    public String getCPF() {
       return cliente.getCpf();
    }

    @Override
    public String getIdade() {
        return String.valueOf(cliente.getIdade());
    }

  

}
