
package br.com.proway.java.factory;

public class FabricaRelatorio implements FabricaDeRelatorio{

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio("TXT");
    }

}
