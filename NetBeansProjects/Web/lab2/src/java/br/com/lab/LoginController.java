package br.com.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 89087
 */
@WebServlet(name = "LoginController", urlPatterns = {"/api/login"})
public class LoginController extends HttpServlet {

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

        String credencial = lerCredenciais(request);

        if (temParametro(credencial, "\"email\":\"robinho@teste.com\"")
                && temParametro(credencial, "\"senha\":\"r\"")) {
            response.setContentType("\"application/json;charset=UTF-8\"");
            try (PrintWriter out = response.getWriter()) {
                out.println(criarJson("Robinho", "robinho@teste.com", "ADM"));
            }
        } else {
            response.sendError(401);
        }
    }

    public LoginController() {
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
        processRequest(request, response);
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

    private String lerCredenciais(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        Scanner teclado = new Scanner(inputStream);
        String credencial = "";

        while (teclado.hasNextLine()) {
            credencial += teclado.nextLine();
        }
        System.out.println("LOG ==> Credencial Lida");
        System.out.println("LOG ==> Credencial ==> " + credencial);
        return credencial;
    }

    private boolean temParametro(String credencial, String parametro) {
        boolean resultado = credencial.contains(parametro);
        return resultado;
    }

    public String criarJson(String usuario, String email, String tipo) {
        StringBuilder out = new StringBuilder();
        out.append("{");
        out.append("\"nome\": \"").append(usuario).append("\",");
        out.append("\"email\": \"").append(email).append("\",");
        out.append("\"rule\": \"").append(tipo).append("\"");
        out.append("}");
        return out.toString();
    }
}
