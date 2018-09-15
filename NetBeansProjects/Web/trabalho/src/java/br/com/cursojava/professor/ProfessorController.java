/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.professor;

import br.com.cursojava.professor.Professor;
import br.com.cursojava.professor.ProfessorRepositorio;
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
@WebServlet(name = "ProfessorController", urlPatterns = {"/professores"})
public class ProfessorController extends HttpServlet {
    
    private ObjectMapper json = new ObjectMapper();
    private ProfessorRepositorio repositorio = new ProfessorRepositorio();

    
    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Professor professor = null;
        try{
            //deserialização do json para o objeto curso
            professor = json.readValue(request.getInputStream(), Professor.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar o professor");
        }
        
        if(professor == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(professor.getId() != null){//se já tem id não pode ser inclusão
            response.sendError(406, "professor não pode ser incluido");
        }else{
            //salva no repositório e envia o curso atualizado na resposta
            Professor entidade = repositorio.salvar(professor);
            String jsonEntidade = json.writeValueAsString(entidade);
            response.setContentType("application/json");
            response.getWriter().print(jsonEntidade);
        }
        
    }
    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Professor professor = null;
        try{
            //deserialização do json para o objeto curso
            professor = json.readValue(request.getInputStream(), Professor.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar o professor");
        }
        
        if(professor == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(professor.getId() == null){//se não tem id não existe no repositorio
            response.sendError(406, "professor não pode ser alterado");
        }else{
            Professor entidade = repositorio.buscarPorId(professor.getId());
            if(entidade == null){ // curso não existe 
                 response.sendError(406, "Professor não existe");
            }else{
                //salva no repositório e envia o curso atualizado na resposta
                entidade = repositorio.salvar(professor);
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }
            
        }
        
    }
    
    private void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Professor professor = null;
        try{
            //deserialização do json para o objeto curso
            professor = json.readValue(request.getInputStream(), Professor.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar o professor");
        }
        
        if(professor == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(professor.getId() == null){//se não tem id não existe no repositorio
            response.sendError(406, "professor não pode ser removido");
        }else{
            if(repositorio.remover(professor)){
                response.setContentType("application/json");
                String jsonResultado = json.writeValueAsString(professor);
                response.getWriter().print(jsonResultado);
            }else{
                response.sendError(406, "professor não pode ser removido");
            }
        }
        
        
    }
    private void buscarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //busca todos na base de dados
        List<Professor> todos = repositorio.buscarTodos();
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
        buscarTodos(request, response);
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
