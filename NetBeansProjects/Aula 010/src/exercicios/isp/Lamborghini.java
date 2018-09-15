package exercicios.isp;

/**
 *
 * @author 78522
 */
public class Lamborghini implements Carro {

    @Override
    public void acelerar() {
        System.out.println("Estou acelerando!");
    }

    @Override
    public void ligar() {
        System.out.println("Estou ligado!");
    }

    @Override
    public void ativarTurbo() {
        System.out.println("Ativei o turbo!");
    }

    @Override
    public void ativarArCondicionado() {
        System.out.println("Ativei o ar-condicionado!");
    }

}





