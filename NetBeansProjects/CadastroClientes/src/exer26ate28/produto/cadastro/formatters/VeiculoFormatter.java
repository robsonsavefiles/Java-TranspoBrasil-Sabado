package exer26ate28.produto.cadastro.formatters;

import exer26ate28.produto.model.Modelo;
import exer26ate28.produto.repositorio.RepositorioModelo;

/**
 *
 * @author 89087
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
