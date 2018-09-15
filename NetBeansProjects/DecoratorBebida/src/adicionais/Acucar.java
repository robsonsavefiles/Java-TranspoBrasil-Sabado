package adicionais;

import interfaces.Adicional;
import interfaces.Bebida;


public class Acucar extends Adicional {

    public Acucar(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return getBebida().getDescricao() + ", Açucar";
    }

}
