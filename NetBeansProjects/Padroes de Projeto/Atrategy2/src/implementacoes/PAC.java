
package implementacoes;

import interfaces.Frete;

public class PAC implements Frete {

    @Override
    public double calculaFrete(String uf) {
        if (uf.equals("SP")) {
            return 5;
        } else {
            return 15;
        }
    }

}