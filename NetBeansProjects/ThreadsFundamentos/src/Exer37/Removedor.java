
package Exer37;

import parte2.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class Removedor extends Thread  {
    
    private Balde balde;

    public Removedor(Balde balde) {
        this.balde = balde;
    }
    

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try{
            while(true){
                balde.remover();
                sleep(100);
            }
        }catch (InterruptedException ex) {
                Logger.getLogger(Colocador1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    

}
