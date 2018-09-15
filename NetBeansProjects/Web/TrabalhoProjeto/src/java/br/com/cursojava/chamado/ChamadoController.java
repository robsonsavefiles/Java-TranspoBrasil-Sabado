package br.com.cursojava.chamado;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.cursojava.chamado.Chamado;

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

@WebServlet(name = "ChamadoController", urlPatterns = {"/chamados","/chamados/projeto"})
public class ChamadoController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private ChamadoRepositorio repositorio = new ChamadoRepositorio();

    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Chamado chamado = null;
        try {
            //deserialização do json para o objeto chamado
            chamado = json.readValue(request.getInputStream(), Chamado.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o chamado");
        }

        if (chamado == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (chamado.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o chamado atualizado na resposta
            Chamado entidade = repositorio.salvar(chamado);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Chamado chamado = null;
        try {
            //deserialização do json para o objeto chamado
            chamado = json.readValue(request.getInputStream(), Chamado.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o chamado");
        }

        if (chamado == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (chamado.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            Chamado entidade = repositorio.buscarPorId(chamado.getId());
            if (entidade == null) { // chamado não existe 
                response.sendError(406, "Chamado não existe");
            } else {
                //salva no repositório e envia o chamado atualizado na resposta
                entidade = repositorio.salvar(chamado);
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
        Chamado chamado = repositorio.buscarPorId(id);

        if (chamado == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (chamado.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(chamado)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(chamado);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406,"Chamado não pode ser removido");
        }
    }

    private void buscarChamadosPorProjeto(String sId, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Chamado> todos = repositorio.buscarPorProjeto(Long.valueOf(sId));
        //serializa a lista com todos os itens
        String jsonTodos = json.writeValueAsString(todos);
        //informa o tipo de retorno
        response.setContentType("application/json");
        //coloca os dados da lista no corpo da resposta
        response.getWriter().print(jsonTodos);

    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Chamado> todos = repositorio.buscarTodos();
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
        String sIdProjeto = request.getParameter("idProjeto");
        String sId = request.getParameter("id");
        if (sIdProjeto != null) {
            buscarChamadosPorProjeto(sIdProjeto, response);
        } else if (sId != null && !"".equals(sId.trim())) {
            buscarChamado(sId, response);
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

    private void buscarChamado(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Chamado chamado = repositorio.buscarPorId(id);
        if (chamado != null) {
            //serializa a lista com todos os itens
            String jsonCurso = json.writeValueAsString(chamado);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonCurso);
        } else {
            response.sendError(406);
        }
    }

}
