package avaliacao.questao26.repositorio;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.info.PedidoInfo;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.Pedido;
import avaliacao.questao26.validacao.ValidadorEntidade;
import avaliacao.questao26.validacao.ValidadorPedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioPedido implements Repositorio {

    private final static String FILE_NAME = "pedidos.txt";
    private final static InfoCampo ORDEM_PADRAO = PedidoInfo.CAMPO_ID;

    private static List<Pedido> objs;
    private static RepositorioPedido repositorio;

    private RepositorioPedido() {
        objs = (List<Pedido>) lerObjetosDoArquivo();
    }

    public static RepositorioPedido getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioPedido();
        }
        return repositorio;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public InfoCampo getOrdemPadrao() {
        return ORDEM_PADRAO;
    }

    @Override
    public List<Pedido> getTodos() {
        return ordenar(objs, ORDEM_PADRAO);
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorPedido();
    }

    @Override
    public List<Pedido> getTodosPorOrdem(InfoCampo campo) {
        return ordenar(getTodos(), campo);
    }

    @Override
    public List<Pedido> getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato, InfoCampo campoOrdem) {
        List<Pedido> retorno = new ArrayList();
        getTodos().stream().forEach((obj) -> {
            if (exato) {
                if (((String) PedidoInfo.getValueCampo(obj, campoPesquisa)).equalsIgnoreCase(pesquisa)) {
                    retorno.add(obj);
                }
            } else {
                if (((String) PedidoInfo.getValueCampo(obj, campoPesquisa)).toLowerCase().contains(pesquisa.toLowerCase())) {
                    retorno.add(obj);
                }
            }
        });
        return ordenar(retorno, campoOrdem);
    }

    @Override
    public List<Pedido> ordenar(List lista, InfoCampo campo) {
        List<Pedido> listaOrdenada = lista;
        if (campo == PedidoInfo.CAMPO_ID) {
            Collections.sort(lista, (Pedido v1, Pedido v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == PedidoInfo.CAMPO_CODIGO) {
            Collections.sort(lista, (Pedido v1, Pedido v2) -> v1.getCodigo().compareTo(v2.getCodigo()));
        }
        if (campo == PedidoInfo.CAMPO_TOTAL) {
            Collections.sort(lista, (Pedido v1, Pedido v2) -> Double.compare(v1.getTotal(), v2.getTotal()));
        }
        return listaOrdenada;
    }

    @Override
    public String infoString(List<Entidade> objs) {
        String retorno = PedidoInfo.infoCabecalhoString().toUpperCase() + "\n";
        retorno = objs.stream().map((obj) -> PedidoInfo.infoLinhaString((Pedido) obj) + "\r\n").reduce(retorno, String::concat);
        return retorno;
    }

}
