/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class Removedor extends Thread{
    
    private boolean ativo;
    private Balde balde;

    public Removedor(Balde balde) {
        this.balde = balde;
    }
    

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
             try {
        while (true) {            
            balde.remover();
            
                sleep(400);
        }
        
            } catch (InterruptedException ex) {
                Logger.getLogger(Colocador.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
}
