package exercicios.isp2;

/**
 *
 * @author 78522
 */
public class Lamborghini implements Carro, Turbinavel, Refrigeravel {

    @Override
    public void acelerar() {
        System.out.println("Estou acelerando!");
    }

    @Override
    public void ligar() {
        System.out.println("Estou ligado!");
    }

    @Override
    public void ativarTurbo(double velocidade, int segundos) {
        System.out.println("Ativei o turbo na velocidade " + velocidade + " por " + segundos + " segundos!");
    }

    @Override
    public void ativarArCondicionado() {
        System.out.println("Ativei o ar-condicionado!");
    }

}


