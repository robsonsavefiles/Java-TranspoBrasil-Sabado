package br.com.proway.java.adapter;

import br.com.proway.java.adapter.sistema1.RepositorioSistema1;
import br.com.proway.java.adapter.sistema2.RepositorioSistema2;
import java.util.List;

public class RelatorioCliente {

    public static void main(String[] args) {

        List<br.com.proway.java.adapter.sistema1.Cliente> lista1 = br.com.proway.java.adapter.sistema1.RepositorioSistema1.getCliente();
        List<br.com.proway.java.adapter.sistema2.Cliente> lista2 = br.com.proway.java.adapter.sistema2.RepositorioSistema2.getCliente();
        ClienteSistema1 clienteSistema1 = new ClienteSistema1(null);
        for (br.com.proway.java.adapter.sistema1.Cliente cliente : lista1) {
             gerarRelatorio(new ClienteSistema1(cliente));
        }

        ClienteSistema2 clienteSistema2 = new ClienteSistema2(null);
        for (br.com.proway.java.adapter.sistema2.Cliente cliente : lista2) {
            gerarRelatorio(new ClienteSistema2(cliente));

            gerarRelatorio(clienteSistema1);
        }
    }

    public static void gerarRelatorio(ClienteAdapter cliente) {

        System.out.println("========INICIO RELATORIO==========");
        System.out.println("Nome:" + cliente.getNomeCompleto());
        System.out.println("CPF:" + cliente.getCPF());
        System.out.println("Idade:" + cliente.getIdade());

    }
}
