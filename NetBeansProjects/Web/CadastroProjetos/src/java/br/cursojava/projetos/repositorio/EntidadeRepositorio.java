package br.cursojava.projetos.repositorio;

import br.cursojava.model.Entidade;

/**
 *
 * @author 89087
 * @param <T>
 */
public interface EntidadeRepositorio<T extends Entidade> extends Repositorio<T> {

    T buscarPorId(long id);

}
