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
          <td><table width="100%" border="0">
      <tr>
          <td><center><font color="blue" size="5"><b><h3><p class="text-center">Cat&aacute;logo</p></h3></b></font></center></td>
      </tr>
      <tr>
        <td>
            <%
                
                try{
		GestionBD og=new GestionBD();
                og.conectar();
                String sql="select imagen,idproducto,descripcion,precio from productos order by 2 asc";
                ResultSet rs=og.cargaDatos(sql);
                out.println("<table align=center width=800><tr>");
                int col=0;
                while(rs.next()){
                    String a,b,c,d ;
                    a=rs.getString(1) ;
                    b=rs.getString(2) ;
                    c=rs.getString(3) ;
                    d=rs.getString(4) ;
                    out.println("<td align=center> <img src=" +a + " width=150 height=150>"
                            + "<br><b>" + b + "</b>"
                            + "<br>" + c
                            + "<br><font color=red size=3><b>S/." + d
                            + "</b></font>"
                            + "<br><a href=catalogo_detalles.jsp?id="+b+"&pp="+d+"><img src=../recursos/ver.png></a></td>");
                    col++;
                    if(col==4){
                        out.println("</tr>");
                        col=0;
                    }
                }
                out.println("</table>");
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
    <!-- InstanceEndEditable --></div>
    <div id="separador"></div>
    <div id="pie"></div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
