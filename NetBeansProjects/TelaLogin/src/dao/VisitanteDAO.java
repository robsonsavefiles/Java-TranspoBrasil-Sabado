/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paciente;
import modelo.Usuario;
import modelo.Visitante;


/**
 *
 * @author 89087
 */
public class VisitanteDAO {

    private Connection conn;
    private Statement statement;

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
        } catch (SQLException ex) {
            System.out.println("Problemas ao desconectar ao banco de dados");
        }
    }

    public List<Visitante> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Visitante> visitantes = new ArrayList<Visitante>();
        try {

            conectar();

            ResultSet rs = statement.executeQuery("SELECT * FROM visitante");
            while (rs.next()) {
              Visitante visitante = new Visitante();

                visitante = criarVisitante(rs);

                visitantes.add(visitante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteUtiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return visitantes;
    }

    public Visitante buscar(int id) throws SQLException, ClassNotFoundException {
        conectar();
        Visitante retorno = new Visitante();

        ResultSet rs = statement.executeQuery("SELECT * FROM visitante WHERE id = '" + id + "';");

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setIdpaciente(rs.getInt("idpaciente"));
            retorno.setNome(rs.getString("nome"));
            retorno.setStatus(rs.getString("status"));

            desconectar();
            return retorno;
        } else {
            System.out.println("Pessoa não localizada");
            desconectar();
            return null;
        }
    }

    public Visitante criarVisitante(ResultSet rs) throws SQLException {
        
        Visitante visitante = new Visitante();
        visitante.setId(rs.getInt("id"));
        visitante.setIdpaciente(rs.getInt("idpaciente"));       
        visitante.setNome(rs.getString("nome"));
        visitante.setStatus(rs.getString("status"));

        return null;
    }

    public void remover(String id) throws SQLException, ClassNotFoundException {
        try {
            conectar();
            statement.executeUpdate("DELETE FROM visitante WHERE id = '" + id + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
            desconectar();
        }
        desconectar();
    }

    public void inserir(Visitante visitante) throws ClassNotFoundException, SQLException {
        try {
            statement.executeUpdate("INSERT INTO visitante VALUES('" + "'" + visitante.getId()+ ";" + "'" +
                    visitante.getIdpaciente()+";"+visitante.getNome()+";"+","+visitante.getStatus()+";"+ "' )");
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    public void alterar(Visitante visitante) throws SQLException, ClassNotFoundException {
        conectar();

        statement.executeUpdate("UPDATE pessoa SET "
              
                + "'idpaciente '=" + visitante.getIdpaciente()+ ","
                + "'nome '=" + visitante.getNome()+ ","
                + "'status' =" + visitante.getStatus()+ ","
                
                + "Where id =" + visitante.getId());

        desconectar();
    }

}
