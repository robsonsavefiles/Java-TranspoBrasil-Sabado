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

/**
 *
 * @author 89087
 */
public class PacienteUtiDAO {

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

   public List<Paciente> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try {

            conectar();

            ResultSet rs = statement.executeQuery("SELECT * FROM paciente_uti");
            while (rs.next()) {
                Paciente paciente = new Paciente();

                paciente = criarPaciente(rs);

                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteUtiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return pacientes;
    }

    public Paciente buscar(String id) throws SQLException, ClassNotFoundException {
        conectar();
        Paciente retorno = new Paciente();

        ResultSet rs = statement.executeQuery("SELECT * FROM paciente_uti WHERE id = '" + id+ "';");

        if (rs.next()) {
            retorno.setId(rs.getString("id"));
            retorno.setSituacao(rs.getString("situacao"));
            retorno.setNome(rs.getString("nome"));
            retorno.setProcedimento(rs.getString("procedimento"));
            retorno.setDataEntrada(rs.getDate("data_entrada"));
            retorno.setDatasaida(rs.getDate("data_saida"));
            desconectar();
            return retorno;
        } else {
            System.out.println("Paciente não localizado");
            desconectar();
            return null;
        }
    }

    public Paciente criarPaciente(ResultSet rs) throws SQLException {
        
        Paciente paciente = new Paciente();
        paciente.setId(rs.getString("id"));
        paciente.setSituacao(rs.getString("situacao"));
        paciente.setNome(rs.getString("nome"));
        paciente.setProcedimento(rs.getString("procedimento"));
        paciente.setDataEntrada(rs.getDate("data_entrada"));
        //paciente.getDatasaida(rs.getDate("data_saida"));
        
    
        return null;
    }

    public void remover(String id) throws SQLException, ClassNotFoundException {
        try {
            conectar();
            statement.executeUpdate("DELETE FROM pessoa WHERE id = '" + id + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
            desconectar();
        }
        desconectar();
    }

    public void inserir(Paciente paciente) throws ClassNotFoundException, SQLException {
        try {
            statement.executeUpdate("INSERT INTO paciente_uti VALUES('" + "'" + paciente.getId()+ ";" + "'" + paciente.getNome() + "' )");
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteUtiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    public void alterar(Paciente pessoa) throws SQLException, ClassNotFoundException {
        conectar();

        statement.executeUpdate("UPDATE paciente_uti SET "
                + "id=" + pessoa.getId()+ ","
                + "Nome =" + pessoa.getNome() + ","
                + "Procedimento="+pessoa.getProcedimento()+ ","
                + "data_entrada ="+pessoa.getDataEntrada()+","
                + "data_saida ="+pessoa.getDatasaida()+","
                + "Where id =" + pessoa.getId());

        desconectar();
    }

}
