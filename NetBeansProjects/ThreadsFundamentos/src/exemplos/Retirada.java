package exemplos;

import java.util.List;

/**
 *
 * @author 89087
 */
public class Retirada implements Runnable {

    private Controlador controlador;

    public Retirada(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            controlador.remover();

        }

    }

}
