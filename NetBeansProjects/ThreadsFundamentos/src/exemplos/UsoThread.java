
package exemplos;

/**
 *
 * @author 89087
 */
public class UsoThread {
    public static void main(String[] args) {
        
        System.out.println("Nome da Thread é "+Thread.currentThread().getName());
        Thread maria  = new Thread(new MeuContadorThread(),"Dona Maria");
        Thread joao  = new Thread(new MeuContadorThread(),"Seu João");
        maria.start();
        joao.start();
        System.out.println("Fim do Main");
                
    }

}
