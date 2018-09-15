package avaliacao.questao26.validacoes;

import avaliacao.questao26.informacao.InfoCampo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author 89087
 */
public abstract class Validador {

    public final static String DEFAULT_DESC_ERR_NULL = "Não pode ser vazio.";
    public final static String DEFAULT_DESC_ERR_TYPE_STRING = "deve ser um string.";
    public final static String DEFAULT_DESC_ERR_TYPE_DATE = "deve ser uma data.";
    public final static String DEFAULT_DESC_ERR_TYPE_TEXT = "deve conter apenas letras.";
    public final static String DEFAULT_DESC_ERR_TYPE_NUMBER = "deve ser um n�mero.";
    public final static String DEFAULT_DESC_ERR_NUMBER_STRING = "deve conter apenas n�meros.";
    public final static String DEFAULT_DESC_ERR_VALUE_STRING = "deve conter apenas n�meros e/ou \".\".";

    private final List<Erro> erros = new ArrayList();

    public List<Erro> getErros() {
        return erros;
    }

    public boolean isValido(Object obj) {
        erros.clear();
        if (obj == null) {
            addErro(new Erro("O objeto fornecido " + DEFAULT_DESC_ERR_NULL));
            return false;
        }
        return true;
    }

    public abstract List<Erro> validarCampo(InfoCampo campo, Object conteudo);

    public abstract boolean isCampoValido(InfoCampo campo, Object conteudo);

    public void addErro(Erro erro) {
        addErroNaLista(erro, erros);
    }

    public void addErroNaLista(Erro erro, List<Erro> destino) {
        if (erro != null) {
            destino.add(erro);
        }
    }

    public void addErros(List<Erro> erros) {
        addErrosNaLista(erros, this.erros);
    }

    public void addErrosNaLista(List<Erro> origem, List<Erro> destino) {
        destino.addAll(origem);
    }

    public String getMensagemErros() {
        String retorno = "";
        retorno = erros.stream().map((erro) -> erro.getMensagem() + "\n").reduce(retorno, String::concat);
        return retorno;
    }

    public Erro validarVazio(InfoCampo campo, Object conteudo) {
        if (conteudo == null) {
            return new Erro(campo, DEFAULT_DESC_ERR_NULL);
        }

        if (conteudo instanceof String) {
            if (((String) conteudo).isEmpty()) {
                return new Erro(campo, DEFAULT_DESC_ERR_NULL);
            }
        }

        if (conteudo instanceof Collection) {
            if (((Collection) conteudo).isEmpty()) {
                return new Erro(campo, DEFAULT_DESC_ERR_NULL);
            }
        }
        return null;
    }

    public Erro validarMaiorQue(InfoCampo campo, Number number, double min) {
        if (number.doubleValue() <= min) {
            return new Erro(campo, "deve ser maior do que " + min);
        }
        return null;
    }

    public Erro validarTamanhoString(InfoCampo campo, String conteudo, int tamanho) {
        if (conteudo.length() != tamanho) {
            return new Erro(campo, "deve ter " + tamanho + " caracteres.");
        }
        return null;
    }

    public Erro validarTamanhoString(InfoCampo campo, String conteudo, int tamanhoMin, int tamanhoMax) {
        if (conteudo.length() < tamanhoMin) {
            return new Erro(campo, "deve ter no m�nimo " + tamanhoMin + " caracteres.");
        }
        if (conteudo.length() > tamanhoMax) {
            return new Erro(campo, "deve ter no m�ximo " + tamanhoMax + " caracteres.");
        }
        return null;
    }

    public Erro validarStringDeInteger(InfoCampo campo, String conteudo) {
        if (!conteudo.matches("^[0-9]*$")) {
            return new Erro(campo, DEFAULT_DESC_ERR_NUMBER_STRING);
        }
        return null;
    }

    public Erro validarStringDeDouble(InfoCampo campo, String conteudo) {
        if (!conteudo.matches("^[0-9]\\d*(\\.\\d+)?$")) {
            return new Erro(campo, DEFAULT_DESC_ERR_VALUE_STRING);
        }
        return null;
    }
}
