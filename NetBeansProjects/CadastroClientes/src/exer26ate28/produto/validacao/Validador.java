package exer26ate28.produto.validacao;

import exer26ate28.produto.model.InfoCampo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 * @param <T>
 */
public abstract class Validador<T> {

    private final List<Erro> erros = new ArrayList();

    public List<Erro> getErros() {
        return erros;
    }

    public boolean isValido(T obj) {
        erros.clear();
        if (obj == null) {
            addErro(new Erro("O objeto fornecido n�o pode ser nulo."));
            return false;
        }
        return true;
    }

    public abstract Erro validarCampo(InfoCampo campo, String conteudo);

    public void addErro(Erro erro) {
        if (erro != null) {
            erros.add(erro);
        }
    }

    public void addErros(List<Erro> erros) {
        if (erros != null) {
            erros.addAll(erros);
        }
    }

    public String getMensagemErros() {
        String retorno = "";
        retorno = erros.stream().map((erro) -> erro.getMensagem() + "\n").reduce(retorno, String::concat);
        return retorno;
    }

    public Erro validarCampoVazio(InfoCampo campo, Object conteudo) {
        if (conteudo == null) {
            return new Erro(campo, "n�o pode ser vazio.");
        }
        return null;
    }

    public Erro validarCampoVazio(InfoCampo campo, String conteudo) {
        if (conteudo == null) {
            return new Erro(campo, "n�o pode ser vazio.");
        }

        if (conteudo.isEmpty()) {
            return new Erro(campo, "n�o pode ser vazio.");
        }
        return null;
    }
}
