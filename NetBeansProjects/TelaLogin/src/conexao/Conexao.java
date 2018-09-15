
package conexao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author 89087
 */
public class Conexao {
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
      static final String DB_URL = "jdbc:mysql://localhost/conexaolost";

      static final String USER = "root";
      static final String PASS = "";
        
      public static java.sql.Connection getConexao() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

}
