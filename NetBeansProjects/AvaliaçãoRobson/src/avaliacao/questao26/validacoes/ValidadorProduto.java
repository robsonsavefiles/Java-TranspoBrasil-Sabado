package avaliacao.questao26.validacoes;

import avaliacao.questao26.informacao.InfoCampo;
import avaliacao.questao26.informacao.ProdutoInfo;
import avaliacao.questao26.modelos.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class ValidadorProduto extends ValidadorEntidade {

    @Override
    public boolean isValido(Object obj) {
        Produto objCast = (Produto) obj;
        super.isValido(objCast);

        return getErros().isEmpty();
    }

    @Override
    public List<Erro> validarCampo(InfoCampo campo, Object conteudo) {
        if (campo == ProdutoInfo.CAMPO_CODIGO) {
            return validarCodigo(conteudo);
        }
        if (campo == ProdutoInfo.CAMPO_NOME) {
            return validarNome(conteudo);
        }
        if (campo == ProdutoInfo.CAMPO_DESCRICAO) {
            return validarDescricao(conteudo);
        }
        if (campo == ProdutoInfo.CAMPO_VALOR) {
            return validarValor(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    public List<Erro> validarCodigo(Produto obj) {
        return validarCodigo(obj.getCodigo());
    }

    public List<Erro> validarCodigo(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String codigo = (String) conteudo;
            addErroNaLista(validarVazio(ProdutoInfo.CAMPO_CODIGO, codigo), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ProdutoInfo.CAMPO_CODIGO, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarNome(Produto obj) {
        return validarCodigo(obj.getCodigo());
    }

    public List<Erro> validarNome(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String nome = (String) conteudo;
            addErroNaLista(validarVazio(ProdutoInfo.CAMPO_NOME, nome), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ProdutoInfo.CAMPO_NOME, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarDescricao(Produto obj) {
        return validarCodigo(obj.getCodigo());
    }

    public List<Erro> validarDescricao(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String desc = (String) conteudo;
            addErroNaLista(validarVazio(ProdutoInfo.CAMPO_NOME, desc), erros);
            addErroNaLista(validarTamanhoString(ProdutoInfo.CAMPO_NOME, desc, 0, 500), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ProdutoInfo.CAMPO_NOME, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarValor(Produto obj) {
        return validarCodigo(obj.getCodigo());
    }

    public List<Erro> validarValor(Object conteudo) {
        List<Erro> erros = new ArrayList();
        double valor;
        try {
            valor = (Double) conteudo;
        } catch (ClassCastException e) {
            try {
                valor = Double.parseDouble((String) conteudo);
            } catch (NumberFormatException e2) {
                addErroNaLista(new Erro(ProdutoInfo.CAMPO_VALOR, DEFAULT_DESC_ERR_TYPE_NUMBER), erros);
            }
        }
        return erros;
    }
}
