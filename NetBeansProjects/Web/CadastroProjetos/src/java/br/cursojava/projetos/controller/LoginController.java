package br.cursojava.projetos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.cursojava.model.Credencial;
import br.cursojava.model.Usuario;
import br.cursojava.projetos.repositorio.UsuarioRepositorio;

/**
 *
 * @author 89087
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private final ObjectMapper json = new ObjectMapper();
    private final UsuarioRepositorio repositorio = UsuarioRepositorio.getInstance();
    private final Class<Credencial> clazz = Credencial.class;

    protected void efetuarLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Credencial obj = null;

        try {
            obj = json.readValue(req.getInputStream(), clazz);
        } catch (Exception ex) {
            System.out.println("Falha ao desserializar " + clazz.getName());
        }

        if (obj == null) {
            resp.sendError(401, "dados incorretos");
        } else {
            Usuario usuario = repositorio.efetuarLogin(obj);
            String jsonEntidade = json.writeValueAsString(usuario);
            resp.setContentType("application/json");
            resp.getWriter().print(jsonEntidade);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        efetuarLogin(req, resp);
    }

}
