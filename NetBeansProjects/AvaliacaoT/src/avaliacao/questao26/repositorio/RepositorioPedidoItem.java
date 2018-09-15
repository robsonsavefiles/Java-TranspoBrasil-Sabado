package avaliacao.questao26.repositorio;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.info.PedidoItemInfo;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.PedidoItem;
import avaliacao.questao26.validacao.ValidadorEntidade;
import avaliacao.questao26.validacao.ValidadorPedidoItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioPedidoItem implements Repositorio {

    private final static String FILE_NAME = "pedidoitens.txt";
    private final static InfoCampo ORDEM_PADRAO = PedidoItemInfo.CAMPO_ID;

    private static List<PedidoItem> objs;
    private static RepositorioPedidoItem repositorio;

    private RepositorioPedidoItem() {
        objs = (List<PedidoItem>) lerObjetosDoArquivo();
    }

    public static RepositorioPedidoItem getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioPedidoItem();
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
    public List<PedidoItem> getTodos() {
        return ordenar(objs, ORDEM_PADRAO);
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorPedidoItem();
    }

    @Override
    public List<PedidoItem> getTodosPorOrdem(InfoCampo campo) {
        return ordenar(getTodos(), campo);
    }

    @Override
    public List<PedidoItem> getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato, InfoCampo campoOrdem) {
        List<PedidoItem> retorno = new ArrayList();
        getTodos().stream().forEach((obj) -> {
            if (exato) {
                if (((String) PedidoItemInfo.getValueCampo(obj, campoPesquisa)).equalsIgnoreCase(pesquisa)) {
                    retorno.add(obj);
                }
            } else {
                if (((String) PedidoItemInfo.getValueCampo(obj, campoPesquisa)).toLowerCase().contains(pesquisa.toLowerCase())) {
                    retorno.add(obj);
                }
            }
        });
        return ordenar(retorno, campoOrdem);
    }

    @Override
    public List<PedidoItem> ordenar(List lista, InfoCampo campo) {
        List<PedidoItem> listaOrdenada = lista;
        if (campo == PedidoItemInfo.CAMPO_ID) {
            Collections.sort(lista, (PedidoItem v1, PedidoItem v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == PedidoItemInfo.CAMPO_QUANTIDADE) {
            Collections.sort(lista, (PedidoItem v1, PedidoItem v2) -> Integer.compare(v1.getQuantidade(), v2.getQuantidade()));
        }
        if (campo == PedidoItemInfo.CAMPO_VALOR) {
            Collections.sort(lista, (PedidoItem v1, PedidoItem v2) -> Double.compare(v1.getValor(), v2.getValor()));
        }
        return listaOrdenada;
    }

    @Override
    public String infoString(List<Entidade> objs) {
        String retorno = PedidoItemInfo.infoCabecalhoString().toUpperCase() + "\n";
        retorno = objs.stream().map((obj) -> PedidoItemInfo.infoLinhaString((PedidoItem) obj) + "\r\n").reduce(retorno, String::concat);
        return retorno;
    }

}
