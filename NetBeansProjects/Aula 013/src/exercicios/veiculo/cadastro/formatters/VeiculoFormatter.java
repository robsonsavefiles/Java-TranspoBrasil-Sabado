package exercicios.veiculo.cadastro.formatters;

import exercicios.veiculo.model.Modelo;
import exercicios.veiculo.repositorio.RepositorioModelo;

/**
 *
 * @author 78522
 */
public class VeiculoFormatter {

    public static String getPlaca(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input.toUpperCase();
    }

    public static String getCor(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    public static Integer getAnoFabricacao(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return Integer.parseInt(input);
    }

    public static Modelo getModelo(String input) {
        if (input.isEmpty()) {
            return null;
        }
        RepositorioModelo rep = RepositorioModelo.getInstance();
        return rep.buscarPorNome(input);
    }
}
