package exercicios.cliente;

/**
 *
 * @author 78522
 * @param <T>
 */
public interface OuvinteDeEventos<T> {

    public void onEventoDisparado(T item);

    public String getTipo();

}
