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
import modelo.Pessoa;

/**
 *
 * @author 89087
 */
public class PessoaDAO {

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

   public List<Pessoa> buscarTodos() throws ClassNotFoundException, SQLException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {

            conectar();

            ResultSet rs = statement.executeQuery("SELECT * FROM pessoa1");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa = criarPessoa(rs);

                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return pessoas;
    }

    public Pessoa buscar(String rg) throws SQLException, ClassNotFoundException {
        conectar();
        Pessoa retorno = new Pessoa();

        ResultSet rs = statement.executeQuery("SELECT * FROM pessoa WHERE rg = '" + rg + "';");

        if (rs.next()) {
            retorno.setNome(rs.getString("nome"));
            retorno.setRg(rs.getString("rg"));

            desconectar();
            return retorno;
        } else {
            System.out.println("Pessoa não localizada");
            desconectar();
            return null;
        }
    }

    public Pessoa criarPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(rs.getString("nome"));
        pessoa.setRg(rs.getString("Rg"));

        return null;
    }

    public void remover(String rg) throws SQLException, ClassNotFoundException {
        try {
            conectar();
            statement.executeUpdate("DELETE FROM pessoa WHERE rg = '" + rg + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
            desconectar();
        }
        desconectar();
    }

    public void inserir(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        try {
            statement.executeUpdate("INSERT INTO Pessoa VALUES('" + "'" + pessoa.getRg() + ";" + "'" + pessoa.getNome() + "' )");
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectar();
    }

    public void alterar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        conectar();

        statement.executeUpdate("UPDATE pessoa SET "
                + "Rg =" + pessoa.getRg() + ","
                + "Nome =" + pessoa.getNome() + ","
                + "Where Rg =" + pessoa.getRg());

        desconectar();
    }

}
