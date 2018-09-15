/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import dados.Usuario;
import estado.Tipo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class UsuarioDAO {

    private static final String TABELA = "usuario";
    private static UsuarioDAO dao;

    private UsuarioDAO() {
    }
    
    public static UsuarioDAO getInstance(){
        if (dao == null) {
            dao = new UsuarioDAO();
        }
        return dao;
    }

    public Usuario validarLogin(String login, String senha) {
        Usuario usuario = new Usuario();
        conectar();
        try {

            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM " + TABELA + " WHERE login = '" + login + "'");

            if (rs.next()) {
                usuario = criaUsuario(rs);

                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void salvar(Usuario usuario) {
       
        if (usuario == null) {
            return;
        }

        if (usuario.getId() == null) {
            try {
                inserir(usuario);
               
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            alterar(usuario);
            
        }

    }

    private Connection conn;
    private Statement stmt;

    public void conectar() {
        try {
            conn = Conexao.getConnection();
            stmt = conn.createStatement();

        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas ao conectar ao banco de dados");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problemas ao desconectar no banco de dados");
        }
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList();
        try {

            conectar();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABELA);
            while (rs.next()) {
                Usuario usuario = criaUsuario(rs);

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return usuarios;
    }

    public Usuario criaUsuario(ResultSet rs) {
        Usuario usuario = new Usuario();

        try {
            usuario.setId(rs.getLong("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setTipo(Tipo.valueOf(rs.getString("tipo")));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return usuario;
    }

    public void removerUsuario(Usuario usuario) {
        conectar();

        try {
            stmt.executeUpdate("DELETE FROM " + TABELA + " WHERE id = " + usuario.getId());
        } catch (SQLException ex) {
            //desconectar();
        }
        
        desconectar();
    }

    public void inserir(Usuario p) throws SQLException {
        conectar();

        stmt.executeUpdate("INSERT INTO " + TABELA + "(login,senha,tipo) VALUES("               
                + "'" + p.getLogin() + "',"
                + "'" + p.getSenha() + "',"
                + "'" + p.getTipo() + "')");

        desconectar();
    }

    public void alterar(Usuario p) {
        conectar();

        try {
            stmt.executeUpdate("UPDATE pessoa1 SET login='" + p.getLogin() +  "',senha ='" + p.getSenha() + "', tipo ='" + p.getTipo()
                    + "' WHERE id = " + p.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }
}
