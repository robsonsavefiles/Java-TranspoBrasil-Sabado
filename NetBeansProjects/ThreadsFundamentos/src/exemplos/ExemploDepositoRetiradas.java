package exemplos;

import banco.Deposito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class ExemploDepositoRetiradas {

    public static void main(String[] args) {

       Controlador controle = new Controlador();
        Thread deposito = new Thread(new Deposito(controle), "Deposito I");
        Thread retirada = new Thread(new Retirada(controle), "Retirada I");

        deposito.start();
        retirada.start();
        System.out.println("Fim do Main");
    }

}
