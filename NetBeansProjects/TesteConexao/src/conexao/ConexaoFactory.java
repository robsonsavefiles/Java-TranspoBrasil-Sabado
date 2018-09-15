package conexao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/teste_conexao";

	static final String USER = "root";
	static final String PASS = "";
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

}