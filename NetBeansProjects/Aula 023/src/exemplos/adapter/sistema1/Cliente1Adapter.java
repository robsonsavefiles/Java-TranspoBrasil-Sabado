package exemplos.adapter.sistema1;

import exemplos.adapter.ClienteAdapter;

/**
 *
 * @author 78522
 */
public class Cliente1Adapter implements ClienteAdapter {

    private final Cliente cliente;

    public Cliente1Adapter(Cliente cliente) {
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
