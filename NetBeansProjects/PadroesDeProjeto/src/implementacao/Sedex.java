package implementacao;

import interfaces.Frete;

/**
 *
 * @author 89087
 */
public class Sedex implements Frete {

    @Override
    public double calculaFrete(String uf) {
        if (uf.equals("RJ")) {
            return 20;

        } else {
            return 15;
        }
    }

}
