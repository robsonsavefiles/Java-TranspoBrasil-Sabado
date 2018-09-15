package exemplos.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Observavel {

    private final List<Observador> lista = new ArrayList();

    private final List<String> itens = new ArrayList();

    public void registrarObservador(Observador observador) {
        if (!lista.contains(observador)) {
            lista.add(observador);
        }
    }

    public void removerObservador(Observador observador) {
        lista.remove(observador);
    }

    public void onEventoOcorrido(String data) {
        lista.stream().forEach((observador) -> observador.notificar(data));
    }

    public void adicionarItem(String item) {
        itens.add(item);
        onEventoOcorrido(item);
    }

}
