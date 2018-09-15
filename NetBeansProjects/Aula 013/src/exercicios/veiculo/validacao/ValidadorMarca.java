package exercicios.veiculo.validacao;

import exercicios.veiculo.model.InfoCampo;
import exercicios.veiculo.model.Marca;

/**
 *
 * @author 78522
 */
public class ValidadorMarca extends ValidadorEntidade<Marca> {

    @Override
    public boolean isValido(Marca obj) {
        super.isValido(obj);
        addErro(validarNome(obj));
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Marca.CAMPO_NOME) {
            return validarNome(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    private Erro validarNome(Marca obj) {
        return validarNome(obj.getNome());
    }

    public Erro validarNome(String conteudo) {
        if (conteudo.isEmpty()) {
            return new Erro(Marca.CAMPO_NOME, "não pode ser vazio.");
        }
        return null;
    }

}
