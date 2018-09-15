
package implementacao;

import interfaces.Frete;
/**
 *
 * @author 89087
 */
public class Correios implements Frete {

    @Override
    public double calculaFrete(String uf) {
        if(uf.equals("SC")){
            return 0;
        }else{
            return 10;
        }
    }

}
