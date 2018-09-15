<%@page import="javax.swing.JOptionPane"%>
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
     <table width="100%" border="0">
      <tr>
        <td><p><h3><p class="text-center">Listado de Productos</p></h3> </p>
          <form id="form2" name="form2" method="post" action="categoria_consulta.jsp">
            Categoria:
            <label for="cbocategoria"></label>
            <select name="cbocategoria" id="cbocategoria" class="form-control">
                <option selected></option>
                <%
                    try{
                    out.println("<br>");
                    GestionBD og=new GestionBD(); //instanciando la clase
                    og.conectar();//abrimos la conexion
                    String cod="";
                    String sql="select codigo,nombre from categoria";
                    ResultSet rs=og.cargaDatos(sql);
                    while(rs.next()){
                        //ejecuta la primera fila
                        out.print("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");
                        cod=rs.getString(1);
                    }
                    }catch(Exception e){

                    }
                %>
            </select>
            <input type="submit" name="btncategoria" id="btncategoria" class="btn btn-primary" value="Consultar" />
          </form>
        </td>
      </tr>
      <tr>
        <td>
        <%
        try{
        out.print("<br>");    
        GestionBD og=new GestionBD(); //instanciando la clase
        og.conectar();//abrimos la conexion
        String sql="select IdProducto,Descripcion,Marca,Precio,Stock,nombre,imagen from productos p, categoria c where  p.idcategoria=c.codigo order by 1 asc ";
        ResultSet rs=og.cargaDatos(sql);
        //creamos la tabla y los titulos de la columna
        out.print("<table class='table' width=750 align=center> <tr bgcolor=#dfdfdf>"
                + "<th>Codigo"
                + "<th>Descripcion"
                + "<th>Marca"
                + "<th>Precio"
                + "<th>Stock"
                + "<th>Categoria"
                + "<th>Imagen</tr>");
        while(rs.next()){
            //ejecuta la primera fila
            out.print("<tr>");
            for(int i=1;i<=7;i++){
                //centramos los td  
                if(i==7){
                    //llamamos a la imagen
                    out.print("<td> <div align=left><img src=" + rs.getString(i) + 
                            " width=75 height=75> </div>");
                }else{
                    out.print("<td> <div align=left>" + rs.getString(i) + "</div>");
                }
            }
            out.print("</tr>");
        }
        out.print("</table>");
        og.desconectar();
        }
        catch(Exception e){
            //out.println("<center><h1>No se a Cargado la base de datos</h1></center>");
        }
        %>  
        </td>
      </tr>
    </table>

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
