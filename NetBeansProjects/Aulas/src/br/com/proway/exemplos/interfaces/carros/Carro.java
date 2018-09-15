package exemplos.interfaces.carros;

/**
 *
 * @author 78522
 */
public class Carro{

    private double velocidade;

    public Carro(double velocidade) {
        this.velocidade = velocidade;
    }

    public void correr() {
        System.out.println("Andando a " + velocidade);
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
}
