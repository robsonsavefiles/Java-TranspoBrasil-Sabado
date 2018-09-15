package exemplos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class Controlador {

    private List<Integer> lista = new ArrayList<Integer>();

    public synchronized void adicionar(Integer valor) {
        System.out.println("Adicionando");
        lista.add(valor);
        notifyAll();
    }

    public synchronized void remover() {
        System.out.println("Removendo");
        if (lista.isEmpty()) {
            try {
                wait();
            }catch(InterruptedException ex) {
                System.out.println("Falha ao esperar");
            }
        }
        System.out.println(lista.remove(0));
    }
}
