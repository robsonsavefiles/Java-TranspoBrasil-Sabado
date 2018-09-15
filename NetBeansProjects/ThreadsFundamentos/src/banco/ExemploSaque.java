
package banco;

import banco.Conta;

/**
 *
 * @author 89087
 */
public class ExemploSaque {
    
    public static void  main (String[] args){
        
        Conta conta = new Conta();
        final GerenciadorContas  gerenciadorContas = new GerenciadorContas(conta);
        Thread joao = new Thread (gerenciadorContas, "ROBSON");
        Thread lane = new Thread (gerenciadorContas,"LANE");
        
        joao.start();
        lane.start();
        
    }

}
