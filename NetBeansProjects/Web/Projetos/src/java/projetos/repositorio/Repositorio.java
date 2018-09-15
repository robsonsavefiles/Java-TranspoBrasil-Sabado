package projetos.repositorio;

import java.util.List;

/**
 *
 * @author 78522
 * @param <T>
 */
public interface Repositorio<T> {

    List<T> buscarTodos();

    T salvar(T obj);

    boolean remover(T obj);
    
}
