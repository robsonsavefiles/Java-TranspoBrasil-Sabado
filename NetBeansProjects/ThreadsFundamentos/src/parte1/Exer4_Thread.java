
package parte1;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Exer4_Thread extends Thread {
     private Scanner teclado;
    private int numero1;
    private int numero2;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Exer4_Thread(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
   
    public void run() {
     super.run();
      for(int i = 1; i < 10 && numero1 > 1; i++){
            System.out.println(numero1);
            int numA = numero1;
            numero1 = numero1 - (numero1 - numero2);
            numero2 = numA - (numero1);
            try {
                sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exer4_Thread.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }
}
    


