/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 66463
 */
@WebServlet(name = "ProfessorController", urlPatterns = {"/professores"})
public class ProfessorController extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private ProfessorRepositorio repositorio = new ProfessorRepositorio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessorController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sId = request.getParameter("id");
        if (sId != null && !"".equals(sId.trim())) {
            buscarProfessor(sId, response);
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

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        //busca todos na base de dados
        List<Professor> todos = repositorio.buscarTodos();
        //serializa a lista com todos os itens
        String jsonTodos = mapper.writeValueAsString(todos);
        //informa o tipo de retorno
        response.setContentType("application/json");
        //coloca os dados da lista no corpo da resposta
        response.getWriter().print(jsonTodos);
    }

    private void incluir(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Professor professor = null;

        try {
            professor = mapper.readValue(request.getInputStream(), Professor.class);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o arquivo");
        }

        if (professor == null) {
            response.sendError(401, "Dados Inválidos");
        } else if (professor.getId() != null) {
            response.sendError(406, "Item não pode ser incluído");
        } else {

            Professor entidade = repositorio.salvar(professor);
            String jsonEntidade = mapper.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);

        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Professor professor = null;

        try {
            professor = mapper.readValue(request.getInputStream(), Professor.class);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o arquivo");
        }

        if (professor == null) {
            response.sendError(401, "Dados Inválidos");
        } else if (professor.getId() == null) {
            response.sendError(406, "Item não pode ser incluído");
        } else {

            Professor entidade = repositorio.buscarPorId(professor.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Curso não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(professor);
                String jsonEntidade = mapper.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }

        }

    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sId = request.getParameter("id");
        Long id = sId != null ? Long.valueOf(sId) : null;
        Professor professor = repositorio.buscarPorId(id);

        if (professor == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (professor.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(professor)) {
            response.setContentType("application/json");
            String jsonResultado = mapper.writeValueAsString(professor);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Professor não pode ser removido");
        }
    }

    private void buscarProfessor(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Professor professor = repositorio.buscarPorId(id);
        if (professor != null) {
            //serializa a lista com todos os itens
            String jsonProfessor = mapper.writeValueAsString(professor);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonProfessor);
        } else {
            response.sendError(406);
        }
    }
}
