package exercicios.veiculo.validacao;

import exercicios.veiculo.model.Endereco;
import exercicios.veiculo.model.InfoCampo;

/**
 *
 * @author 78522
 */
public class ValidadorEndereco extends Validador<Endereco> {

    @Override
    public boolean isValido(Endereco obj) {
        super.isValido(obj);
        addErro(validarRua(obj));
        addErro(validarNumero(obj));
        addErro(validarComplemento(obj));
        addErro(validarBairro(obj));
        addErro(validarCidade(obj));
        addErro(validarEstado(obj));
        addErro(validarCep(obj));
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Endereco.CAMPO_RUA) {
            return validarRua(conteudo);
        }
        if (campo == Endereco.CAMPO_NUMERO) {
            return validarNumero(conteudo);
        }
        if (campo == Endereco.CAMPO_COMPLEMENTO) {
            return validarComplemento(conteudo);
        }
        if (campo == Endereco.CAMPO_BAIRRO) {
            return validarBairro(conteudo);
        }
        if (campo == Endereco.CAMPO_CIDADE) {
            return validarCidade(conteudo);
        }
        if (campo == Endereco.CAMPO_ESTADO) {
            return validarEstado(conteudo);
        }
        if (campo == Endereco.CAMPO_CEP) {
            return validarCep(conteudo);
        }
        throw new AssertionError();
    }

    private Erro validarRua(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarRua(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_RUA, conteudo);
    }

    private Erro validarNumero(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarNumero(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_NUMERO, conteudo);
    }

    private Erro validarComplemento(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarComplemento(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_COMPLEMENTO, conteudo);
    }

    private Erro validarBairro(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarBairro(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_BAIRRO, conteudo);
    }

    private Erro validarCidade(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarCidade(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_CIDADE, conteudo);
    }

    private Erro validarEstado(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarEstado(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_ESTADO, conteudo);
    }

    private Erro validarCep(Endereco obj) {
        return validarRua(obj.getRua());
    }

    public Erro validarCep(String conteudo) {
        return validarCampoVazio(Endereco.CAMPO_CEP, conteudo);
    }

}
