package exercicios.veiculo.repositorio;

import exercicios.veiculo.IO.IO;
import exercicios.veiculo.model.Entidade;
import exercicios.veiculo.model.InfoCampo;
import exercicios.veiculo.validacao.ValidadorEntidade;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author 78522
 * @param <T>
 */
public interface Repositorio<T extends Entidade> {

    default T salvar(T obj) {
        if (obj == null) {
            return null;
        }

        if (obj.getId() == null) {
            obj.setId(System.nanoTime());
        }

        List<T> objs = getTodos();
        int index = objs.indexOf(obj);

        boolean novo = !(index > -1);

        if (novo) {
            obj.setDataAlteracao(LocalDateTime.now());
            obj.setDataCriacao(LocalDateTime.now());
        } else {
            obj.setDataAlteracao(LocalDateTime.now());
        }

        ValidadorEntidade validador = getValidador();
        if (!validador.isValido(obj)) {
            throw new RuntimeException(validador.getMensagemErros());
        }

        if (novo) {
            objs.add(obj);
        } else {
            objs.set(index, obj);
        }

        salvarRepositorio(objs);
        return obj;
    }

    ValidadorEntidade<T> getValidador();

    String getFileName();

    List<T> getTodos();

    List<T> getTodos(InfoCampo campo);

    default void salvarRepositorio(List<T> objs) {
        IO.gravarObjetosNoArquivo(getFileName(), objs);
    }

    default void remover(T obj) {
        List<T> objs = getTodos();
        objs.remove(obj);
        salvarRepositorio(objs);
    }

    default List<T> lerObjetosDoArquivo() {
        return IO.lerObjetosNoArquivo(getFileName());
    }

    default T buscarPorId(long id) {
        List<T> objs = getTodos();
        for (T obj : objs) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    default String infoString() {
        return infoString(getTodos());
    }

    default String infoString(List<T> objs) {
        String retorno = "";
        for (int i = 0; i < objs.size(); i++) {
            retorno += objs.get(i).infoLinhaString();
            if (i < objs.size() - 1) {
                retorno += "\r\n";
            }
        }

        return retorno;
    }

    default boolean isVazio() {
        return getTodos().isEmpty();
    }
}
