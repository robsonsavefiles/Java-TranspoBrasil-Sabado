package avaliacao.questao26.info;

import avaliacao.questao26.model.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public abstract class PedidoInfo extends EntidadeInfo {

    public static final String NOME_SINGULAR = "Pedido";
    public static final String NOME_PLURAL = "Pedidos";

    public static final InfoCampo CAMPO_CODIGO = new InfoCampo("C�digo do " + NOME_SINGULAR, 10);
    public static final InfoCampo CAMPO_TOTAL = new InfoCampo("Valor Total do " + NOME_SINGULAR, 10);

    public static final InfoCampo CAMPO_CLIENTE_ID = new InfoCampo("ID do " + ClienteInfo.NOME_SINGULAR, 20);
    public static final InfoCampo CAMPO_PEDIDOS = new InfoCampo("Itens de Pedido", 50);

    public static List<InfoCampo> getCamposPesquisa() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_CODIGO);
        retorno.add(CAMPO_TOTAL);
        retorno.add(CAMPO_CLIENTE_ID);
        return retorno;
    }

    public static List<InfoCampo> getCamposOrdenacao() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_DATA_CRIACAO);
        retorno.add(CAMPO_DATA_ALTERACAO);
        retorno.add(CAMPO_CODIGO);
        retorno.add(CAMPO_TOTAL);
        retorno.add(CAMPO_CLIENTE_ID);
        return retorno;
    }

    public static String infoCabecalhoString() {
        String retorno = "";
        retorno += EntidadeInfo.infoCabecalhoString() + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CODIGO.getTamanhoImpressao() + "s", CAMPO_CODIGO.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_TOTAL.getTamanhoImpressao() + "s", CAMPO_TOTAL.getNome());
        return retorno;
    }

    public static String infoLinhaString(Pedido obj) {
        String retorno = "";
        retorno += EntidadeInfo.infoLinhaString(obj) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CODIGO.getTamanhoImpressao() + "s", obj.getCodigo()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_TOTAL.getTamanhoImpressao() + ".2f", obj.getTotal());
        return retorno;
    }

    public static Object getValueCampo(Pedido pedido, InfoCampo campo) {
        if (campo == PedidoInfo.CAMPO_CODIGO) {
            return pedido.getCodigo();
        }
        if (campo == PedidoInfo.CAMPO_TOTAL) {
            return pedido.getTotal();
        }
        return EntidadeInfo.getValueCampo(pedido, campo);
    }

}
