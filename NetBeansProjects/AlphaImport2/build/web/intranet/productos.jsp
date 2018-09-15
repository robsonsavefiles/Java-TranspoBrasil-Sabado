<%@page import="java.sql.ResultSet"%>
<%@page import="GestionBD.GestionBD"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/masterpages2.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AlphaImport</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../css/js/jquery-1.11.0.min.js" type="text/javascript"></script>
        
        <script type="text/javascript" src="bootstrap/js/jquery.js"></script>
        
        <script type="text/javascript">
            
            function eliminar(){
                if(confirm("confirma que desea eliminar producto")){
                    return true;
                }
                return false;
                
            }
            
        </script>
        



<link rel="stylesheet"  href="../planillas/estilo2.css"/>
</head>
<body style="background-color:#000">
<center>
<div id="contenedor">

    <div id="cabecera">
    	<div id="logo"></div>    	
        <div id="cliente"><a href="../index.jsp">Cerrar Sesion</a></div>
    </div>
    <div id="banner"></div>
    <div id="menu">
   	  <table>
        	<tr>
            	<td><a href="index.jsp">Inicio</a></td>
                <td><a href="productos.jsp">Productos</a></td>
                <td><a href="clientes.jsp">Clientes</a></td>
                <td><a href="contactos.jsp">Contactos</a></td>
                <td><a href="usuarios.jsp">Usuarios</a></td>
           		
            </tr>
        </table>
    </div>
    <div id="contenido">
    	<table width="960" border="0">
          <tr>
            <td><!-- InstanceBeginEditable name="EditRegion1" -->
              <table width="100%" border="0">
                <tr>
                    <td>
                      <table width="100%" border="0">  
                        <tr>
                    <td width="50%"></td>
                    <td width="50%">
                    	<form action="productos_nuevo.jsp" method="post">
                        	<input type="submit" class="btn-primary" value="Agregar" />
            
                        </form> 
                        
                                
                   <form action="productos_eliminar.jsp" class="form-horizontal" method="post" >         
                          <p>CODIGO:
              <label for="txtcodigo"></label>
              <input type="text" name="txtcodigo" id="txtcodigo" />
              <input type="submit" name="btneliminar" id="btneliminar" class="btn btn-success" value="Eliminar" onclick="return eliminar();"/>

                
                          
                          </p>
                   </form>     
                                
                       
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2">
                    
                        
                        <%
        try{
        out.print("<br>");    
        GestionBD og=new GestionBD(); //instanciando la clase
        og.conectar();//abrimos la conexion
        String sql="select IdProducto,Descripcion,Marca,Precio,Stock,nombre from productos p, categoria c where  p.idcategoria=c.codigo order by 1 asc ";
        ResultSet rs=og.cargaDatos(sql);
        //creamos la tabla y los titulos de la columna
        out.print("<table class='table' width=750 align=center> <tr bgcolor=#dfdfdf>"
                + "<th>IdProducto"
                + "<th>Descripcion"
                + "<th>Marca"
                + "<th>Precio"
                + "<th>Stock"
                               
                + "<th>Categoria");
        while(rs.next()){
            //ejecuta la primera fila
            out.print("<tr>");
            for(int i=1;i<=6;i++){
                //centramos los td  
                  out.print("<td> <div align=left>" + rs.getString(i) + "</div>");
            }
                
          
            out.print("</tr>");
        }
        out.print("</table>");
        og.desconectar();
        }
        catch(Exception e){
            out.println("<center><h1>No se a Cargado la base de datos</h1></center>");
        }
        %>
                        
                     </td>
                  </tr>
                </table>                  
                  </td>
                </tr>
              </table>
          <!-- InstanceEndEditable --></tr>
        </table>
    </div>
    <div id="separador"></div>
    <div id="pie"></div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
