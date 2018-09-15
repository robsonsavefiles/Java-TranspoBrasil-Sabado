package GestionBD;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
public class GestionBD {
    //Implementar las interfaces
    public Connection cn;//obtiene la conexion a la BD
    public Statement st;//ejecuta la instruccion sql
    public ResultSet rs;//almasena resultados de la consulta
    public void conectar() throws SQLException{//throws muestra los errores
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/alphaimport","root","123");//nombre de la Bd,user,pass
            st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            
        }
    }
    
    public ResultSet cargaDatos(String sql)throws SQLException{
        rs=st.executeQuery(sql);
        return rs;
    }
    /*Metodo para actualizar los datos*/
    public void Actualizar(String sql)throws SQLException{
        st.executeUpdate(sql);/*Ejecuta insert ,update,delete*/
    }
    
    /*Metodo para cerrar conexion*/
    public void CerrarConex(String sql)throws SQLException{
        cn.close();
    }
    
    
    public void desconectar()throws SQLException{
        rs.close();
        cn.close();
    }
    
    public String idUser() throws SQLException{
        //aqui va le codigo
        String id=null;
        return id;
    }
    
    public GestionBD(){
        
    }
    
}
