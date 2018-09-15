<%@page import="java.sql.ResultSet"%>
<%@page import="GestionBD.GestionBD"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/masterpages.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AlphaImport</title>
<link rel="stylesheet"  href="../planillas/estilo1.css"/>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../css/js/jquery-1.11.0.min.js" type="text/javascript"></script>
</head>
<body>
<center>
<div id="contenedor">

    <div id="cabecera">
    	<div id="logo"></div>    	
        <div id="cliente"></div>
    </div>
    <div id="banner"></div>
    <div id="menu">
   	  <table>
        	<tr>
            	<td><a href="../index.jsp">Inicio</a>
                <td><a href="empresa.jsp">Empresa</a>
                <td><a href="ubicacion.jsp">Ubicaci&oacute;n</a>
                <td><a href="productos.jsp">Productos</a>
                <td><a href="catalogo.jsp">Cat&aacute;logo</a>
                <td><a href="clientes.jsp">Clientes</a>
                <td><a href="contactenos.jsp">Cont&aacute;ctenos</a>
                <td><a href="intranet.jsp">Intranet</a>
            </tr>
        </table>
    </div>
    <div id="contenido"><!-- InstanceBeginEditable name="EditRegion1" -->
      <table width="960" border="0">
        <tr>
          <td>
<%
              try{
        out.print("<br>");    
        GestionBD og=new GestionBD(); //instanciando la clase
        og.conectar();//abrimos la conexion
        String sql="SELECT imagen,p.idproducto,cantidad,descripcion ,c.precio,cantidad*c.precio importe "+
                 "from productos p inner join carrito c on p.idproducto=c.idproducto";
        ResultSet rs=og.cargaDatos(sql);
        //creamos la tabla y los titulos de la columna
        out.print("<table width=80% align=center> <tr bgcolor=#dfdfdf>"
                + "<th>Imagen"
                + "<th>Idproducto"
                + "<th>Cantidad"
                + "<th>Descripcion"
                + "<th>Precio"
                + "<th>Importe</tr>");
                
        while(rs.next()){
            //ejecuta la primera fila
            out.print("<tr>");
            for(int i=1;i<=6;i++){
                //centramos los td  
                if(i==1){
                    //llamamos a la imagen
                    out.print("<td> <div align='center'><img src=" + rs.getString(i) + 
                            " width=75 height=75> </div>");
                }else if (i==5){
                    out.print("<td> <div align='center'> S/" + rs.getString(i) + "</div>");
                }else if (i==6){
                    out.print("<td> <div align='right'> S/" + rs.getString(i) + "</div>");
                }else{
                    out.print("<td> <div align='center'>" + rs.getString(i) + "</div>");
                }
            }
            out.print("</tr>");
        }
        rs=null;
        String sum="select sum(precio) from carrito";
        rs=og.cargaDatos(sum);
        while(rs.next()){
            out.print("<tr><td colspan=6><div align='right'> Total: S/. " + rs.getString(1) + "</div></td></tr>");
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
    <!-- InstanceEndEditable --></div>
    <div id="separador"></div>
    <div id="pie"></div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
