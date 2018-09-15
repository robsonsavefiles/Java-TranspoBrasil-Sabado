package exercicios.cliente.dao;

import exercicios.cliente.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ClienteDao {
    
    private static ClienteDao instance;
    
    private static final List<Cliente> lista = new ArrayList();
    
    private ClienteDao() {
    }
    
    public static ClienteDao getInstance() {
        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }
    
    public void salvar(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        
        if (cliente.getId() == null) {
            cliente.setId(System.nanoTime());
        }
        
        int idx = lista.indexOf(cliente);
        
        if (idx > -1) {
            lista.set(idx, cliente);
        } else {
            lista.add(cliente);
        }
    }
    
    public void remove(Cliente cliente) {
        lista.remove(cliente);
    }
    
    public List<Cliente> getTodos() {
        return lista;
    }
}
