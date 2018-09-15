package adicionais;

import interfaces.Adicional;
import interfaces.Bebida;

/**
 *
 * @author 78522
 */
public class Creme extends Adicional {

    public Creme(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return getBebida().getDescricao() + ", Creme";
    }

}
