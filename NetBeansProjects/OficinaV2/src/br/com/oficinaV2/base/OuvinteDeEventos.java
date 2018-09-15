package br.com.oficinaV2.base;

/**
 *Representaçao de um ouvinte dde eventos do sistema.
 * @author 89087
 * @param <T>
 */
public interface OuvinteDeEventos<T> {
    /**
     * metodo chamado quando um evento e disparado
     * @param item 
     */

    public void onEventoDisparado(T item);
    /**
     * tipo de evento que este ouvinte é capaz de tratar
     * @return 
     */
    public String getTipo();

}
