package adicionais;

import interfaces.Adicional;
import interfaces.Bebida;

/**
 *
 * @author 78522
 */
public class Gelo extends Adicional {

    public Gelo(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return getBebida().getDescricao() + ", Gelo";
    }

}
