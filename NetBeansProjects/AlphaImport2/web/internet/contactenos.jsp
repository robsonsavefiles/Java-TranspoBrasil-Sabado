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
          <form name="form1" method="post" action="contactos_insert.jsp">
            <table width="70%" border="0" align="center">
              <tr>
                  <td colspan="3"><p><br>Si desea recibir informacion adicional sobre un determinado producto, realizar un pedido o enviar una sugerencia:Escriba sus datos en el siguiente formulario.</br><br/>
                  </p></td>
                </tr>
              <tr>
                <td rowspan="6"><div align="center"> <img src="../recursos/imagen01.jpg" width="400" height="400" align="middle" /></div></td>
                <td></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
                
            
              <tr>
                <td>Nombres:</td>
                <td><label for="txtNombre"></label>
                  <input type="text" name="txtNombre" id="txtNombre" /></td>
              </tr>
              <tr>
                <td>Telefono:</td>
                <td><label for="txtTelf"></label>
                  <input type="text" name="txtTelf" id="txtTelf" /></td>
              </tr>
              <tr>
                <td>Email:</td>
                <td><label for="txtEmail"></label>
                  <input type="text" name="txtEmail" id="txtEmail" /></td>
              </tr>
              <tr>
                <td>Comentario:</td>
                <td><label for="txtComentario"></label>
                  <textarea name="txtComentario" id="txtComentario" cols="45" rows="5"></textarea></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="btnEnviar" id="btnEnviar" value="Enviar" /></td>
              </tr>
               
            </table>
          </form>
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
