package exercicio_veiculo.repositorio;

import exercicio_veiculo.model.Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public class RepositorioModelo {

    private final static ArrayList<Modelo> modelos = new ArrayList<>();

    public RepositorioModelo() {
    }

    public List<Modelo> listar() {
        return modelos;
    }

    public void salvar(Modelo modelo) {
        if (modelo == null) {
            return;
        }

        if (modelo.getId() == null) {
            modelo.setId(System.nanoTime());
        }

        int index = modelos.indexOf(modelo);

        if (index > -1) {
            modelos.set(index, modelo);
        } else {
            modelos.add(modelo);
        }
    }

    public void remover(Modelo modelo) {
        modelos.remove(modelo);
    }

    public Modelo getPorId(Long id) {
        for (Modelo modelo : modelos) {
            if (Objects.equals(id, modelo.getId())) {
                return modelo;
            }
        }
        return null;
    }

    public String modelosToString() {
        if (modelos.isEmpty()) {
            return "Não há marcas cadastradas.";
        }
        return modelosToString(modelos);
    }

    public String modelosToString(List<Modelo> modelos) {
        String retorno;
        retorno = String.format("%-20s|%-50s|%-20s\r\n",
                "ID", "MARCA", "NOME", "ANO");
        retorno = modelos.stream().map((modelo) -> String.format("%-20s|%-50s|%-50s|%-20s\r\n",
                modelo.getId(), modelo.getMarca().getNome(), modelo.getNome(), modelo.getAno())).reduce(retorno, String::concat);
        return retorno;
    }
}
