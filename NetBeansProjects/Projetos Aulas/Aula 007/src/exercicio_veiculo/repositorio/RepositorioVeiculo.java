package exercicio_veiculo.repositorio;

import exercicio_veiculo.model.Veiculo;
import exercicio_veiculo.model.Marca;
import exercicio_veiculo.model.Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public class RepositorioVeiculo {

    private final static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public RepositorioVeiculo() {
    }

    public List<Veiculo> listar() {
        return veiculos;
    }

    public void salvar(Veiculo veiculo) {
        if (veiculo == null) {
            return;
        }

        if (veiculo.getId() == null) {
            veiculo.setId(System.nanoTime());
        }

        int index = veiculos.indexOf(veiculo);

        if (index > -1) {
            veiculos.set(index, veiculo);
        } else {
            veiculos.add(veiculo);
        }
    }

    public void remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public Veiculo getPorId(Long id) {
        for (Veiculo veiculo : veiculos) {
            if (Objects.equals(id, veiculo.getId())) {
                return veiculo;
            }
        }
        return null;
    }

    public List<Veiculo> listarPorMarca(Marca marca) {
        ArrayList<Veiculo> retorno = new ArrayList<>();
        veiculos.stream().filter((v) -> (v.getModelo().getMarca().equals(marca))).forEach((v) -> retorno.add(v));
        return retorno;
    }

    public List<Veiculo> listarPorModelo(Modelo modelo) {
        ArrayList<Veiculo> retorno = new ArrayList<>();
        veiculos.stream().filter((v) -> (v.getModelo().getNome().equalsIgnoreCase(modelo.getNome()))).forEach((v) -> retorno.add(v));
        return retorno;
    }

    public List<Veiculo> listarPorAnoFabricacao(int ano) {
        return listarPorAnoFabricacaoPeriodo(ano, ano);
    }

    public List<Veiculo> listarPorAnoFabricacaoPeriodo(int de, int ate) {
        ArrayList<Veiculo> retorno = new ArrayList<>();
        veiculos.stream().filter((v) -> (v.getAnoFabricacao() >= de && v.getAnoFabricacao() <= ate)).forEach((v) -> retorno.add(v));
        return retorno;
    }

    public List<Veiculo> listarPorAnoModelo(int ano) {
        return listarPorAnoModeloPeriodo(ano, ano);
    }

    public List<Veiculo> listarPorAnoModeloPeriodo(int de, int ate) {
        ArrayList<Veiculo> retorno = new ArrayList<>();
        veiculos.stream().filter((v) -> (v.getModelo().getAno() >= de && v.getModelo().getAno() <= ate)).forEach((v) -> retorno.add(v));
        return retorno;
    }

    public String veiculosToString() {
        if (veiculos.isEmpty()) {
            return "NÃ£o há veiculos cadastrados.";
        }
        return veiculosToString(veiculos);
    }

    public String veiculosToString(List<Veiculo> veiculos) {
        String retorno;
        retorno = String.format("%-20s|%-50s|%-50s|%-20s|%-20s\r\n",
                "ID", "MARCA", "MODELO", "MODELO ANO", "ANO DE FABRICAÇÃO");

        retorno = veiculos.stream().map((veiculo) -> String.format("%-20s|%-50s|%-50s|%-20s|%-20s\r\n",
                veiculo.getId(), veiculo.getModelo().getMarca().getNome(), veiculo.getModelo().getNome(), veiculo.getModelo().getAno(), veiculo.getAnoFabricacao())).reduce(retorno, String::concat);

        return retorno;
    }
}
