
package adicionais;
import interfaces.Adicional;
import interfaces.Bebida;
/**
 *
 * @author 89087
 */
public class Adocante extends Adicional{

    public Adocante(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return getBebida().getDescricao() + ", Adoçante";
        
    }

}
