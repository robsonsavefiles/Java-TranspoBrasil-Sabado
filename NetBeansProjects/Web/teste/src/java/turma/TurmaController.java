/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turma;

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
@WebServlet(name = "TurmaController", urlPatterns = {"/turmas"})
public class TurmaController extends HttpServlet {
    
    private ObjectMapper json = new ObjectMapper();
    private TurmaRepositorio repositorio = new TurmaRepositorio();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TurmaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurmaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Turma turma = null;
        try {
            //deserialização do json para o objeto curso
            turma = json.readValue(request.getInputStream(), Turma.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar a turma");
        }

        if (turma == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (turma.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o curso atualizado na resposta
            Turma entidade = repositorio.salvar(turma);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Turma turma = null;
        try {
            //deserialização do json para o objeto curso
            turma = json.readValue(request.getInputStream(), Turma.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar a turma");
        }

        if (turma == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (turma.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            Turma entidade = repositorio.buscarPorId(turma.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Curso não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(turma);
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }

        }

    }

    private void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sId = request.getParameter("idTurma");
        Long id = sId != null ? Long.valueOf(sId) : null;
        Turma turma = repositorio.buscarPorId(id);

        if (turma == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (turma.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(turma)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(turma);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Curso não pode ser removido");
        }
    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Turma> todos = repositorio.buscarTodos();
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
            buscarTurma(sId, response);
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

    private void buscarTurma(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Turma turma = repositorio.buscarPorId(id);
        if (turma != null) {
            //serializa a lista com todos os itens
            String jsonCurso = json.writeValueAsString(turma);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonCurso);
        } else {
            response.sendError(406);
        }
    }
}
