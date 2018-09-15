package banco;

import banco.Conta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 89087
 */
public class GerenciadorContas implements Runnable {

    private Conta conta;

    public GerenciadorContas(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            fazerSaque(10);
            if (conta.getSaldo() < 0) {
                System.out.println("Estorou a Conta!!!");
            }
        }

    }

    private synchronized void fazerSaque(int valor) {
        //verifica se tem dinheiro suficiente para sacar
        if (conta.getSaldo() >= valor) {
            System.out.printf("%s vai sacar\r\n", Thread.currentThread().getName());
            try {
                //Aguarda meio segundo para realizar o saque
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            conta.sacar(valor);
            System.out.printf("%s Realizou o saque \r\n", Thread.currentThread().getName());
        } else {
            System.out.printf("Nao foi possivel realizar o saque para %s no valor de %d \r\n",
                    Thread.currentThread().getName(), conta.getSaldo());
        }

    }
}
