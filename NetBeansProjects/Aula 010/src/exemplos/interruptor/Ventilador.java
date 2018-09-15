package exemplos.interruptor;

/**
 *
 * @author 78522
 */
public class Ventilador implements Ligavel {

    @Override
    public void ligar() {
        System.out.println("Ventilador ligado");
    }

    @Override
    public void desligar() {
        System.out.println("Ventilador desligado");
    }

}
