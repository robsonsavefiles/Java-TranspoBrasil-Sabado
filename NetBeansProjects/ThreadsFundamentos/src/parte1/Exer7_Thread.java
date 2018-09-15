
package parte1;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Exer7_Thread extends Thread{
    
     private Scanner teclado;
    private int numero;
    private int soma = 1;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Exer7_Thread(int numero) {
        this.numero = numero;
    }
     @Override
     public void run() {//vai ser chamando dentro do metodo start
        super.run();
      for (int i = numero; i >= 2; i--) {
            
            soma = soma * i;
      
           
            System.out.println(soma);
        }
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exer6_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}



