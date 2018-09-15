package br.com.proway.java.eventbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificadorEventos {

    //Variavel que contera a unica instancia do notificador no sistema.
    private static NotificadorEventos INSTANCE;

    private Map<String, List<OuvinteDeEventos>> ouvintes = new HashMap<>();

    private NotificadorEventos() {
    }

    /**
     * Retorna a instancia atual do notificador de eventos, caso nao exista sera
     * criada
     *
     * @return NotificadorDeEventos
     */
    public NotificadorEventos getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotificadorEventos();
        }
        return INSTANCE;
    }

    public void registarOuvinte(OuvinteDeEventos<? extends Evento> ouvinte) {
        List<OuvinteDeEventos> lista = ouvintes.get(ouvinte.getTipo());
        if (lista == null) {
            lista = new ArrayList<>();
            ouvintes.put(ouvinte.getTipo(), lista);
        }
        lista.add(ouvinte);

    }
     public void removerOuvinte(OuvinteDeEventos<? extends Evento> ouvinte) {
        List<OuvinteDeEventos> lista = ouvintes.get(ouvinte.getTipo());
        if (lista == null) {
            lista.remove(ouvinte);
        }
        lista.add(ouvinte);

    }
    public void disparaEventos(Evento evento){
        List<OuvinteDeEventos> lista = ouvintes.get(evento.getTipo());
        if(lista != null){
            for(OuvinteDeEventos ouvinte : lista){
                ouvinte.onEventoDisparado(evento);
            }
        }
    } 
    
            
}
