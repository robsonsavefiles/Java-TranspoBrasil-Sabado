package exemplos.adapter.sistema2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Repositorio {

    private static final List<Cliente> lista = new ArrayList();

    static {
        lista.add(new Cliente("Cliente 01", "Sistema 02", "363653089", 26));
        lista.add(new Cliente("Cliente 02", "Sistema 02", "357347356", 34));
        lista.add(new Cliente("Cliente 03", "Sistema 02", "675745646", 75));
        lista.add(new Cliente("Cliente 04", "Sistema 02", "634526347", 43));
        lista.add(new Cliente("Cliente 05", "Sistema 02", "124624577", 21));
    }

    public static List<Cliente> getClientes() {
        return lista;
    }
}
