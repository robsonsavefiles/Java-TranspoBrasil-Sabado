
package modelo;
import implementacao.Correios;
import interfaces.Frete;
/**
 *
 * @author 89087
 */
public class Transporte implements Frete{
    
    private  Frete frete;
    public Frete getFrete(){
        return frete;
    }

    
    @Override
    public double calculaFrete(String uf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
