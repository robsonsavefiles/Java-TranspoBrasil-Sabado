
package implementacoes;

import interfaces.Frete;

public class Correios implements Frete {

    @Override
    public double calculaFrete(String uf) {
        if (uf.equals("SC")) {
            return 0;
        } else {
            return 10;
        }
    }

}
