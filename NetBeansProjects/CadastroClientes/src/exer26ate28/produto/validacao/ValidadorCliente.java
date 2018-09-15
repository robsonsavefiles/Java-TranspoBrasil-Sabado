package exer26ate28.produto.validacao;

import exer26ate28.produto.model.Cliente;
import exer26ate28.produto.model.InfoCampo;

/**
 *
 * @author 89087
 */
public class ValidadorCliente extends ValidadorEntidade<Cliente> {

    @Override
    public boolean isValido(Cliente obj) {
        super.isValido(obj);
        addErro(validarNome(obj));
        addErro(validarNomePai(obj));
        addErro(validarNomeMae(obj));
        addErro(validarCpf(obj));
        addErro(validarTelefone(obj));
        addErro(validarDataNascimento(obj));
        ValidadorEndereco valEnd = new ValidadorEndereco();
        if (!valEnd.isValido(obj.getEndereco())) {
            addErros(valEnd.getErros());
        }
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Cliente.CAMPO_NOME) {
            return validarNome(conteudo);
        }
        if (campo == Cliente.CAMPO_NOME_PAI) {
            return validarNomePai(conteudo);
        }
        if (campo == Cliente.CAMPO_NOME_MAE) {
            return validarNomeMae(conteudo);
        }
        if (campo == Cliente.CAMPO_CPF) {
            return validarCpf(conteudo);
        }
        if (campo == Cliente.CAMPO_TELEFONE) {
            return validarTelefone(conteudo);
        }
        if (campo == Cliente.CAMPO_ENDERECO) {
            return validarEndereco(conteudo);
        }
        if (campo == Cliente.CAMPO_DATA_NASCIMENTO) {
            return validarDataNascimento(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    private Erro validarNome(Cliente obj) {
        return validarNome(obj.getNome());
    }

    public Erro validarNome(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_NOME, conteudo);
    }

    private Erro validarDataNascimento(Cliente obj) {
        return validarDataNascimento(obj.getNome());
    }

    public Erro validarDataNascimento(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_DATA_NASCIMENTO, conteudo);
    }

    private Erro validarNomePai(Cliente obj) {
        return validarNome(obj.getNome());
    }

    public Erro validarNomePai(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_NOME_PAI, conteudo);
    }

    private Erro validarNomeMae(Cliente obj) {
        return validarNome(obj.getNome());
    }

    public Erro validarNomeMae(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_NOME_MAE, conteudo);
    }

    private Erro validarCpf(Cliente obj) {
        return validarCpf(obj.getCpf());
    }

    public Erro validarCpf(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_CPF, conteudo);
    }

    private Erro validarTelefone(Cliente obj) {
        return validarTelefone(obj.getTelefone());
    }

    public Erro validarTelefone(String conteudo) {
        return validarCampoVazio(Cliente.CAMPO_TELEFONE, conteudo);
    }

    private Erro validarEndereco(String conteudo) {
        return null;
    }

}
