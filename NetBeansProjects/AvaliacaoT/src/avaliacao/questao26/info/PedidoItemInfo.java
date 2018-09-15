package avaliacao.questao26.info;

import avaliacao.questao26.model.PedidoItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public abstract class PedidoItemInfo extends EntidadeInfo {

    public static final String NOME_SINGULAR = "Item de Pedido";
    public static final String NOME_PLURAL = "Itens de Pedido";

    public static final InfoCampo CAMPO_QUANTIDADE = new InfoCampo("Quantidade do " + NOME_SINGULAR, 10);
    public static final InfoCampo CAMPO_VALOR = new InfoCampo("Valor Total do " + NOME_SINGULAR, 10);
    public static final InfoCampo CAMPO_PRODUTO_ID = new InfoCampo("ID do " + ProdutoInfo.NOME_SINGULAR, 20);

    public static List<InfoCampo> getCamposPesquisa() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_PRODUTO_ID);
        return retorno;
    }

    public static List<InfoCampo> getCamposOrdenacao() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_DATA_CRIACAO);
        retorno.add(CAMPO_DATA_ALTERACAO);
        retorno.add(CAMPO_PRODUTO_ID);
        retorno.add(CAMPO_VALOR);
        return retorno;
    }

    public static String infoCabecalhoString() {
        String retorno = "";
        retorno += EntidadeInfo.infoCabecalhoString() + SEPARADOR;
        retorno += String.format("%-" + CAMPO_QUANTIDADE.getTamanhoImpressao() + "s", CAMPO_QUANTIDADE.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_VALOR.getTamanhoImpressao() + "s", CAMPO_VALOR.getNome());
        return retorno;
    }

    public static String infoLinhaString(PedidoItem obj) {
        String retorno = "";
        retorno += EntidadeInfo.infoLinhaString(obj) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_QUANTIDADE.getTamanhoImpressao() + "d", obj.getQuantidade()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_VALOR.getTamanhoImpressao() + ".2f", obj.getValor());
        return retorno;
    }

    public static Object getValueCampo(PedidoItem pedidoItem, InfoCampo campo) {
        if (campo == PedidoItemInfo.CAMPO_QUANTIDADE) {
            return pedidoItem.getQuantidade();
        }
        if (campo == PedidoItemInfo.CAMPO_VALOR) {
            return pedidoItem.getValor();
        }
        return EntidadeInfo.getValueCampo(pedidoItem, campo);
    }

}
