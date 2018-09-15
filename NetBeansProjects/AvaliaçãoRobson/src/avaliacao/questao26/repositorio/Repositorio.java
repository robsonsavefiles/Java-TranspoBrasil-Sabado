package avaliacao.questao26.repositorio;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.io.IO;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.PedidoItem;
import avaliacao.questao26.validacao.ValidadorEntidade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 78522
 */
public interface Repositorio {

    ValidadorEntidade getValidador();

    String getFileName();

    InfoCampo getOrdemPadrao();

    List getTodos();

    List getTodosPorOrdem(InfoCampo campo);

    default List getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato) {
        return getPesquisaPorOrdem(campoPesquisa, pesquisa, exato, getOrdemPadrao());
    }

    List getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato, InfoCampo campoOrdem);

    List ordenar(List lista, InfoCampo campo);

    default void salvarRepositorio(List objs) {
        IO.gravarObjetosNoArquivo(getFileName(), objs);
    }

    default Entidade salvar(Entidade obj) {
        if (obj == null) {
            return null;
        }

        if (obj.getId() == null) {
            obj.setId(System.nanoTime());
        }

        List<Entidade> objs = getTodos();
        int index = objs.indexOf(obj);

        boolean novo = !(index > -1);

        if (novo) {
            obj.setDataAlteracao(new Date());
            obj.setDataCriacao(new Date());
        } else {
            obj.setDataAlteracao(new Date());
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

    default void remover(Entidade obj) {
        List<Entidade> objs = getTodos();
        objs.remove(obj);
        salvarRepositorio(objs);
    }

    default List lerObjetosDoArquivo() {
        return IO.lerObjetosNoArquivo(getFileName());
    }

    default Entidade buscarPorId(long id) {
        List<Entidade> objs = getTodos();
        for (Entidade obj : objs) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    default String infoString() {
        return infoString(getTodos());
    }

    String infoString(List<Entidade> objs);

    default boolean isVazio() {
        return getTodos().isEmpty();
    }
}
