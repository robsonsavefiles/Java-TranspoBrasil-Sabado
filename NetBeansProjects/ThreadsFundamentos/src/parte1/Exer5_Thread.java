package parte1;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 89087
 */
public class Exer5_Thread extends Thread {

    private Scanner teclado;
     private int numero;
    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }
    public Exer5_Thread(int numero) {
        this.numero = numero;
    }

    public void run() {
        super.run();
       for (int i = 1; i <= 10; i++) {
            System.out.println(numero + i);
        }
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exer5_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
