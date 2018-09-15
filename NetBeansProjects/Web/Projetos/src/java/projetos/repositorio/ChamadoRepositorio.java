package projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import projetos.model.Chamado;
import projetos.model.Providencia;

/**
 *
 * @author 78522
 */
public class ChamadoRepositorio implements EntidadeRepositorio<Chamado> {

    private static final List<Chamado> LISTA = new ArrayList();

    static {
        List<Providencia> prov1 = new ArrayList();
        prov1.add(new Providencia(1L, "Descrição Providência 01", Providencia.Estagio.TESTE, UsuarioRepositorio.getInstance().buscarTodos().get(0)));
        prov1.add(new Providencia(2L, "Descrição Providência 02", Providencia.Estagio.TESTE, UsuarioRepositorio.getInstance().buscarTodos().get(1)));
        LISTA.add(new Chamado(1L, "Chamado 01", ProjetoRepositorio.getInstance().buscarTodos().get(0), "Descrição Chamado 01", Chamado.Status.FECHADO, prov1));
        LISTA.add(new Chamado(2L, "Chamado 02", ProjetoRepositorio.getInstance().buscarTodos().get(0), "Descrição Chamado 02", Chamado.Status.ABERTO, new ArrayList()));
        LISTA.add(new Chamado(3L, "Chamado 03", ProjetoRepositorio.getInstance().buscarTodos().get(1), "Descrição Chamado 03", Chamado.Status.ABERTO, new ArrayList()));
    }

    private static ChamadoRepositorio instance;

    private ChamadoRepositorio() {

    }

    public static ChamadoRepositorio getInstance() {
        if (instance == null) {
            instance = new ChamadoRepositorio();
        }
        return instance;
    }

    @Override
    public Chamado buscarPorId(long id) {
        for (Chamado obj : LISTA) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Chamado> buscarTodos() {
        List<Chamado> retorno = new ArrayList();
        retorno.addAll(LISTA);
        return retorno;
    }

    @Override
    public Chamado salvar(Chamado obj) {
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
    public boolean remover(Chamado obj) {
        return LISTA.remove(obj);
    }

    public List<Chamado> buscarPorProjeto(long id) {
        List<Chamado> retorno = new ArrayList();
        LISTA.stream().filter((obj) -> (obj.getProjeto().getId() == id)).forEach((obj) -> retorno.add(obj));
        return retorno;
    }

}
