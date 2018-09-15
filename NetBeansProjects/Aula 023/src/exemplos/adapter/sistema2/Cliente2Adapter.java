package exemplos.adapter.sistema2;

import exemplos.adapter.ClienteAdapter;

/**
 *
 * @author 78522
 */
public class Cliente2Adapter implements ClienteAdapter {

    private final Cliente cliente;

    public Cliente2Adapter(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String getNomeCompleto() {
        return cliente.getNome() + " " + cliente.getSobrenome();
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
