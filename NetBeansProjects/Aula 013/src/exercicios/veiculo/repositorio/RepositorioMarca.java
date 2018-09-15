package exercicios.veiculo.repositorio;

import exercicios.veiculo.model.InfoCampo;
import exercicios.veiculo.model.Marca;
import exercicios.veiculo.validacao.ValidadorEntidade;
import exercicios.veiculo.validacao.ValidadorMarca;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioMarca implements Repositorio<Marca> {

    private final static String FILE_NAME = "marcas.txt";

    private static List<Marca> objs;
    private static RepositorioMarca repositorio;

    private RepositorioMarca() {
        objs = lerObjetosDoArquivo();
    }

    public static RepositorioMarca getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioMarca();
        }
        return repositorio;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    public Marca buscarPorNome(String nome) {
        for (Marca obj : objs) {
            if (obj.getNome().equalsIgnoreCase(nome)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Marca> getTodos() {
        return objs;
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorMarca();
    }

    @Override
    public List<Marca> getTodos(InfoCampo campo) {
        return objs;
    }
}
