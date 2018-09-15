package avaliacao.questao26.validacoes;

import avaliacao.questao26.informacao.EntidadeInfo;
import avaliacao.questao26.informacao.InfoCampo;
import avaliacao.questao26.modelos.Entidade;
import avaliacao.questao26.repositorios.Repositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 89087
 */
public abstract class ValidadorEntidade extends Validador {

    public final static String DEFAULT_DESC_ERR_EXISTS = "n�o existe.";

    @Override
    public boolean isValido(Object obj) {
        Entidade objCast = (Entidade) obj;
        super.isValido(objCast);
        addErros(validarId(objCast));
        addErros(validarDataCriacao(objCast));
        addErros(validarDataAlteracao(objCast));
        return getErros().isEmpty();
    }

    @Override
    public List<Erro> validarCampo(InfoCampo campo, Object conteudo) {
        if (campo == EntidadeInfo.CAMPO_ID) {
            return validarId(conteudo);
        }
        if (campo == EntidadeInfo.CAMPO_DATA_CRIACAO) {
            return validarDataCriacao(conteudo);
        }
        if (campo == EntidadeInfo.CAMPO_DATA_ALTERACAO) {
            return validarDataAlteracao(conteudo);
        }
        throw new AssertionError();
    }

    @Override
    public boolean isCampoValido(InfoCampo campo, Object conteudo) {
        return validarCampo(campo, conteudo).isEmpty();
    }

    public List<Erro> validarId(Entidade obj) {
        return validarId(obj.getId());
    }

    public List<Erro> validarId(Object conteudo) {
        List<Erro> erros = new ArrayList();
        long id;
        try {
            id = (Long) conteudo;
        } catch (ClassCastException e) {
            try {
                id = Long.parseLong((String) conteudo);
            } catch (NumberFormatException e2) {
                addErroNaLista(new Erro(EntidadeInfo.CAMPO_ID, DEFAULT_DESC_ERR_TYPE_NUMBER), erros);
            }
        }
        return erros;
    }

    public List<Erro> validarDataCriacao(Entidade obj) {
        return validarDataCriacao(obj.getDataCriacao());
    }

    public List<Erro> validarDataCriacao(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            Date data = (Date) conteudo;
            addErroNaLista(validarVazio(EntidadeInfo.CAMPO_DATA_CRIACAO, data), erros);

            if (data.after(new Date())) {
                addErroNaLista(new Erro(EntidadeInfo.CAMPO_DATA_CRIACAO, "n�o pode ser futuro."), erros);
            }

        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(EntidadeInfo.CAMPO_DATA_CRIACAO, "deve ser uma data."), erros);
        }

        return erros;
    }

    public List<Erro> validarDataAlteracao(Entidade obj) {
        return validarDataCriacao(obj.getDataAlteracao());
    }

    public List<Erro> validarDataAlteracao(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            Date data = (Date) conteudo;
            addErroNaLista(validarVazio(EntidadeInfo.CAMPO_DATA_ALTERACAO, data), erros);

            if (data.after(new Date())) {
                addErroNaLista(new Erro(EntidadeInfo.CAMPO_DATA_ALTERACAO, "n�o pode ser futuro."), erros);
            }

        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(EntidadeInfo.CAMPO_DATA_ALTERACAO, "deve ser uma data."), erros);
        }

        return erros;
    }

    public Erro validarIdExistente(InfoCampo campo, long id, Repositorio repositorio) {
        if (repositorio.buscarPorId(id) == null) {
            return new Erro(campo, DEFAULT_DESC_ERR_EXISTS);
        }
        return null;
    }

}
