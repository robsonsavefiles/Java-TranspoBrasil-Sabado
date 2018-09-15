package exer26ate28.produto.validacao;

import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.model.Veiculo;
import exer26ate28.produto.repositorio.RepositorioMarca;
import exer26ate28.produto.repositorio.RepositorioModelo;
import java.time.LocalDate;

/**
 *
 * @author 78522
 */
public class ValidadorVeiculo extends ValidadorEntidade<Veiculo> {

    @Override
    public boolean isValido(Veiculo obj) {
        super.isValido(obj);
        addErro(validarPlaca(obj));
        addErro(validarCor(obj));
        addErro(validarAnoFabricacao(obj));
        return getErros().isEmpty();
    }

    @Override
    public Erro validarCampo(InfoCampo campo, String conteudo) {
        if (campo == Veiculo.CAMPO_PLACA) {
            return validarPlaca(conteudo);
        }
        if (campo == Veiculo.CAMPO_COR) {
            return validarCor(conteudo);
        }
        if (campo == Veiculo.CAMPO_ANO_FABRICACAO) {
            return validarAnoFabricacao(conteudo);
        }
        if (campo == Veiculo.CAMPO_MODELO) {
            return validarModelo(conteudo);
        }
        if (campo == Veiculo.CAMPO_MARCA) {
            return validarMarca(conteudo);
        }
        return super.validarCampo(campo, conteudo);
    }

    private Erro validarPlaca(Veiculo obj) {
        return validarPlaca(obj.getPlaca());
    }

    public Erro validarPlaca(String conteudo) {
        if (!conteudo.matches("^[a-zA-Z]{3}\\-\\d{4}$")) {
            return new Erro(Veiculo.CAMPO_PLACA, "deve estar no formato ABC-1234.");
        }
        return null;
    }

    private Erro validarCor(Veiculo obj) {
        return validarCor(obj.getCor());
    }

    public Erro validarCor(String conteudo) {
        return null;
    }

    private Erro validarAnoFabricacao(Veiculo obj) {
        return validarAnoFabricacao(String.valueOf(obj.getAnoFabricacao()));
    }

    public Erro validarAnoFabricacao(String conteudo) {
        int ano;

        try {
            ano = Integer.parseInt(conteudo);
        } catch (NumberFormatException ex) {
            return new Erro(Veiculo.CAMPO_ANO_FABRICACAO, "deve ser um n�mero.");
        }

        if (ano > LocalDate.now().getYear()) {
            return new Erro(Veiculo.CAMPO_ANO_FABRICACAO, "n�o pode ser maior do que o ano atual.");
        }

        if (ano < 1900) {
            return new Erro(Veiculo.CAMPO_ANO_FABRICACAO, "n�o pode ser menor do que 1900.");
        }

        return null;
    }

    private Erro validarModelo(String conteudo) {
        RepositorioModelo repo = RepositorioModelo.getInstance();
        if (repo.buscarPorNome(conteudo) == null) {
            return new Erro(Veiculo.CAMPO_MODELO, "deve ser de um modelo cadastrado.");
        }
        return null;
    }

    private Erro validarMarca(String conteudo) {
        RepositorioMarca repo = RepositorioMarca.getInstance();
        if (repo.buscarPorNome(conteudo) == null) {
            return new Erro(Veiculo.CAMPO_MARCA, "deve ser de uma marca cadastrada.");
        }
        return null;
    }

}
