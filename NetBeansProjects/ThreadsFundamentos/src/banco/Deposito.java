package banco;

import exemplos.Controlador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Deposito implements Runnable {

    private Controlador controlador;

    public Deposito(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            controlador.adicionar(i);

        }
    }

}
