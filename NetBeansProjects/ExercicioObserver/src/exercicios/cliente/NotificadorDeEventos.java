package exercicios.cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class NotificadorDeEventos {

    private static NotificadorDeEventos instance;

    private final Map<String, List<OuvinteDeEventos>> ouvintes = new HashMap();

    private NotificadorDeEventos() {
    }

    public static NotificadorDeEventos getInstance() {
        if (instance == null) {
            instance = new NotificadorDeEventos();
        }
        return instance;
    }

    public void registrarOuvinte(OuvinteDeEventos<? extends Evento> ouvinte) {
        List<OuvinteDeEventos> lista = ouvintes.get(ouvinte.getTipo());
        if (lista == null) {
            lista = new ArrayList();
            ouvintes.put(ouvinte.getTipo(), lista);
        }
        lista.add(ouvinte);
    }

    public void removerOuvinte(OuvinteDeEventos<? extends Evento> ouvinte) {
        List<OuvinteDeEventos> lista = ouvintes.get(ouvinte.getTipo());
        if (lista != null) {
            lista.remove(ouvinte);
        }
    }

    public void dispararEvento(Evento evento) {
        List<OuvinteDeEventos> lista = ouvintes.get(evento.getTipo());
        if (lista != null) {
            lista.stream().forEach((ouvinte) -> ouvinte.onEventoDisparado(evento));
        }
    }

}
