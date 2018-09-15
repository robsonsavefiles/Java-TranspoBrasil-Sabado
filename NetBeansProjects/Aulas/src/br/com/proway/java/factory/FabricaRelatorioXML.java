
package br.com.proway.java.factory;

public class FabricaRelatorioXML implements FabricaDeRelatorio{

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio("XML");
    }

}
