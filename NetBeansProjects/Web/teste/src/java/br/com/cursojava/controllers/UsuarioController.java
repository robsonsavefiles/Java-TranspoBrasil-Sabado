/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cursojava.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 66463
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuarios", "/usuarios/credenciais"})
public class UsuarioController extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    private UsuarioRepositorio repositorio = new UsuarioRepositorio();

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
            out.println("<title>Servlet UsuarioController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
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
        if ("/usuarios/credenciais".equals(path)) {

            autenticar(request, response);
            
        } else {
            
            adicionar(request, response);
            
        }

    }

    private void adicionar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = null;
        try {
            usuario = mapper.readValue(request.getInputStream(), Usuario.class);
        } catch (Exception e) {
            System.out.println("Falha ao Deserializar o Usuário");
        }
        if (usuario == null) {
            response.sendError(401);
        } else if (usuario.getId() != null) {
            response.sendError(406);
        } else {
            usuario = repositorio.salvar(usuario);
            String resultado = mapper.writeValueAsString(usuario);
            response.setContentType("application/json");
            response.getWriter().print(resultado);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = null;
        try {
            usuario = mapper.readValue(request.getInputStream(), Usuario.class);
        } catch (Exception e) {
            System.out.println("Falha ao Deserializar o Usuário");
        }
        if (usuario == null) {
            response.sendError(401);
        } else if (usuario.getId() == null) {
            response.sendError(406);
        } else {
            Usuario local = repositorio.buscarPorId(usuario.getId());
            if (local == null) {
                response.sendError(406, "Usuário não Existe");
            } else {
                usuario = repositorio.salvar(usuario);
                String resultado = mapper.writeValueAsString(usuario);
                response.setContentType("application/json");
                response.getWriter().print(resultado);
            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = null;
        try {
            usuario = mapper.readValue(request.getInputStream(), Usuario.class);
        } catch (Exception e) {
            System.out.println("Falha ao Deserializar o Usuário");
        }

        if (repositorio.remover(usuario)) {
            response.getWriter().print("Usuário removio com Sucesso!");
        } else {
            response.sendError(406, "Falha ao remover usuário");
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

    private void autenticar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Credencial credencial = null;
        try {
            credencial = mapper.readValue(request.getInputStream(), Credencial.class);
        } catch (Exception e) {
            System.out.println("Falha ao Deserializar o Usuário");
        }
        
        if(credencial == null){
            response.sendError(401);
        }else{
        
        Usuario usuario = repositorio.buscarPorEmail(credencial.getEmail());
        
        if(usuario != null && credencial.getSenha().equals(usuario.getSenha())){
            String json = mapper.writeValueAsString(usuario);
            response.setContentType("application/json");
            response.setStatus(200);
            response.getWriter().print(json);
        }else{
            response.sendError(401, "Usuario ou senha incorretos");
        }
        }
        
    }

}
