package br.com.cursojava.providencia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.cursojava.providencia.Providencia;
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

@WebServlet(name = "ProvidenciaController", urlPatterns = {"/providencias"})
public class ProvidenciaController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private ProvidenciaRepositorio repositorio = new ProvidenciaRepositorio();

    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Providencia providencia = null;
        try {
            //deserialização do json para o objeto providencia
            providencia = json.readValue(request.getInputStream(), Providencia.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o providencia");
        }

        if (providencia == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (providencia.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o providencia atualizado na resposta
            Providencia entidade = repositorio.salvar(providencia);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Providencia providencia = null;
        try {
            //deserialização do json para o objeto providencia
            providencia = json.readValue(request.getInputStream(), Providencia.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o providencia");
        }

        if (providencia == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (providencia.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            Providencia entidade = repositorio.buscarPorId(providencia.getId());
            if (entidade == null) { // providencia não existe 
                response.sendError(406, "Providencia não existe");
            } else {
                //salva no repositório e envia o providencia atualizado na resposta
                entidade = repositorio.salvar(providencia);
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
        Providencia providencia = repositorio.buscarPorId(id);

        if (providencia == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (providencia.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(providencia)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(providencia);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Providencia não pode ser removido");
        }
    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Providencia> todos = repositorio.buscarTodos();
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
            buscarProvidencia(sId, response);
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

    private void buscarProvidencia(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Providencia providencia = repositorio.buscarPorId(id);
        if (providencia != null) {
            //serializa a lista com todos os itens
            String jsonCurso = json.writeValueAsString(providencia);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonCurso);
        } else {
            response.sendError(406);
        }
    }

}
