
package br.com.proway.java.adapter.sistema1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class RepositorioSistema1 {
    
    private static List<Cliente> lista = new ArrayList<Cliente>();
    static{
    lista.add(new Cliente("Cliente 01 Sistema1","123",20));
    lista.add(new Cliente("Cliente 02 Sistema1","123",25));
    lista.add(new Cliente("Cliente 03 Sistema1","123",30));
    lista.add(new Cliente("Cliente 04 Sistema1","123",35));
    lista.add(new Cliente("Cliente 05 Sistema1","123",18));
    
    }
    public static List<Cliente> getCliente(){
        return lista;
    }
            

}
