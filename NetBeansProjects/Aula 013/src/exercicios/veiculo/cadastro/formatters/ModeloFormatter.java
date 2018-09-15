package exercicios.veiculo.cadastro.formatters;

import exercicios.veiculo.model.Marca;
import exercicios.veiculo.repositorio.RepositorioMarca;

/**
 *
 * @author 78522
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
