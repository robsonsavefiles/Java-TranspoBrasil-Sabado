package avaliacao.questao26.validacoes;

import avaliacao.questao26.informacao.ClienteInfo;
import avaliacao.questao26.informacao.InfoCampo;
import avaliacao.questao26.modelos.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public class ValidadorCliente extends ValidadorEntidade {

    @Override
    public boolean isValido(Object obj) {
        Cliente objCast = (Cliente) obj;
        super.isValido(objCast);

        return getErros().isEmpty();
    }

    @Override
    public List<Erro> validarCampo(InfoCampo campo, Object conteudo) {
        if (campo == ClienteInfo.CAMPO_NOME) {
            return validarNome(conteudo);
        }
        if (campo == ClienteInfo.CAMPO_CPF) {
            return validarCpf(conteudo);
        }
        if (campo == ClienteInfo.CAMPO_TELEFONE) {
            return validarTelefone(conteudo);
        }
        if (campo == ClienteInfo.CAMPO_CELULAR) {
            return validarCelular(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    public List<Erro> validarNome(Cliente obj) {
        return validarNome(obj.getNome());
    }

    public List<Erro> validarNome(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String nome = (String) conteudo;
            addErroNaLista(validarVazio(ClienteInfo.CAMPO_NOME, nome), erros);
            addErroNaLista(validarTamanhoString(ClienteInfo.CAMPO_NOME, nome, 0, 200), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ClienteInfo.CAMPO_NOME, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarCpf(Cliente obj) {
        return validarNome(obj.getCpf());
    }

    public List<Erro> validarCpf(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String cpf = (String) conteudo;
            addErroNaLista(validarVazio(ClienteInfo.CAMPO_CPF, cpf), erros);
            addErroNaLista(validarStringDeInteger(ClienteInfo.CAMPO_CPF, cpf), erros);
            addErroNaLista(validarTamanhoString(ClienteInfo.CAMPO_CPF, cpf, 11), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ClienteInfo.CAMPO_CPF, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarTelefone(Cliente obj) {
        return validarNome(obj.getTelefone());
    }

    public List<Erro> validarTelefone(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String telefone = (String) conteudo;
            addErroNaLista(validarStringDeInteger(ClienteInfo.CAMPO_TELEFONE, telefone), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ClienteInfo.CAMPO_TELEFONE, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

    public List<Erro> validarCelular(Cliente obj) {
        return validarNome(obj.getCelular());
    }

    public List<Erro> validarCelular(Object conteudo) {
        List<Erro> erros = new ArrayList();
        try {
            String telefone = (String) conteudo;
            addErroNaLista(validarStringDeInteger(ClienteInfo.CAMPO_CELULAR, telefone), erros);
        } catch (ClassCastException ex) {
            addErroNaLista(new Erro(ClienteInfo.CAMPO_CELULAR, DEFAULT_DESC_ERR_TYPE_STRING), erros);
        }
        return erros;
    }

}
