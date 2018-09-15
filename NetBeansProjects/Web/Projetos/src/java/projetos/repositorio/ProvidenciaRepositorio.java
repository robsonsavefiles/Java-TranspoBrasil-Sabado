package projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import projetos.dto.ChamadoProvidencia;
import projetos.model.Chamado;
import projetos.model.Providencia;

/**
 *
 * @author 78522
 */
public class ProvidenciaRepositorio implements Repositorio<ChamadoProvidencia> {

    private static ProvidenciaRepositorio instance;
    private final ChamadoRepositorio chamadoRep = ChamadoRepositorio.getInstance();

    private ProvidenciaRepositorio() {

    }

    public static ProvidenciaRepositorio getInstance() {
        if (instance == null) {
            instance = new ProvidenciaRepositorio();
        }
        return instance;
    }

    public ChamadoProvidencia buscarPorId(long chamadoId, long id) {
        Chamado chamado = chamadoRep.buscarPorId(chamadoId);
        for (Providencia providencia : chamado.getProvidencias()) {
            if (providencia.getId() == id) {
                return new ChamadoProvidencia(chamado.getId(), providencia);
            }
        }
        return null;
    }

    @Override
    public List<ChamadoProvidencia> buscarTodos() {
        List<ChamadoProvidencia> retorno = new ArrayList();
        chamadoRep.buscarTodos().stream().forEach((chamado) -> {
            chamado.getProvidencias().stream().forEach((providencia)
                    -> retorno.add(new ChamadoProvidencia(chamado.getId(), providencia))
            );
        });
        return retorno;
    }

    @Override
    public ChamadoProvidencia salvar(ChamadoProvidencia obj) {
        Chamado chamado = chamadoRep.buscarPorId(obj.getChamadoId());
        if (obj.getProvidencia().getId() == null) {
            obj.getProvidencia().setId(System.currentTimeMillis());
        }
        int index = chamado.getProvidencias().indexOf(obj.getProvidencia());
        if (index > -1) {
            chamado.getProvidencias().set(index, obj.getProvidencia());
        } else {
            chamado.getProvidencias().add(obj.getProvidencia());
        }
        return obj;
    }

    @Override
    public boolean remover(ChamadoProvidencia obj) {
        Chamado chamado = chamadoRep.buscarPorId(obj.getChamadoId());
        return chamado.getProvidencias().remove(obj.getProvidencia());
    }

}
