package avaliacao.questao26.validacao;

import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.info.PedidoInfo;
import avaliacao.questao26.model.Pedido;
import avaliacao.questao26.model.PedidoItem;
import avaliacao.questao26.repositorio.RepositorioCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class ValidadorPedido extends ValidadorEntidade {

    @Override
    public boolean isValido(Object obj) {
        Pedido objCast = (Pedido) obj;
        super.isValido(objCast);
        addErros(validarCodigo(objCast));
        addErros(validarIdCliente(objCast));
        addErros(validarPedidosItem(objCast));
        return getErros().isEmpty();
    }

    @Override
    public List<Erro> validarCampo(InfoCampo campo, Object conteudo) {
        if (campo == PedidoInfo.CAMPO_CODIGO) {
            return validarCodigo(conteudo);
        }
        if (campo == PedidoInfo.CAMPO_CLIENTE_ID) {
            return ValidadorPedido.this.validarIdCliente(conteudo);
        }
        if (campo == PedidoInfo.CAMPO_PEDIDOS) {
            return validarPedidosItem(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    public List<Erro> validarCodigo(Pedido obj) {
        return validarCodigo(obj.getCodigo());
    }

    public List<Erro> validarCodigo(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String codigo = (String) conteudo;
            addErroNaLista(validarVazio(PedidoInfo.CAMPO_CODIGO, codigo), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(PedidoInfo.CAMPO_CODIGO, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarIdCliente(Pedido obj) {
        return validarIdCliente(obj.getCliente().getId());
    }

    public List<Erro> validarIdCliente(Object conteudo) {
        List<Erro> erros = new ArrayList();
        long id;
        try {
            id = (Long) conteudo;
        } catch (ClassCastException e) {
            try {
                id = Long.parseLong((String) conteudo);
            } catch (NumberFormatException e2) {
                addErroNaLista(new Erro(PedidoInfo.CAMPO_CLIENTE_ID, DEFAULT_DESC_ERR_TYPE_NUMBER), erros);
                return erros;
            }
        }
        addErroNaLista(validarIdExistente(PedidoInfo.CAMPO_CLIENTE_ID, id, RepositorioCliente.getInstance()), erros);
        return erros;
    }

    public List<Erro> validarPedidosItem(Pedido obj) {
        return validarPedidosItem(obj.getItens());
    }

    public List<Erro> validarPedidosItem(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            List<PedidoItem> itens = (List<PedidoItem>) conteudo;
            addErroNaLista(validarVazio(PedidoInfo.CAMPO_CODIGO, itens), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(PedidoInfo.CAMPO_CODIGO, "deve ser uma lista de itens de pedido."), erros);
        }
        return erros;
    }
}
