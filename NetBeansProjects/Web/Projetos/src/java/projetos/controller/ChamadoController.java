package projetos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetos.model.Chamado;
import projetos.model.Chamado.Status;
import projetos.repositorio.ChamadoRepositorio;

/**
 *
 * @author 78522
 */
@WebServlet(name = "ChamadoController", urlPatterns = {"/chamados", "/chamados/statuses", "/chamados/projeto"})
public class ChamadoController extends EntidadeController<Chamado> {

    public ChamadoController() {
        super(ChamadoRepositorio.getInstance(), Chamado.class);
    }

    private void buscarStatuses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonTodos = getJson().writeValueAsString(Status.values());
        resp.setContentType("application/json");
        resp.getWriter().print(jsonTodos);
    }

    private void buscarPorProjeto(String sId, HttpServletResponse resp) throws ServletException, IOException {
        String jsonTodos = getJson().writeValueAsString(ChamadoRepositorio.getInstance().buscarPorProjeto(Long.parseLong(sId)));
        resp.setContentType("application/json");
        resp.getWriter().print(jsonTodos);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (null != path) {
            String sId;
            switch (path) {
                case "/chamados/statuses":
                    buscarStatuses(req, resp);
                    break;
                case "/chamados/projeto":
                    String sIdProjeto = req.getParameter("id");
                    if (sIdProjeto != null && !"".equals(sIdProjeto.trim())) {
                        buscarPorProjeto(sIdProjeto, resp);
                    }
                    break;
                default:
                    sId = req.getParameter("id");
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
