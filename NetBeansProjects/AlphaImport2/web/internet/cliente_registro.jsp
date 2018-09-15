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
          <form id="form1" method="post" action="">
          <table width="30%" border="0" align="center">
          <tr>
            <td width="30%">ID</td>
            <td width="70%">
              <input type="text"  id="txtid" /></td>
          </tr>
          <tr>
            <td>Password</td>
            <td>
              <input type="password" id="txtpwd" />
            </td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input type="submit" id="btnIniciar" value="Iniciar Sesion" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
        </form>
        
          </td>
        </tr>
      </table>
      <%	        
            if(request.getParameter("txtid")!=null || request.getParameter("txtpwd")!=null ){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("id",request.getParameter("txtid"));
                sesion.setAttribute("pwd",request.getParameter("txtpwd"));
                GestionBD og=new GestionBD();
                og.conectar();
                String sql="Select * from clientes where idcliente='"+
                        sesion.getAttribute("id")+"' and ruc_dni='"+sesion.getAttribute("pwd")+"'";
                ResultSet rs=og.cargaDatos(sql);
                if(rs.next()){
                    og.desconectar();
                    response.sendRedirect("catalogo.jsp");
                    
                }else{
                    og.desconectar();
                    JOptionPane.showMessageDialog(null, "Acceso Denegado");
                }
                    
            }
        %>

    <!-- InstanceEndEditable --></div>
    <div id="separador"></div>
    <div id="pie"></div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
