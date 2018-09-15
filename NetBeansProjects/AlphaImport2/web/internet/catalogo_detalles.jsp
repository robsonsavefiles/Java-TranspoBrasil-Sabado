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
	  HttpSession sesion = request.getSession(true);
          
            String c=request.getParameter("id");
            String p=request.getParameter("pp");
            sesion.setAttribute("s_id", c);
            sesion.setAttribute("s_pp", p);
            GestionBD og=new GestionBD(); //instanciando la clase
            og.conectar();//abrimos la conexion
            String sql="SELECT  `IdProducto`,`Descripcion`,`Marca`,`Precio`,`Stock`,Nombre,imagen "+
                    "from productos p inner join categoria c on p.idcategoria=c.codigo where"+
                    " idproducto='"+c+"'"; 
            ResultSet rs=og.cargaDatos(sql);
            rs.next(); 
            
	 String i,d,m,pr,s,cc,im;
	 i=rs.getString(1);
         d=rs.getString(2);
         m=rs.getString(3);
         pr=rs.getString(4);
         s=rs.getString(5);
         cc=rs.getString(6);
         im=rs.getString(7);
        
         
         og.desconectar();
	 %>
          <br />
     
      <table width="960" border="0">
        <tr>
          <td>
            <table width="40%" border="0" align="center">
              <tr>
                <td width="50%">Codigo;</td>
                <td width="50%"><%out.print(i);%></td>
              </tr>
              <tr>
                <td>Descripcion:</td>
                <td><%out.print(d);%></td>
              </tr>
              <tr>
                <td>Marca:</td>
                <td><%out.print(m);%></td>
              </tr>
              <tr>
                <td>Precio:</td>
                <td><%out.print(pr);%></td>
              </tr>
              <tr>
                <td>Stock:</td>
                <td><%out.print(s);%></td>
              </tr>
              <tr>
                <td>Categoria</td>
                <td><%out.print(cc);%></td>
              </tr>
              <tr>
            <td colspan="2"><div align="center">
			<%out.print("<img src="+im+" width=200 height=200>");%></div>
            </td>
              </tr>
              <tr>
                <td colspan="2"><form id="form1" name="form1" method="post" action="carrito_insert.jsp">
                  <table width="30%" border="0" align="center">
                    <tr>
                      <td>Cantidad </td>
                      <td><label for="txtcantidad"></label>
                        <input name="txtcantidad" type="text" id="txtcantidad" value="1" size="10" /></td>
                      <td><input type="submit" name="btnadd" id="btnadd" value="Agregar al carrito" /></td>
                    </tr>
                  </table>
                </form></td>
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
