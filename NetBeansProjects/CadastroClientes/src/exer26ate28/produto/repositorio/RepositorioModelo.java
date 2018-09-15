package exer26ate28.produto.repositorio;

import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.model.Modelo;
import exer26ate28.produto.validacao.ValidadorEntidade;
import exer26ate28.produto.validacao.ValidadorModelo;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioModelo implements Repositorio<Modelo> {

    private final static String FILE_NAME = "modelos.txt";

    private static List<Modelo> objs;
    private static RepositorioModelo repositorio;

    private RepositorioModelo() {
        objs = lerObjetosDoArquivo();
        RepositorioMarca repMarca = RepositorioMarca.getInstance();
        for (Modelo obj : objs) {
            obj.setMarca(repMarca.buscarPorId(obj.getMarca().getId()));
        }
    }

    public static RepositorioModelo getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioModelo();
        }
        return repositorio;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    public Modelo buscarPorNome(String nome) {
        for (Modelo obj : objs) {
            if (obj.getNome().equalsIgnoreCase(nome)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Modelo> getTodos() {
        return objs;
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorModelo();
    }

    @Override
    public List<Modelo> getTodos(InfoCampo campo) {
        return objs;
    }
}
