package interfaces;

public abstract class Adicional extends Bebida {

    private Bebida bebida;

    public Adicional(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public abstract String getDescricao();

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

}
