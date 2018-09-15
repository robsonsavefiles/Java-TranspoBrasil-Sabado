package exemplos.interruptor;

/**
 *
 * @author 78522
 */
public class Lampada implements Ligavel {

    @Override
    public void ligar() {
        System.out.println("Lampada ligada");
    }

    @Override
    public void desligar() {
        System.out.println("Lampada desligada");
    }
}
