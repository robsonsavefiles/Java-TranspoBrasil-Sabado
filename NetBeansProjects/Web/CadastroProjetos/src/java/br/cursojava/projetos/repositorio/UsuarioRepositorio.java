package br.cursojava.projetos.repositorio;

import java.util.ArrayList;
import java.util.List;
import br.cursojava.model.Usuario;
import br.cursojava.model.Usuario.Autorizacao;
import br.cursojava.model.UsuarioCredencial;

/**
 *
 * @author 89087
 */
public class UsuarioRepositorio implements EntidadeRepositorio<Usuario> {

    private static final List<Usuario> LISTA = new ArrayList();

    static {
        List<Autorizacao> aut = new ArrayList();
        aut.add(Autorizacao.ADM);
        LISTA.add(new Usuario(1L, "Robson Ferreira ", "robinho", "rm", aut));
        LISTA.add(new Usuario(2L, "Felipe de Oliveira", "felipe", "fo", aut));
        LISTA.add(new Usuario(3L, "Fernando Muller", "fernando", "fm", aut));
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
