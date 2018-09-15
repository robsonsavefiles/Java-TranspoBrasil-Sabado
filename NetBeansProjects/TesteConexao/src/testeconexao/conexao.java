package testeconexao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static testeconexao.Teste.JDBC_DRIVER;

/**
 *
 * @author 89087
 */
public class conexao {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/conexaolost";
    
    static final String USER="root";
    static final String PASS="";

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            
            String sql = "SELECT Rg,Nome From tabelapessoa";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                String rg = rs.getString("Rg");
                String nome = rs.getString("Nome");
                
                System.out.println(rg+ "  " + nome+ "\n\r");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
