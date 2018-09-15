
package executor;

import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pessoa;

/**
 *
 * @author 89087
 */
public class Executor {
    
    public static void main(String[] args) {
       
        PessoaDAO pDAO = new PessoaDAO();
        Pessoa pessoa;
        try {
            pessoa = pDAO.buscar("439156944");
             System.out.println(pessoa.getNome());
        } catch (SQLException ex) {
            Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
    
}
    
    


