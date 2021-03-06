package avaliacao.questao26.informacao;

import avaliacao.questao26.modelos.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public abstract class ProdutoInfo extends EntidadeInfo {

    public static final String NOME_SINGULAR = "Produto";
    public static final String NOME_PLURAL = "Produtos";

    public static final InfoCampo CAMPO_CODIGO = new InfoCampo("Código do " + NOME_SINGULAR, 20);
    public static final InfoCampo CAMPO_NOME = new InfoCampo("Nome " + NOME_SINGULAR, 50);
    public static final InfoCampo CAMPO_DESCRICAO = new InfoCampo("Descrição " + NOME_SINGULAR, 50);
    public static final InfoCampo CAMPO_VALOR = new InfoCampo("Valor " + NOME_SINGULAR, 10);
    public static final InfoCampo CAMPO_ESTOQUE = new InfoCampo("Estoque " +NOME_SINGULAR,50);

    public static List<InfoCampo> getCamposPesquisa() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_CODIGO);
        retorno.add(CAMPO_NOME);
        retorno.add(CAMPO_DESCRICAO);
        retorno.add(CAMPO_VALOR);
        retorno.add(CAMPO_ESTOQUE);
        return retorno;
    }

    public static List<InfoCampo> getCamposOrdenacao() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_DATA_CRIACAO);
        retorno.add(CAMPO_CODIGO);
        retorno.add(CAMPO_NOME);
        retorno.add(CAMPO_DESCRICAO);
        retorno.add(CAMPO_VALOR);
        retorno.add(CAMPO_ESTOQUE);
        return retorno;
    }

    public static String infoCabecalhoString() {
        String retorno = "";
        retorno += EntidadeInfo.infoCabecalhoString() + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CODIGO.getTamanhoImpressao() + "s", CAMPO_CODIGO.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", CAMPO_NOME.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_DESCRICAO.getTamanhoImpressao() + "s", CAMPO_DESCRICAO.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_VALOR.getTamanhoImpressao() + "s", CAMPO_VALOR.getNome());
        retorno += String.format("%-" + CAMPO_ESTOQUE.getTamanhoImpressao() +"s", CAMPO_ESTOQUE.getNome()) +SEPARADOR;
        return retorno;
    }

    public static String infoLinhaString(Produto obj) {
        String retorno = "";
        retorno += EntidadeInfo.infoLinhaString(obj) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CODIGO.getTamanhoImpressao() + "s", obj.getCodigo()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", obj.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_DESCRICAO.getTamanhoImpressao() + "s", obj.getDescricao()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_VALOR.getTamanhoImpressao() + ".2f", obj.getValor());
        retorno += String.format("%-" + CAMPO_ESTOQUE.getTamanhoImpressao() + "s",obj.getEstoque());
        
        return retorno;
    }

    public static Object getValueCampo(Produto produto, InfoCampo campo) {
        if (campo == ProdutoInfo.CAMPO_CODIGO) {
            return produto.getCodigo();
        }
        if (campo == ProdutoInfo.CAMPO_NOME) {
            return produto.getNome();
        }
        if (campo == ProdutoInfo.CAMPO_DESCRICAO) {
            return produto.getDescricao();
        }
        if (campo == ProdutoInfo.CAMPO_VALOR) {
            return produto.getValor();
        }
        if(campo == ProdutoInfo.CAMPO_ESTOQUE){
            return produto.getEstoque();
        }
        return EntidadeInfo.getValueCampo(produto, campo);
    }
}
