package projetos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetos.dto.ChamadoProvidencia;
import projetos.model.Providencia.Estagio;
import projetos.repositorio.ProvidenciaRepositorio;

/**
 *
 * @author 78522
 */
@WebServlet(name = "ProvidenciaController", urlPatterns = {"/providencias", "/providencias/estagios"})
public class ProvidenciaController extends HttpServlet {

    private final ObjectMapper json = new ObjectMapper();
    private final ProvidenciaRepositorio repositorio = ProvidenciaRepositorio.getInstance();
    private final Class<ChamadoProvidencia> clazz = ChamadoProvidencia.class;

    private void buscarEstagios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonTodos = json.writeValueAsString(Estagio.values());
        resp.setContentType("application/json");
        resp.getWriter().print(jsonTodos);
    }

    public void buscarTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChamadoProvidencia> todos = repositorio.buscarTodos();
        String jsonTodos = json.writeValueAsString(todos);
        response.setContentType("application/json");
        response.getWriter().print(jsonTodos);
    }

    public void buscarPorId(String sChamadoId, String sId, HttpServletResponse response) throws IOException {
        ChamadoProvidencia obj = repositorio.buscarPorId(Long.parseLong(sChamadoId), Long.parseLong(sId));
        if (obj == null) {
            response.sendError(406, "Item não existe");
        } else {
            String jsonEntidade = json.writeValueAsString(obj);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (null != path) {
            switch (path) {
                case "/providencias/estagios":
                    buscarEstagios(req, resp);
                    break;
                default:
                    String sChamadoId = req.getParameter("chamadoId");
                    String sId = req.getParameter("id");
                    if (sId != null && !"".equals(sId.trim()) && sChamadoId != null && !"".equals(sChamadoId.trim())) {
                        buscarPorId(sChamadoId, sId, resp);
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

    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChamadoProvidencia obj = null;
        try {
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {
            response.sendError(401, "dados incorretos");
        } else if (obj.getProvidencia().getId() != null) {
            response.sendError(406, "Item não pode ser incluido");
        } else {
            ChamadoProvidencia entidade = repositorio.salvar(obj);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }
    }

    public void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChamadoProvidencia obj = null;
        try {
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {
            response.sendError(401, "dados incorretos");
        } else if (obj.getProvidencia() == null || obj.getProvidencia().getId() == null) {
            response.sendError(406, "Item não pode ser alterado");
        } else {
            ChamadoProvidencia entidade = repositorio.buscarPorId(obj.getChamadoId(), obj.getProvidencia().getId());
            if (entidade == null) {
                response.sendError(406, "Item não existe");
            } else {
                entidade = repositorio.salvar(obj);
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sChamadoId = request.getParameter("chamadoId");
        String sId = request.getParameter("id");
        Long chamadoId = sChamadoId != null ? Long.valueOf(sChamadoId) : null;
        Long id = sId != null ? Long.valueOf(sId) : null;
        ChamadoProvidencia obj = repositorio.buscarPorId(chamadoId, id);
        try {
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {
            response.sendError(401, "dados incorretos");
        } else if (obj.getProvidencia().getId() == null) {
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(obj)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(obj);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Item não pode ser removido");
        }
    }

}
