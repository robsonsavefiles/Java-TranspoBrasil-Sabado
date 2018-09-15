package br.cursojava.projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.cursojava.model.Chamado;
import br.cursojava.model.Providencia;

/**
 *
 * @author 89087
 */
public class ChamadoRepositorio implements EntidadeRepositorio<Chamado> {

    private static final List<Chamado> LISTA = new ArrayList();

    static {
        List<Providencia> prov1 = new ArrayList();
        prov1.add(new Providencia(1L, "Fazer implementaçao do sistema para maior produtividade", Providencia.Estagio.DESENVOLVIMENTO, UsuarioRepositorio.getInstance().buscarTodos().get(0)));
        prov1.add(new Providencia(2L, "Fazer Implementação do tasy em novas unidades do Hospital Santa Catarina", Providencia.Estagio.ENTREGUE, UsuarioRepositorio.getInstance().buscarTodos().get(1)));
        prov1.add(new Providencia(3L, "Fazer Reparo nas maquinas do laboratorio da Proway todos final de semana", Providencia.Estagio.ENTREGUE, UsuarioRepositorio.getInstance().buscarTodos().get(1)));
        LISTA.add(new Chamado(1L, "Troca de Sistema Tasy", ProjetoRepositorio.getInstance().buscarTodos().get(0), "Descrição ", Chamado.Status.FECHADO, prov1));
        LISTA.add(new Chamado(2L, "Atualização do Sistema", ProjetoRepositorio.getInstance().buscarTodos().get(0), "Descrição ", Chamado.Status.ABERTO, new ArrayList()));
        LISTA.add(new Chamado(3L, "Atualização do Banco de Dados", ProjetoRepositorio.getInstance().buscarTodos().get(1), "Descrição ", Chamado.Status.ABERTO, new ArrayList()));
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
