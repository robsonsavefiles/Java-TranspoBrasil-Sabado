/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certificacoes;

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
@WebServlet(name = "CertificacaoController", urlPatterns = {"/certificacoes"})
public class CertificacaoController extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private CerificacoesRepositorio repositorio = new CerificacoesRepositorio();

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
            out.println("<title>Servlet CertificacaoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CertificacaoController at " + request.getContextPath() + "</h1>");
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
            buscarCertificacao(sId, response);
        } else {
            buscarTodos(request, response);
        }
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        //busca todos na base de dados
        List<Certificacao> todos = repositorio.buscarTodos();
        //serializa a lista com todos os itens
        String jsonTodos = mapper.writeValueAsString(todos);
        //informa o tipo de retorno
        response.setContentType("application/json");
        //coloca os dados da lista no corpo da resposta
        response.getWriter().print(jsonTodos);
    }

    private void incluir(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Certificacao certificacao = null;

        try {
            certificacao = mapper.readValue(request.getInputStream(), Certificacao.class);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o arquivo");
        }

        if (certificacao == null) {
            response.sendError(401, "Dados Inválidos");
        } else if (certificacao.getId() != null) {
            response.sendError(406, "Item não pode ser incluído");
        } else {

            Certificacao entidade = repositorio.salvar(certificacao);
            String jsonEntidade = mapper.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);

        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Certificacao certificacao = null;

        try {
            certificacao = mapper.readValue(request.getInputStream(), Certificacao.class);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar o arquivo");
        }

        if (certificacao == null) {
            response.sendError(401, "Dados Inválidos");
        } else if (certificacao.getId() == null) {
            response.sendError(406, "Item não pode ser incluído");
        } else {

            Certificacao entidade = repositorio.buscarPorId(certificacao.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Certificação não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(certificacao);
                String jsonEntidade = mapper.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }

        }

    }

    private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sId = request.getParameter("id");
        Long id = sId != null ? Long.valueOf(sId) : null;
        Certificacao certificacao = repositorio.buscarPorId(id);

        if (certificacao == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (certificacao.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(certificacao)) {
            response.setContentType("application/json");
            String jsonResultado = mapper.writeValueAsString(certificacao);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Curso não pode ser removido");
        }
    }

    private void buscarCertificacao(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Certificacao certificacao = repositorio.buscarPorId(id);
        if (certificacao != null) {
            //serializa a lista com todos os itens
            String jsonProfessor = mapper.writeValueAsString(certificacao);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonProfessor);
        } else {
            response.sendError(406);
        }
    }

}
