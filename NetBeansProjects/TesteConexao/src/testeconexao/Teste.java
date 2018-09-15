package testeconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/teste_conexao";

	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conectado");

			stmt = conn.createStatement();

			String sql = "SELECT rg, nome FROM pessoa";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String rg = rs.getString("rg");
				String nome = rs.getString("nome");

				System.out.println("-----------");
				System.out.println("RG: " + rg);
				System.out.println("Nome: " + nome);
				System.out.println("");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
