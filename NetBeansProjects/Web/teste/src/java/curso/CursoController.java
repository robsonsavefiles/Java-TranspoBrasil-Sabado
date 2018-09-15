package curso;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import curso.Curso;
import curso.CursoRepositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CursoController", urlPatterns = {"/cursos"})
public class CursoController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private CursoRepositorio repositorio = new CursoRepositorio();

    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso curso = null;
        try {
            //deserialização do json para o objeto curso
            curso = json.readValue(request.getInputStream(), Curso.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o curso");
        }

        if (curso == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (curso.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o curso atualizado na resposta
            Curso entidade = repositorio.salvar(curso);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Curso curso = null;
        try {
            //deserialização do json para o objeto curso
            curso = json.readValue(request.getInputStream(), Curso.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o curso");
        }

        if (curso == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (curso.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            Curso entidade = repositorio.buscarPorId(curso.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Curso não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(curso);
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }

        }

    }

    private void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sId = request.getParameter("id");
        Long id = sId != null ? Long.valueOf(sId) : null;
        Curso curso = repositorio.buscarPorId(id);

        if (curso == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (curso.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(curso)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(curso);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Curso não pode ser removido");
        }
    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Curso> todos = repositorio.buscarTodos();
        //serializa a lista com todos os itens
        String jsonTodos = json.writeValueAsString(todos);
        //informa o tipo de retorno
        response.setContentType("application/json");
        //coloca os dados da lista no corpo da resposta
        response.getWriter().print(jsonTodos);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("id");
        if (sId != null && !"".equals(sId.trim())) {
            buscarCurso(sId, response);
        } else {
            buscarTodos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        incluir(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        alterar(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        remover(request, response);
    }

    private void buscarCurso(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Curso curso = repositorio.buscarPorId(id);
        if (curso != null) {
            //serializa a lista com todos os itens
            String jsonCurso = json.writeValueAsString(curso);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonCurso);
        } else {
            response.sendError(406);
        }
    }

}
