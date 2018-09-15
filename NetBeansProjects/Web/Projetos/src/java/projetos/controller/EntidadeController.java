package projetos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetos.model.Entidade;
import projetos.repositorio.EntidadeRepositorio;

/**
 *
 * @author 78522
 * @param <T>
 */
public abstract class EntidadeController<T extends Entidade> extends HttpServlet {

    private final ObjectMapper json = new ObjectMapper();
    private final EntidadeRepositorio<T> repositorio;
    private final Class<T> clazz;

    public ObjectMapper getJson() {
        return json;
    }

    public EntidadeRepositorio<T> getRepositorio() {
        return repositorio;
    }

    public EntidadeController(EntidadeRepositorio<T> repositorio, Class<T> clazz) {
        this.repositorio = repositorio;
        this.clazz = clazz;
    }

    public void buscarPorId(String sId, HttpServletResponse response) throws IOException {
        T obj = repositorio.buscarPorId(Long.parseLong(sId));
        if (obj == null) {
            response.sendError(406, "Item não existe");
        } else {
            String jsonEntidade = json.writeValueAsString(obj);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }
    }

    public void buscarTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<T> todos = repositorio.buscarTodos();
        String jsonTodos = json.writeValueAsString(todos);
        response.setContentType("application/json");
        response.getWriter().print(jsonTodos);
    }

    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        T obj = null;
        try {
            //deserialização do json para o objeto curso
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (obj.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o curso atualizado na resposta
            T entidade = repositorio.salvar(obj);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }
    }

    public void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        T obj = null;
        try {
            //deserialização do json para o objeto curso
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (obj.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            T entidade = repositorio.buscarPorId(obj.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Item não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(obj);
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }
        }
    }

    public void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sId = request.getParameter("id");
        Long id = sId != null ? Long.valueOf(sId) : null;
        T obj = repositorio.buscarPorId(id);
        try {
            obj = json.readValue(request.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (obj.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(obj)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(obj);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Item não pode ser removido");
        }
    }

    @Override
    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected abstract void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
