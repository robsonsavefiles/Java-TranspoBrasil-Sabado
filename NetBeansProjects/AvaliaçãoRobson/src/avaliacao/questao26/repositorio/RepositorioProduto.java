package avaliacao.questao26.repositorio;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.info.ProdutoInfo;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.Produto;
import avaliacao.questao26.validacao.ValidadorEntidade;
import avaliacao.questao26.validacao.ValidadorProduto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioProduto implements Repositorio {

    private final static String FILE_NAME = "produtos.txt";
    private final static InfoCampo ORDEM_PADRAO = ProdutoInfo.CAMPO_ID;

    private static List<Produto> objs;
    private static RepositorioProduto repositorio;

    private RepositorioProduto() {
        objs = (List<Produto>) lerObjetosDoArquivo();
    }

    public static RepositorioProduto getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioProduto();
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
    public List<Produto> getTodos() {
        return ordenar(objs, ORDEM_PADRAO);
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorProduto();
    }

    @Override
    public List<Produto> getTodosPorOrdem(InfoCampo campo) {
        return ordenar(getTodos(), campo);
    }

    @Override
    public List<Produto> getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato, InfoCampo campoOrdem) {
        List<Produto> retorno = new ArrayList();
        getTodos().stream().forEach((obj) -> {
            if (exato) {
                if (((String) ProdutoInfo.getValueCampo(obj, campoPesquisa)).equalsIgnoreCase(pesquisa)) {
                    retorno.add(obj);
                }
            } else {
                if (((String) ProdutoInfo.getValueCampo(obj, campoPesquisa)).toLowerCase().contains(pesquisa.toLowerCase())) {
                    retorno.add(obj);
                }
            }
        });
        return ordenar(retorno, campoOrdem);
    }

    @Override
    public List<Produto> ordenar(List lista, InfoCampo campo) {
        List<Produto> listaOrdenada = lista;
        if (campo == ProdutoInfo.CAMPO_ID) {
            Collections.sort(lista, (Produto v1, Produto v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == ProdutoInfo.CAMPO_CODIGO) {
            Collections.sort(lista, (Produto v1, Produto v2) -> v1.getCodigo().compareTo(v2.getCodigo()));
        }
        if (campo == ProdutoInfo.CAMPO_NOME) {
            Collections.sort(lista, (Produto v1, Produto v2) -> v1.getNome().compareTo(v2.getNome()));
        }
        if (campo == ProdutoInfo.CAMPO_DESCRICAO) {
            Collections.sort(lista, (Produto v1, Produto v2) -> v1.getDescricao().compareTo(v2.getDescricao()));
        }
        if (campo == ProdutoInfo.CAMPO_VALOR) {
            Collections.sort(lista, (Produto v1, Produto v2) -> Double.compare(v1.getValor(), v2.getValor()));
        }
        return listaOrdenada;
    }

    @Override
    public String infoString(List<Entidade> objs) {
        String retorno = ProdutoInfo.infoCabecalhoString().toUpperCase() + "\n";
        retorno = objs.stream().map((obj) -> ProdutoInfo.infoLinhaString((Produto) obj) + "\r\n").reduce(retorno, String::concat);
        return retorno;
    }

}
