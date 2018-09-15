package br.com.oficinaV2.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *um listener  que ocorre 
 * @author 89087
 */
public class NotificadorDeEventos {

    private static NotificadorDeEventos instance;

    private final Map<String,List<OuvinteDeEventos>> ouvintes = new HashMap();

    private NotificadorDeEventos() {
    }
    /**
     * Retorna a instancia  atual do notificador de eventos
     * @return 
     */

    public static NotificadorDeEventos getInstance() {//uso de padrao de projeto sington
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
    /**
     * dispara um evento para todos os ouvintes do eventos
     *
     * @param evento */
    public void dispararEvento(Evento evento) {
        List<OuvinteDeEventos> lista = ouvintes.get(evento.getTipo());
        if (lista != null) {
            lista.stream().forEach((ouvinte) -> ouvinte.onEventoDisparado(evento));
        }
    }

}
