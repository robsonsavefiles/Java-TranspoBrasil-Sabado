package exemplos.interruptor;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Interruptor inte = new Interruptor(new Lampada());
        Interruptor inte2 = new Interruptor(new Ventilador());

        inte.ligar();
        inte.desligar();

        inte2.ligar();
        inte2.desligar();
    }
}
