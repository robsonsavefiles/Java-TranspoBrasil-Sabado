
package parte1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class ExemplosThreads extends Thread {

    private String mensagem;
    private String joao;
    private String maria;
    
    public ExemplosThreads(String mensagem){//construtor
        this.mensagem= mensagem;
    }
    
    
  
    @Override
    public void run() {//vai ser chamando dentro do metodo start
        super.run();//define o o que o metodo faz
        
        for (int i = 0; i < 100; i++) {
            System.out.println("Ola -"+ mensagem);
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExemplosThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
    }
}