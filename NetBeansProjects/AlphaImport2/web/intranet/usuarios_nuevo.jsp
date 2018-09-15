<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/masterpages2.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AlphaImport</title>
<link rel="stylesheet"  href="../planillas/estilo2.css"/>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../css/js/jquery-1.11.0.min.js" type="text/javascript"></script>
</head>
<body>
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
            	<td><a href="index.jsp">Inicio</a>
                <td><a href="productos.jsp">Productos</a>
                <td><a href="clientes.jsp">Clientes</a>
                <td><a href="contactos.jsp">Contactos</a>
                <td><a href="usuarios.jsp">Usuarios</a>
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
                      <center>
                      <form id="form1" name="form1" method="post" action="usuarios_insert.jsp">
                    <table width="50%" border="0" align="center">
                      <tr>
                        <td>IdUsuario</td>
                        <td><label for="txt1"></label>
                          <input type="text" name="txt1" id="txt1" /></td>
                      </tr>
                      <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="txt2" id="txt2" /></td>
                      </tr>
                      <tr>
                        <td>Alias</td>
                        <td><input type="text" name="txt3" id="txt3" /></td>
                      </tr>
                      <tr>
                        <td>Password</td>
                        <td><input type="password" name="txt4" id="txt4" /></td>
                      </tr>
                      <tr>
                        <td>Perfil</td>
                        <td><label for="cboPerfil"></label>
                          <select name="cboPerfil" id="cboPerfil">
                            <option value="ADM">ADMINISTRADOR</option>
                            <option value="OPE">OPERADOR</option>
                        </select></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" /></td>
                      </tr>
                    </table>
                  </form>
                  </center>
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
