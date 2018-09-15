package br.com.globalcode.servlets;

import br.com.globalcode.dao.ClientesDAO;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class CadastrarCliente extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("preencherCidades".equals(action)) {
            String estado = request.getParameter("estado");
            //Leitura da lista de cidades do BD
            List cidades = ClientesDAO.getInstance().getCidades(estado);
            if(cidades.size() > 0) {
                response.setContentType("text/xml");
                PrintWriter out = response.getWriter();
                out.write("<?xml version='1.0' ?>");
                out.write("<cidades>");
                for (Iterator it = cidades.iterator(); it.hasNext();){
                    Object elem = (Object) it.next();
                    out.write("<cidade>"+elem+"</cidade>");
                }
                out.write("</cidades>");
            }
        } else {
            //Codigo para cadastro de cliente no banco
        }
        System.out.println("Finalizando servlet");
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}