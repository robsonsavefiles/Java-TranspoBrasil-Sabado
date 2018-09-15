package projetos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetos.model.Usuario;
import projetos.model.Usuario.Permissoes;
import projetos.repositorio.UsuarioRepositorio;

/**
 *
 * @author 78522
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuarios", "/usuarios/permissoes"})
public class UsuarioController extends EntidadeController<Usuario> {

    public UsuarioController() {
        super(UsuarioRepositorio.getInstance(), Usuario.class);
    }

    private void buscarPermissoes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonTodos = getJson().writeValueAsString(Permissoes.values());
        resp.setContentType("application/json");
        resp.getWriter().print(jsonTodos);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (null != path) {
            switch (path) {
                case "/usuarios/permissoes":
                    buscarPermissoes(req, resp);
                    break;
                default:
                    String sId = req.getParameter("id");
                    if (sId != null && !"".equals(sId.trim())) {
                        buscarPorId(sId, resp);
                    } else {
                        buscarTodos(req, resp);
                    }
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        incluir(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        alterar(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        remover(req, resp);
    }

}
