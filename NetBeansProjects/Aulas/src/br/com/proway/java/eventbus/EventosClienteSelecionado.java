
package br.com.proway.java.eventbus;

import br.com.proway.java.builder.Cliente;

/**
 *
 * @author 89087
 */
public class EventosClienteSelecionado implements  Evento{
    
    private final Cliente cliente;

    public EventosClienteSelecionado(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    
    @Override
    public String getTipo() {
        return this.getClass().getName();
    }
    

}
