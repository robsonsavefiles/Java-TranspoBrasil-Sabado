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
     <%
        try{
            String c=request.getParameter("txtcodigo");
            GestionBD og=new GestionBD(); //instanciando la clase
            og.conectar();//abrimos la conexion
            String sql="select * from productos where Idproducto = '" + c +"'"; 
            ResultSet rs=og.cargaDatos(sql);
            rs.next();            
        %>
      <table width="960" border="0">
        <tr>
          <td>
              <center>
        <form id="form1" name="form1" method="post" action="">
            <br>
            <br>
            <table width="60%" border="0">
              <tr>
                <td width="16%">codigo </td>
                <td width="30%"><label for="txtcodigo"></label>
                    <input type="text" value="<%=rs.getString(1)%>" readonly = "readonly" /></td>
                <td width="54%" rowspan="8"><%out.print("<img src=" + rs.getString(8) +" width=200 heigh = 200");%></td>
              </tr>
              <tr>
                <td>Descripcion</td>
                <td><label for="txtDescripcion"></label>
                  <input type="text" name="txtDescripcion" id="txtDescripcion" value="<%=rs.getString(2)%>" readonly = "readonly"/></td>
                </tr>
              <tr>
                <td>Marca</td>
                <td><input type="text" name="txtMarca" id="txtMarca" value="<%=rs.getString(3)%>" readonly = "readonly" /></td>
                </tr>
              <tr>
                <td>Precio</td>
                <td><input type="text" name="txtPrecio" id="txtPrecio" value="<%=rs.getString(4)%>" readonly = "readonly"/></td>
                </tr>
              <tr>
                <td>Stock</td>
                <td><input type="text" name="txtStock" id="txtStock" value="<%=rs.getString(5)%>" readonly = "readonly"/></td>
                </tr>
              <tr>
                <td>Categoria</td>
                <td><input type="text" name="txtCategoria" id="txtCategoria" value="<%=rs.getString(6)%>" readonly = "readonly"/></td>
              </tr>
                </form>
                <tr>
                    <td colspan="2">
                        <div align="center">
                            <form method="post" action="productos.jsp">
                                <input type="submit" value="Regresar">
                            </form>
                        </div>
                    </td>
                </tr>
            <%
               og.desconectar();
               }catch (Exception e){
               out.println("Debia ingresar un valor");
               }
            %>
            </table>
        </center>
          </td>
        </tr>
      </table>
    <!-- InstanceEndEditable --></div>
    <div id="separador"></div>
    <div id="pie"></div>
</div>
</center>
</body>
</html>
