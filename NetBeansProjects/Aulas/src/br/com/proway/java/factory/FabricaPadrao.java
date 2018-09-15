
package br.com.proway.java.factory;

/**
 *
 * @author 89087
 */
public class FabricaPadrao implements FabricaDeRelatorio {

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio("TXT");
    }

}
