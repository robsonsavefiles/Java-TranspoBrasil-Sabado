package banco;


/**
 *
 * @author 89087
 */
public class Conta {

    private int saldo = 50;

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void sacar(int valor) {
        saldo = saldo - valor;

    }
}
