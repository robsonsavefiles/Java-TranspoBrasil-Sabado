package exercicio_veiculo.repositorio;

import exercicio_veiculo.model.Marca;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public class RepositorioMarca {

    private final static ArrayList<Marca> marcas = new ArrayList<>();

    public RepositorioMarca() {
    }

    public List<Marca> listar() {
        return marcas;
    }

    public void salvar(Marca marca) {
        if (marca == null) {
            return;
        }

        if (marca.getId() == null) {
            marca.setId(System.nanoTime());
        }

        int index = marcas.indexOf(marca);

        if (index > -1) {
            marcas.set(index, marca);
        } else {
            marcas.add(marca);
        }
    }

    public void remover(Marca marca) {
        marcas.remove(marca);
    }

    public Marca getPorId(Long id) {
        for (Marca marca : marcas) {
            if (Objects.equals(id, marca.getId())) {
                return marca;
            }
        }
        return null;
    }

    public String marcasToString() {
        if (marcas.isEmpty()) {
            return "Não há marcas cadastradas.";
        }
        return marcasToString(marcas);
    }

    public String marcasToString(List<Marca> marcas) {
        String retorno;
        retorno = String.format("%-20s|%-50s\r\n",
                "ID", "NOME");
        retorno = marcas.stream().map((marca) -> String.format("%-20s|%-50s\r\n",
                marca.getId(), marca.getNome())).reduce(retorno, String::concat);
        return retorno;
    }
}
