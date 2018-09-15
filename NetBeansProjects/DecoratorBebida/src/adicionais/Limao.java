package adicionais;

import interfaces.Adicional;
import interfaces.Bebida;

/**
 *
 * @author 89087
 */
public class Limao extends Adicional {

    public Limao(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return getBebida().getDescricao() + ", Limão";
    }

}
