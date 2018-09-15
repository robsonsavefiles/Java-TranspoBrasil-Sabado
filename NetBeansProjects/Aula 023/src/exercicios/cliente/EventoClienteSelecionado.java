package exercicios.cliente;

import exercicios.cliente.model.Cliente;

/**
 *
 * @author 78522
 */
public class EventoClienteSelecionado implements Evento {

    private final Cliente cliente;

    public EventoClienteSelecionado(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String getTipo() {
        return this.getClass().getName();
    }

    public Cliente getCliente() {
        return cliente;
    }

}
