/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import dados.Paciente;
import estado.Situacao;
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
public class PacienteDAO {

    private static final String TABELA = "paciente";

    private Connection conn;
    private Statement stmt;

    public void salvar(Paciente paciente) {
        if (paciente == null) {
            return;
        }

        try {
            if (paciente.getId() == null) {
                inserir(paciente);
            } else {
                alterar(paciente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<Paciente>();
        try {

            conectar();

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABELA);
            while (rs.next()) {
                Paciente paciente = new Paciente();

                paciente = criaPaciente(rs);

                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return pacientes;
    }

    public Paciente criaPaciente(ResultSet rs) {
        Paciente paciente = new Paciente();

        try {
            paciente.setId(rs.getLong("id"));
            paciente.setSituacao(Situacao.valueOf("situacao"));
            paciente.setNome(rs.getString("nome"));
            paciente.setDataEntrada(rs.getDate("data_entrada"));
            paciente.setDataSaida(rs.getDate("data_saida"));
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return paciente;
    }

    public void removerUsuario(Long id) {
        conectar();

        try {
            stmt.executeQuery("DELETE FROM " + TABELA + " WHERE id = " + id);
        } catch (SQLException ex) {
            //desconectar();
        }
        desconectar();
    }

    public void inserir(Paciente p) throws SQLException {
        conectar();

        stmt.executeQuery("INSERT INTO " + TABELA + " VALUES("
                + "'" + p.getSituacao() + "'"
                + "'" + p.getNome() + "'"
                + "'" + p.getProcedimento() + "',"
                + "'" + p.getDataEntrada() + "'"
                + "'" + p.getDataSaida() + "')");

        desconectar();
    }

    public void alterar(Paciente p) {
        conectar();

        try {
            stmt.executeQuery("UPDATE pessoa1 SET situacao='" + p.getSituacao() + "',nome ='" + p.getNome() + "', procedimento ='" + p.getProcedimento()
                    + "',data_entrada ='" + p.getDataEntrada() + "', data_saida ='" + p.getDataSaida()
                    + "' WHERE id = " + p.getId());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
    }

    public Paciente getPorID(long id) {
        Paciente paciente;

        conectar();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM " + TABELA + " WHERE id = " + id + "");

            if (rs.next()) {
                paciente = criaPaciente(rs);
                return paciente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return null;

    }

}
