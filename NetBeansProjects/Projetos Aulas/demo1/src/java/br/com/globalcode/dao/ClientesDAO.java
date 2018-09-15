package br.com.globalcode.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientesDAO {
    
    public static ClientesDAO instance = new ClientesDAO();
    private Map bancoDados;
    private ClientesDAO() {
        bancoDados = new HashMap();
        bancoDados.put("MG",new String[]
        {"Belo Horizonte", "Uberaba", "Uberlandia"});
        bancoDados.put("RJ",new String[]
        {"Buzios", "Cabo Frio","Rio de Janeiro"});
        bancoDados.put("SP",new String[]
        {"Campinas", "Santos","São Paulo"});
    }
    
    public static ClientesDAO getInstance() {
        return instance;
    }
    
    public List getCidades(String estado) {
        String[] cidades = (String[]) bancoDados.get(estado);
        return Arrays.asList(cidades);
    }
}

