/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.certificacoes;

import br.com.cursojava.curso.CursoRepositorio;
import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 *
 * @author 89087
 */
@WebServlet(name = "CertificacaoController", urlPatterns = {"/certificacoes"})
public class CertificacaoController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private CertificacaoRepositorio repositorio = new CertificacaoRepositorio();

    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Certificacao certificacao = null;
        try {
            //deserialização do json para o objeto curso
            certificacao = json.readValue(request.getInputStream(), Certificacao.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar a Certificacao");
        }

        if (certificacao == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (certificacao.getId() != null) {//se já tem id não pode ser inclusão
            response.sendError(406, "Certificação não pode ser incluido");
        } else {
            //salva no repositório e envia o curso atualizado na resposta
            Certificacao entidade = repositorio.salvar(certificacao);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }

    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Certificacao certificacao = null;
        try {
            //deserialização do json para o objeto curso
            certificacao = json.readValue(request.getInputStream(), Certificacao.class);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar a Certificacao");
        }

        if (certificacao == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (certificacao.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser alterado");
        } else {
                Certificacao entidade = repositorio.buscarPorId(certificacao.getId());
            if (entidade == null) { // curso não existe 
                response.sendError(406, "Certificao não existe");
            } else {
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(certificacao);
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
        Certificacao certificacao = repositorio.buscarPorId(id);

        if (certificacao == null) {// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        } else if (certificacao.getId() == null) {//se não tem id não existe no repositorio
            response.sendError(406, "Item não pode ser removido");
        } else if (repositorio.remover(certificacao)) {
            response.setContentType("application/json");
            String jsonResultado = json.writeValueAsString(certificacao);
            response.getWriter().print(jsonResultado);
        } else {
            response.sendError(406, "Certificacao não pode ser removido");
        }
    }

    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Certificacao> todos = repositorio.buscarTodos();
        //serializa a lista com todos os itens
        String jsonTodos = json.writeValueAsString(todos);
        //informa o tipo de retorno
        response.setContentType("application/json");
        //coloca os dados da lista no corpo da resposta
        response.getWriter().print(jsonTodos);

    }

    private void buscarCurso(String sId, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        Certificacao certificacao = repositorio.buscarPorId(Long.valueOf(sId));
        if (certificacao != null) {
            //serializa a lista com todos os itens
            String jsonCertificacao = json.writeValueAsString(certificacao);
            //informa o tipo de retorno
            response.setContentType("application/json");
            //coloca os dados da lista no corpo da resposta
            response.getWriter().print(jsonCertificacao);

        } else {
            response.sendError(406);
        }
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

}
