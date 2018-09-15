
package br.com.proway.java.factory;

public class FabricaRelatorioJson implements FabricaDeRelatorio{

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio("Json");
    }

}
