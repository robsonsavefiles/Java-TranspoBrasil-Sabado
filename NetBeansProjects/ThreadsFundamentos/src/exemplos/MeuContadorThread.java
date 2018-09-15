package exemplos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class MeuContadorThread implements Runnable {

    @Override
    public void run() {// aqui vai todo o codigo que eu quero que rode em uma nova Thread/Processo.
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(100);
                System.out.printf("Thread %s contador = %d \r\n", Thread.currentThread().getName(), i);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }

        }
    }

}
