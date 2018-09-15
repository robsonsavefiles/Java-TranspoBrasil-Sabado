package br.com.cursojava.turma;

import br.com.cursojava.turma.Turma;
import br.com.cursojava.curso.CursoRepositorio;
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
 * @author 89087
 */
@WebServlet(
        name = "TurmaController",
        urlPatterns = {"/turmas", "/turmas/"})
       public class TurmaController extends HttpServlet {

    private ObjectMapper json = new ObjectMapper();
    private TurmaRepositorio repositorio = new TurmaRepositorio();

    
    private void incluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Turma turma = null;
        try{
            //deserialização do json para o objeto curso
            turma = json.readValue(request.getInputStream(), Turma.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar a Turma");
        }
        
        if(turma == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(turma.getId() != null){//se já tem id não pode ser inclusão
            response.sendError(406, "Item não pode ser incluido");
        }else{
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
        try{
            //deserialização do json para o objeto turma
            turma  = json.readValue(request.getInputStream(), Turma.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar o Turma");
        }
        
        if(turma  == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(turma .getId() == null){//se não tem id não existe no repositorio
            response.sendError(406, "Turma não pode ser alterado");
        }else{
            Turma entidade = repositorio.buscarPorId(turma.getId());
            if(entidade == null){ // curso não existe 
                 response.sendError(406, "Turma não existe");
            }else{
                //salva no repositório e envia a turma  atualizada na resposta
                entidade = repositorio.salvar(turma );
                String jsonEntidade = json.writeValueAsString(entidade);
                response.setContentType("application/json");
                response.getWriter().print(jsonEntidade);
            }
            
        }
        
    }
    
    private void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Turma turma = null;
        try{
            //deserialização do json para o objeto turma
            turma = json.readValue(request.getInputStream(), Turma.class);
        }catch(Exception ex){
            System.out.println("Falha ao desserializar o turma");
        }
        
        if(turma == null){// não conseguiu desserializar; dados errados
            response.sendError(401, "dados incorretos");
        }else if(turma.getId() == null){//se não tem id não existe no repositorio
            response.sendError(406, "Turma não pode ser removido");
        }else{
            if(repositorio.remover(turma)){
                response.setContentType("application/json");
                String jsonResultado = json.writeValueAsString(turma);
                response.getWriter().print(jsonResultado);
            }else{
                response.sendError(406, "Turma não pode ser removido");
            }
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
