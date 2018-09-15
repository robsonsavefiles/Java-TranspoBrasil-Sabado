
package br.com.proway.java.adapter;

import br.com.proway.java.adapter.sistema2.Cliente;

/**
 *
 * @author 89087
 */
public class ClienteSistema2 implements ClienteAdapter {

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteSistema2(Cliente cliente) {
        this.cliente = cliente;
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
