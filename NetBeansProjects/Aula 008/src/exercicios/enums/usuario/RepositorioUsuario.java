package exercicios.enums.usuario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioUsuario {

    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static long nextId = 0;

    public void salvar(Usuario usuario) {
        if (usuario == null) {
            return;
        }

        if (usuario.getId() == null) {
            usuario.setId(nextId++);
        }

        int idx = usuarios.indexOf(usuario);

        if (idx > -1) {
            usuarios.set(idx, usuario);
        } else {
            usuarios.add(usuario);
        }
    }

    public void remover(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario getPorId(long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
