
package dados;



public class Threads1 extends Thread {
 
    public boolean ativo;
    String mensagem;
    
   
    public Threads1(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    @Override
    public void run(){
        super.run();
        
        
        
        while (ativo) {            
            System.out.println("Essa é a thread 2");
        }
        
        for (int i = 0; i < 100; i++) {
          
            try {
                System.out.println("Ola "+ mensagem);
                
                sleep(100);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
    
    
}
