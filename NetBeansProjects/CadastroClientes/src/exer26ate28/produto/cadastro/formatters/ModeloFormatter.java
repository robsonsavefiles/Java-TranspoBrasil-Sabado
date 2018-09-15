package exer26ate28.produto.cadastro.formatters;

import exer26ate28.produto.model.Marca;
import exer26ate28.produto.repositorio.RepositorioMarca;

/**
 *
 * @author 89087
 */
public class ModeloFormatter {

    public static String getNome(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    public static Integer getAno(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return Integer.parseInt(input);
    }

    public static Marca getMarca(String input) {
        if (input.isEmpty()) {
            return null;
        }
        RepositorioMarca rep = RepositorioMarca.getInstance();
        return rep.buscarPorNome(input);
    }
}
