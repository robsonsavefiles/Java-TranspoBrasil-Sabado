/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class Thread8 extends Thread{
    
     
    private Scanner teclado;
    private int numero;
    private int soma = 1;

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Thread8(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        super.run();
  
        
        for (int i = numero; i >= 2; i--) {
            
            soma = soma * i;
      
           
            System.out.println(soma);
        try {
            sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
