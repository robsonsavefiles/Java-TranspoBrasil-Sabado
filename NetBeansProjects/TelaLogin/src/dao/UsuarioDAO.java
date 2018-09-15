/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import cadastro_hospital.TiposDeUsuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;


/**
 *
 * @author 89087
 */
public class UsuarioDAO {

    private Connection conn;
    private Statement statement;

    private static final String TABELA = "usuario";

    private void conectar() throws ClassNotFoundException, SQLException {
        try {
            conn = Conexao.getConexao();
            statement = conn.createStatement();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar ao banco de dados");
        }
    }

    private void desconectar() throws SQLException {
        try {
            conn.close();
            statement.close();
        }catch (SQLException ex){
            System.out.println("Problemas ao desconectar ao banco de dados");
        }
    }

    public List<Usuario> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conectar();

            ResultSet rs = statement.executeQuery("SELECT * FROM" + TABELA);
            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario = criarUsuario(rs);

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return usuarios;
    }

    public Usuario buscar(String rg) throws SQLException, ClassNotFoundException {
        conectar();
        Usuario retorno = new Usuario();

        ResultSet rs = statement.executeQuery("SELECT * FROM usuario WHERE rg = '" + rg + "';");

        if (rs.next()) {
            retorno.setId(rs.getLong("id"));//
            retorno.setLogin(rs.getString("login"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setTipo(TiposDeUsuario.valueOf(rs.getString("tipo")));

            desconectar();
            return retorno;
        } else {
            System.out.println("Pessoa não localizada");
            desconectar();
            return null;
        }
    }

    public Usuario criarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setTipo(TiposDeUsuario.valueOf(rs.getString("tipo")));

        return usuario;
    }

    public void remover(String id) throws SQLException, ClassNotFoundException {
        try {
            conectar();
            
            statement.executeQuery("DELETE FROM " + TABELA + " WHERE id = " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            desconectar();
        }
        desconectar();
    }

    public void inserir(Usuario usuario) throws ClassNotFoundException, SQLException {
        conectar();
        try {
            statement.executeUpdate("INSERT INTO " + TABELA + "(login,senha,tipo) VALUES("
                    + "'" + usuario.getLogin() + "',"
                    + "'" + usuario.getSenha() + "',"
                    + "'" + usuario.getTipo() + "')");
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    public void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
        conectar();

        statement.executeUpdate("UPDATE pessoa1 SET login='" + usuario.getLogin() + "',senha ='" + usuario.getSenha() + "', tipo ='" + usuario.getTipo()
                + "' WHERE id = " + usuario.getId());

        desconectar();
    }

    public Usuario validarLogin(String login, String senha) throws SQLException, ClassNotFoundException {

        Usuario usuario = new Usuario();
        conectar();
        try {
            
            ResultSet rs;
         
            rs = statement.executeQuery("SELECT * FROM " + TABELA + " WHERE login = '" + login + "'");
            if (rs.next()) {
                usuario = criarUsuario(rs);

                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void salvar(Usuario usuario) throws SQLException, ClassNotFoundException {
        if (usuario == null) {
            return;
        }

        if(usuario.getId() == null){
            try {
                inserir(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alterar(usuario);
        }

    }

}
