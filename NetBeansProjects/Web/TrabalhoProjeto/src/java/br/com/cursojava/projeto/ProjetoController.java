package br.com.cursojava.projeto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.cursojava.projeto.ProjetoRepositorio;
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

@WebServlet(name = "ProjetoController", urlPatterns = {"/projetos"})
public class ProjetoController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private ProjetoRepositorio repositorio = new ProjetoRepositorio();

    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Projeto projeto = null;
        try {
            //deserialização do json para o objeto projeto
            projeto = json.readValue(request.getInputStream(), Projeto.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o projeto");
        }

        if (projeto == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos dumb");
        } else if (projeto.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        } else {
            //salva no repositório e envia o projeto atualizado na resposta
            Projeto entidade = repositorio.salvar(projeto);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Projeto projeto = null;
        try {
            //deserialização do json para o objeto projeto
            projeto = json.readValue(request.getInputStream(), Projeto.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar o projeto");
        }

        if (projeto == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (projeto.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
            Projeto entidade = repositorio.buscarPorId(projeto.getId());
            if (entidade == null) { // projeto não existe 
                response.sendError(406, "Projeto não existe");
            } else {
                //salva no repositório e envia o projeto atualizado na resposta
                entidade = repositorio.salvar(projeto);
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
        Projeto projeto = repositorio.buscarPorId(id);

        if (projeto == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (projeto.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(projeto)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(projeto);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Projeto não pode ser removido");
        }
    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Projeto> todos = repositorio.buscarTodos();
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
            buscarProjeto(sId, response);
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

    private void buscarProjeto(String sId, HttpServletResponse response) throws JsonProcessingException, IOException {
        Long id = Long.parseLong(sId);
        //busca todos na base de dados
        Projeto projeto = repositorio.buscarPorId(id);
        if (projeto != null) {
            //serializa a lista com todos os itens
            String jsonProjeto = json.writeValueAsString(projeto);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonProjeto);
        } else {
            response.sendError(406);
        }
    }

}
