package exer26ate28.produto.validacao;

import exer26ate28.produto.model.Entidade;
import exer26ate28.produto.model.InfoCampo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 * @param <T>
 */
public abstract class ValidadorEntidade<T extends Entidade> extends Validador<T> {

    @Override
    public boolean isValido(T obj) {
        super.isValido(obj);
        addErro(validarId(obj));
        addErro(validarDataCriacao(obj));
        addErro(validarDataAlteracao(obj));
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Entidade.CAMPO_ID) {
            return validarId(conteudo);
        }
        throw new AssertionError();
    }

    public Erro validarId(T obj) {
        return validarId(String.valueOf(obj.getId()));
    }

    public Erro validarId(String conteudo) {
        try {
            Long.parseLong(conteudo);
        } catch (NumberFormatException ex) {
            return new Erro(Entidade.CAMPO_ID, "deve ser um n�mero.");
        }
        return null;
    }

    public Erro validarDataCriacao(T obj) {
        if (obj.getDataCriacao() == null) {
            return new Erro(Entidade.CAMPO_DATA_CRIACAO, "n�o pode ser nulo.");
        }

        if (obj.getDataCriacao().isAfter(LocalDateTime.now())) {
            return new Erro(Entidade.CAMPO_DATA_CRIACAO, "n�o pode ser futuro.");
        }

        if (obj.getDataCriacao().isAfter(obj.getDataAlteracao())) {
            return new Erro(Entidade.CAMPO_DATA_CRIACAO, "(" + obj.getDataCriacao() + ") n�o pode ser maior do que o campo "
                    + Entidade.CAMPO_DATA_ALTERACAO.getNome() + "(" + obj.getDataAlteracao() + ").");
        }

        return null;
    }

    public Erro validarDataAlteracao(T obj) {
        if (obj.getDataCriacao() == null) {
            return new Erro(Entidade.CAMPO_DATA_ALTERACAO, "n�o pode ser nulo.");
        }

        if (obj.getDataCriacao().isAfter(LocalDateTime.now())) {
            return new Erro(Entidade.CAMPO_DATA_ALTERACAO, "n�o pode ser futuro.");
        }

        if (obj.getDataAlteracao().isBefore(obj.getDataCriacao())) {
            return new Erro(Entidade.CAMPO_DATA_ALTERACAO, "n�o pode ser menor do que o campo " + Entidade.CAMPO_DATA_CRIACAO.getNome() + ".");
        }

        return null;
    }

}
