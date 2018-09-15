
package parte1;

/**
 *
 * @author 89087
 */
public class Estudos_Thread{
  public static void main(String[] args){
    // vamos criar duas threads
    MinhaThread t1 = new MinhaThread("Thread 1");
    t1.start(); // chamamos o método start() e não run()

    MinhaThread t2 = new MinhaThread("Thread 2");
    t2.start(); // chamamos o método start() e não run()    

  }
}
