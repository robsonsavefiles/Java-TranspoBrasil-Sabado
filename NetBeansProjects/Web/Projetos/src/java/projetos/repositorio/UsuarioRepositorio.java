package projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import projetos.model.Usuario;
import projetos.model.Usuario.Permissoes;
import projetos.model.UsuarioCredencial;

/**
 *
 * @author 78522
 */
public class UsuarioRepositorio implements EntidadeRepositorio<Usuario> {

    private static final List<Usuario> LISTA = new ArrayList();

    static {
        List<Permissoes> aut = new ArrayList();
        aut.add(Permissoes.ADMINISTRADOR);
        List<Permissoes> aut2 = new ArrayList();
        aut2.add(Permissoes.SUPORTE);
        LISTA.add(new Usuario(1L, "Tiago Dionesto", "tiago", "t", aut));
        LISTA.add(new Usuario(2L, "Fernando Mueller", "fernando", "f", aut2));
        LISTA.add(new Usuario(3L, "Robson Ferreira", "robson", "r", aut2));
    }

    private static UsuarioRepositorio instance;

    private UsuarioRepositorio() {

    }

    public static UsuarioRepositorio getInstance() {
        if (instance == null) {
            instance = new UsuarioRepositorio();
        }
        return instance;
    }

    @Override
    public Usuario buscarPorId(long id) {
        for (Usuario obj : LISTA) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> retorno = new ArrayList();
        retorno.addAll(LISTA);
        return retorno;
    }

    @Override
    public Usuario salvar(Usuario obj) {
        if (obj.getId() == null) {
            obj.setId(System.currentTimeMillis());
        }
        int index = LISTA.indexOf(obj);
        if (index > -1) {
            LISTA.set(index, obj);
        } else {
            LISTA.add(obj);
        }
        return obj;
    }

    @Override
    public boolean remover(Usuario obj) {
        return LISTA.remove(obj);
    }

    public Usuario efetuarLogin(UsuarioCredencial credencial) {
        for (Usuario obj : LISTA) {
            if (obj.getLogin().equals(credencial.getLogin())) {
                if (obj.getSenha().equals(credencial.getSenha())) {
                    return obj;
                }
            }
        }
        return null;
    }

}
