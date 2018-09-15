package br.com.proway.java.factory.clientes;

import br.com.proway.java.factory.FabricaDeRelatorio;
import br.com.proway.java.factory.FabricaRelatorio;
import br.com.proway.java.factory.Relatorio;
import br.com.proway.java.factory.RelatorioJson;

/**
 *
 * @author 89087
 */
public class ClienteA {

    public static void main(String[] args) throws Exception {
        //simula a passagem de infomado atraves de uma configuraçao externa
        //System.setProperty("tipoRelatorio", "HTML");
        Sistema sistema = new Sistema();
        FabricaDeRelatorio fabrica = sistema.getFabricaDeRelatorio();
        Relatorio relatorio = fabrica.getRelatorio();
        System.out.println(relatorio.gerar());

    }

}
