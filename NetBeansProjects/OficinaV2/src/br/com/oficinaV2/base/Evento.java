package br.com.oficinaV2.base;

/**
 *Interface base para a definiçao de eventos a serem tratatos por NotificadorDeEventos
 * @author 89087
 */
public interface Evento {
    
    /**
     * Retorna o nome do tipo de evento
     * @return <code>String </code> que representa o nome do evento
     */

    public String getTipo();
    
}
