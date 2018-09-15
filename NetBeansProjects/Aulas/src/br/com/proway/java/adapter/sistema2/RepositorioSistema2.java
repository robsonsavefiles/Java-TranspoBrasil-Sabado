package br.com.proway.java.adapter.sistema2;

import br.com.proway.java.adapter.sistema2.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class RepositorioSistema2 {

    private static ArrayList<Cliente> lista = new ArrayList<Cliente>();

    static {
        lista.add(new Cliente("Cliente 01", " Sistema2", "123", 20));
        lista.add(new Cliente("Cliente 02", "Sistema2", "123", 25));
        lista.add(new Cliente("Cliente 03 ", "Sistema", "123", 30));
        lista.add(new Cliente("Cliente 04 ", "Sistema2", "123", 35));
        lista.add(new Cliente("Cliente 05 ", "Sistema2", "123", 18));

    }

    public static List<Cliente> getCliente() {
        return lista;
    }

}
