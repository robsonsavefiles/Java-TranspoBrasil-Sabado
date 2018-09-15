
package parte1;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Exer6_Thread extends Thread{
    
    private Scanner teclado;
    private int numero;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Exer6_Thread(int numero) {
        this.numero = numero;
    }

    public void run() {//vai ser chamando dentro do metodo start
        super.run();
       for (int i = 1; i <= 10; i++) {
            System.out.println(numero - i);
      
        }
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exer6_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
