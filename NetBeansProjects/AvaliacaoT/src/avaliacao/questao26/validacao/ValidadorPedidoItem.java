package avaliacao.questao26.validacao;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.info.PedidoItemInfo;
import avaliacao.questao26.model.PedidoItem;
import avaliacao.questao26.repositorio.RepositorioProduto;
import static avaliacao.questao26.validacao.Validador.DEFAULT_DESC_ERR_TYPE_NUMBER;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ValidadorPedidoItem extends ValidadorEntidade {

    @Override
    public boolean isValido(Object obj) {
        PedidoItem objCast = (PedidoItem) obj;
        super.isValido(objCast);
        addErros(validarQuantidade(objCast));
        addErros(validarIdProduto(objCast));
        return getErros().isEmpty();
    }

    @Override
    public List<Erro> validarCampo(InfoCampo campo, Object conteudo) {
        if (campo == PedidoItemInfo.CAMPO_QUANTIDADE) {
            return validarQuantidade(conteudo);
        }
        if (campo == PedidoItemInfo.CAMPO_PRODUTO_ID) {
            return validarIdProduto(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    public List<Erro> validarQuantidade(PedidoItem obj) {
        return validarQuantidade(obj.getQuantidade());
    }

    public List<Erro> validarQuantidade(Object conteudo) {
        List<Erro> erros = new ArrayList();
        int qtd;
        try {
            qtd = (Integer) conteudo;
            addErroNaLista(validarVazio(PedidoItemInfo.CAMPO_QUANTIDADE, qtd), erros);
            addErroNaLista(validarMaiorQue(PedidoItemInfo.CAMPO_QUANTIDADE, qtd, 0), erros);
        } catch (ClassCastException ex) {
            try {
                qtd = Integer.parseInt((String) conteudo);
            } catch (Exception e2) {
                addErroNaLista(new Erro(PedidoItemInfo.CAMPO_PRODUTO_ID, DEFAULT_DESC_ERR_TYPE_NUMBER), erros);
                return erros;
            }
        }
        return erros;
    }

    public List<Erro> validarIdProduto(PedidoItem obj) {
        return validarIdProduto(obj.getProduto().getId());
    }

    public List<Erro> validarIdProduto(Object conteudo) {
        List<Erro> erros = new ArrayList();
        long id;
        try {
            id = (Long) conteudo;
        } catch (ClassCastException e) {
            try {
                id = Long.parseLong((String) conteudo);
            } catch (Exception e2) {
                addErroNaLista(new Erro(PedidoItemInfo.CAMPO_PRODUTO_ID, DEFAULT_DESC_ERR_TYPE_NUMBER), erros);
                return erros;
            }
        }
        addErroNaLista(validarIdExistente(PedidoItemInfo.CAMPO_PRODUTO_ID, id, RepositorioProduto.getInstance()), erros);
        return erros;
    }

}
