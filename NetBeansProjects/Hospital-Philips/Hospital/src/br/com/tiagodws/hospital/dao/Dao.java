package br.com.tiagodws.hospital.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public abstract class Dao {

    private Connection conn;
    private Statement statement;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void conectar() throws ClassNotFoundException, SQLException {
        conn = ConexaoFactory.getConexao();
        statement = conn.createStatement();
    }

    public void desconectar() {
        try {
            conn.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract String getTabela();

    public abstract List getTodos();

}
