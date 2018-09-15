
package implementacao;

import interfaces.Frete;

/**
 *
 * @author 89087
 */
public class SemFrete implements Frete {

    @Override
    public double calculaFrete(String uf) {
        if(uf.equals("SC")){
            return 0;
        }else{
            return 0;
        }
    }

}


