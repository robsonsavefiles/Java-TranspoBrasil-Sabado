package exer26ate28.produto.repositorio;

import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.model.Marca;
import exer26ate28.produto.model.Modelo;
import exer26ate28.produto.model.Veiculo;
import exer26ate28.produto.validacao.ValidadorEntidade;
import exer26ate28.produto.validacao.ValidadorVeiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioVeiculo implements Repositorio<Veiculo> {

    private final static String FILE_NAME = "veiculos.txt";

    private static List<Veiculo> objs;
    private static RepositorioVeiculo repositorio;

    private RepositorioVeiculo() {
        objs = lerObjetosDoArquivo();
        RepositorioModelo repModelo = RepositorioModelo.getInstance();
        objs.stream().forEach((obj) -> obj.setModelo(repModelo.buscarPorId(obj.getModelo().getId())));
    }

    public static RepositorioVeiculo getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioVeiculo();
        }
        return repositorio;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public List<Veiculo> getTodos() {
        return objs;
    }

    public List<Veiculo> getTodos(InfoCampo campo) {
        List<Veiculo> lista = getTodos();

        if (campo == Veiculo.CAMPO_ID) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == Veiculo.CAMPO_PLACA) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> v1.getPlaca().compareTo(v2.getPlaca()));
        }
        if (campo == Veiculo.CAMPO_COR) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> v1.getCor().compareTo(v2.getCor()));
        }
        if (campo == Veiculo.CAMPO_MODELO) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> v1.getModelo().getNome().compareTo(v2.getModelo().getNome()));
        }
        if (campo == Veiculo.CAMPO_MARCA) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> v1.getModelo().getMarca().getNome().compareTo(v2.getModelo().getMarca().getNome()));
        }
        if (campo == Veiculo.CAMPO_ANO_FABRICACAO) {
            Collections.sort(lista, (Veiculo v1, Veiculo v2) -> Integer.compare(v1.getAnoFabricacao(), v2.getAnoFabricacao()));
        }

        return lista;
    }

    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo obj : objs) {
            if (obj.getPlaca().equalsIgnoreCase(placa)) {
                return obj;
            }
        }
        return null;
    }

    public List<Veiculo> buscarPorMarca(Marca marca) {
        ArrayList<Veiculo> retorno = new ArrayList();
        for (Veiculo obj : objs) {
            if (obj.getModelo().getMarca().equals(marca)) {
                retorno.add(obj);
            }
        }
        return retorno;
    }

    public List<Veiculo> buscarPorModelo(Modelo modelo) {
        ArrayList<Veiculo> retorno = new ArrayList();
        for (Veiculo obj : objs) {
            if (obj.getModelo().equals(modelo)) {
                retorno.add(obj);
            }
        }
        return retorno;
    }

    public List<Veiculo> buscarPorAnoFabricacao(int ano) {
        ArrayList<Veiculo> retorno = new ArrayList();
        for (Veiculo obj : objs) {
            if (obj.getAnoFabricacao() == ano) {
                retorno.add(obj);
            }
        }
        return retorno;
    }

    public List<Veiculo> buscarPorAnoModelo(int ano) {
        ArrayList<Veiculo> retorno = new ArrayList();
        for (Veiculo obj : objs) {
            if (obj.getModelo().getAno() == ano) {
                retorno.add(obj);
            }
        }
        return retorno;
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorVeiculo();
    }

//    @Override
//    public List<Veiculo> lerObjetosDoArquivo() {
//        return IO.lerObjetosNoArquivo(FILE_NAME, Veiculo.class);
//    }
}
