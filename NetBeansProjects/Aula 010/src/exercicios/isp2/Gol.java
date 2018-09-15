package exercicios.isp2;

/**
 *
 * @author 78522
 */
public class Gol implements Carro, Refrigeravel {

    @Override
    public void acelerar() {
        System.out.println("Estou acelerando!");
    }

    @Override
    public void ligar() {
        System.out.println("Estou ligado!");
    }

    @Override
    public void ativarArCondicionado() {
        System.out.println("Ativei o ar-condicionado!");
    }

}




