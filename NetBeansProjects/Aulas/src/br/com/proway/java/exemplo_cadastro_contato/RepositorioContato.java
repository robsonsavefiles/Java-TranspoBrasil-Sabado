package exemplo_cadastro_contato;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 78522
 */
public class RepositorioContato {

    private static final ArrayList<Contato> contatos = new ArrayList<>();

    public List<Contato> listar() {
        return contatos;
    }

    public void salvar(Contato contato) {
        if (contato == null) {
            return;
        }

        if (contato.getId() == null) {
            contato.setId(System.currentTimeMillis());
        }

        int index = contatos.indexOf(contato);

        if (index > -1) {
            contatos.set(index, contato);
        } else {
            contatos.add(contato);
        }
    }

    public void remover(Contato contato) {
        contatos.remove(contato);
    }

    public Contato buscarPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarPorId(Long id) {
        for (Contato contato : contatos) {
            if (Objects.equals(contato.getId(), id)) {
                return contato;
            }
        }
        return null;
    }
}
