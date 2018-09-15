package exer26ate28.produto.validacao;

import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.model.Modelo;
import exer26ate28.produto.repositorio.RepositorioMarca;
import java.time.LocalDate;

/**
 *
 * @author 78522
 */
public class ValidadorModelo extends ValidadorEntidade<Modelo> {

    @Override
    public boolean isValido(Modelo obj) {
        super.isValido(obj);
        addErro(validarNome(obj));
        addErro(validarAno(obj));
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Modelo.CAMPO_NOME) {
            return validarNome(conteudo);
        }
        if (campo == Modelo.CAMPO_ANO) {
            return validarAno(conteudo);
        }
        if (campo == Modelo.CAMPO_MARCA) {
            return validarMarca(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    private Erro validarNome(Modelo obj) {
        return validarNome(obj.getNome());
    }

    public Erro validarNome(String conteudo) {
        if (conteudo.isEmpty()) {
            return new Erro(Modelo.CAMPO_NOME, "n�o pode ser vazio.");
        }
        return null;
    }

    private Erro validarAno(Modelo obj) {
        return validarAno(String.valueOf(obj.getAno()));
    }

    public Erro validarAno(String conteudo) {
        int ano;

        try {
            ano = Integer.parseInt(conteudo);
        } catch (NumberFormatException ex) {
            return new Erro(Modelo.CAMPO_ANO, "deve ser um n�mero.");
        }

        if (ano > LocalDate.now().getYear() + 1) {
            return new Erro(Modelo.CAMPO_ANO, "n�o pode ser maior do que o ano que vem.");
        }

        if (ano < 1900) {
            return new Erro(Modelo.CAMPO_ANO, "n�o pode ser menor do que 1900.");
        }

        return null;
    }

    private Erro validarMarca(String conteudo) {
        RepositorioMarca repo = RepositorioMarca.getInstance();
        if (repo.buscarPorNome(conteudo) == null) {
            return new Erro(Modelo.CAMPO_MARCA, "deve ser de uma marca cadastrada.");
        }
        return null;
    }
}
