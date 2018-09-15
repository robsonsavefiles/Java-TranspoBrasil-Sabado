package br.com.globalcode.servlets;

import br.com.globalcode.dao.FuncionariosDAO;
import br.com.globalcode.model.Funcionario;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class CompletarFuncionarios extends HttpServlet {
    
    private ServletContext context;
    
    private List<Funcionario> employees;
    
    public CompletarFuncionarios(){
        employees = FuncionariosDAO.getInstance().getAllFuncionarios();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        context = getServletConfig().getServletContext();
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        if("complete".equals(action)) {
            // cria a lista com os funcionarios encontrados, com base no valor digitado
            for (Funcionario funcionario: employees) {
                if(id != null && (funcionario.getNome().toLowerCase().startsWith(id) || funcionario.getSobrenome().toLowerCase().startsWith(id)) && !id.equals("")) {
                    builder.append("<employee>");
                    builder.append("<id>" + funcionario.getId() + "</id>");
                    builder.append("<firstName>" + funcionario.getNome() + "</firstName>");
                    builder.append("<lastName>" + funcionario.getSobrenome() + "</lastName>");
                    builder.append("</employee>");
                    flag = true;
                }
            }
            if(flag) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<employees>" + builder.toString() + "</employees>");
            } else {
                response.setStatus(204);
            }
        }
        if("lookupbyname".equals(action)) {
            // lista com os funcionarios encontrados que iniciam o nome com o valor digitado
            List funcionarios = new ArrayList();
            for (Funcionario funcionario: employees) {
                if(funcionario.getNome().toLowerCase().startsWith(id) || funcionario.getSobrenome().toLowerCase().startsWith(id))
                    funcionarios.add(funcionario);
            }
            if(funcionarios.size() > 0)
                request.setAttribute("funcionarios", funcionarios);
            context.getRequestDispatcher("/lista.jsp").forward(request, response);
        } else{
            if("lookup".equals(action)){
                // verifica na lista de funcionarios o funcionario selecionado
                if(id != null ){
                    for (Funcionario fun : employees) {
                        if(fun.getId().equals(id.trim())){
                            request.setAttribute("funcionario", fun);
                            break;
                        }
                    }
                    context.getRequestDispatcher("/funcionario.jsp").forward(request, response);
                } else {
                    context.getRequestDispatcher("/error.jsp").forward(request, response);
                }
                
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    
    
}
