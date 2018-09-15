/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 66463
 */
@WebServlet(name = "AlunosController", urlPatterns = {"/alunos"})
public class AlunosController extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private AlunoRepositorio repositorio = new AlunoRepositorio();

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
            out.println("<title>Servlet AlunosController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlunosController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String sId = request.getParameter("id");
        if (sId != null && !"".equals(sId.trim())) {
            buscarAluno(sId, response);
        } else {
            buscarTodos(response);
        }

    }

    private void buscarTodos(HttpServletResponse response) throws IOException, JsonProcessingException {
        String resultado = mapper.writeValueAsString(repositorio.buscarTodos());
        response.setContentType("application/json");
        response.getWriter().print(resultado);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();


            adicionar(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Aluno aluno = null;
        try {
            aluno = mapper.readValue(request.getInputStream(), Aluno.class);
        } catch (Exception e) {
            System.out.println("Falha ao Deserializar o Usuário");
        }
        if (aluno == null) {
            response.sendError(401);
        } else if (aluno.getId() == null) {
            response.sendError(406);
        } else {
            Aluno local = repositorio.buscarPorId(aluno.getId());
            if (local == null) {
                response.sendError(406, "Usuário não Existe");
            } else {
                aluno = repositorio.salvar(aluno);
                String resultado = mapper.writeValueAsString(aluno);
                response.setContentType("application/json");
                response.getWriter().print(resultado);
            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sId = request.getParameter("id");
        Long id = sId != null ? Long.valueOf(sId) : null;
        Aluno aluno = repositorio.buscarPorId(id);

        if (aluno == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (aluno.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(aluno)) {
            response.setContentType("application/json");
            String jsonResultado = mapper.writeValueAsString(aluno);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Curso não pode ser removido");
        }
    }

    private void adicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aluno aluno = null;
        try {
            //deserialização do json para o objeto curso
            aluno = mapper.readValue(request.getInputStream(), Aluno.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o curso");
        }

        if (aluno == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (aluno.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o curso atualizado na resposta
            Aluno entidade = repositorio.salvar(aluno);
            String jsonEntidade = mapper.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void buscarAluno(String sId, HttpServletResponse response) throws IOException {
        
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Aluno aluno = repositorio.buscarPorId(id);
        if (aluno != null) {
            //serializa a lista com todos os itens
            String jsonAluno = mapper.writeValueAsString(aluno);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonAluno);
        } else {
            response.sendError(406);
        }
        
    }

}
