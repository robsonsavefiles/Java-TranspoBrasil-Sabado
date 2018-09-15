package projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import projetos.model.Projeto;

/**
 *
 * @author 78522
 */
public class ProjetoRepositorio implements EntidadeRepositorio<Projeto> {

    private static final List<Projeto> LISTA = new ArrayList();

    static {
        LISTA.add(new Projeto(1L, "Projeto 01", "Descrição Projeto 01"));
        LISTA.add(new Projeto(2L, "Projeto 02", "Descrição Projeto 02"));
        LISTA.add(new Projeto(3L, "Projeto 03", "Descrição Projeto 03"));
    }

    private static ProjetoRepositorio instance;

    private ProjetoRepositorio() {

    }

    public static ProjetoRepositorio getInstance() {
        if (instance == null) {
            instance = new ProjetoRepositorio();
        }
        return instance;
    }

    @Override
    public Projeto buscarPorId(long id) {
        for (Projeto obj : LISTA) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Projeto> buscarTodos() {
        List<Projeto> retorno = new ArrayList();
        retorno.addAll(LISTA);
        return retorno;
    }

    @Override
    public Projeto salvar(Projeto obj) {
        if (obj.getId() == null) {
            obj.setId(System.currentTimeMillis());
        }
        int index = LISTA.indexOf(obj);
        if (index > -1) {
            LISTA.set(index, obj);
        } else {
            LISTA.add(obj);
        }
        return obj;
    }

    @Override
    public boolean remover(Projeto obj) {
        return LISTA.remove(obj);
    }

}
