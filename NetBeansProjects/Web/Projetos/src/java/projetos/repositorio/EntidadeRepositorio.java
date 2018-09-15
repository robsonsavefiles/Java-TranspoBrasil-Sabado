package projetos.repositorio;

import projetos.model.Entidade;

/**
 *
 * @author 78522
 * @param <T>
 */
public interface EntidadeRepositorio<T extends Entidade> extends Repositorio<T> {

    T buscarPorId(long id);

}
