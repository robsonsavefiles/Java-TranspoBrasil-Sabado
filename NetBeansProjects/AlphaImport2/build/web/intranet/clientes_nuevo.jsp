<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/masterpages2.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AlphaImport</title>

        <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../css/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    
        <script type="text/javascript">
 function nombre(fic) {
             fic = fic.split('\\');
           }
        function validar(){
            
          	if (document.form2.txt1.value.length==0){ 
      	alert("Tiene que escribir su codigo producto") 
      	document.form2.txt1.focus() 
       return false;
   	} 
        
        if (document.form2.txt2.value.length==0){ 
      	alert("Tiene que escribir su detalle") 
      	document.form2.txt2.focus() 
      return false;
   	} 
          if (document.form2.txt3.value.length==0){ 
      	alert("Tiene que escribir su marca") 
      	document.form2.txt3.focus() 
      	  return false;
   	} 
          if (document.form2.txt4.value.length==0){ 
      	alert("Tiene que escribir su precio") 
      	document.form2.txt4.focus() 
      	  return false;
   	} 
        
           if (document.form2.txt5.value.length==0){ 
      	alert("Tiene que escribir su precio") 
      	document.form2.txt5.focus() 
      	  return false;
   	}  
        
          if (document.form2.txt6.value.length==0){ 
      	alert("Tiene que escribir su stock") 
      	document.form2.txt6.focus() 
      	  return true;
   	} 
         
   	//el formulario se envia 
   	alert("Se guardo el registro del Nuevo Cliente"); 
   	document.form2.submit(); 
}        
        </script>



<link rel="stylesheet"  href="../planillas/estilo2.css"/>
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
                      <center>
                          <h1>  <p class="text-center">Agregar Clientes</p></h1>
                          
                      <form id="form2" name="form2" method="post" class="form-horizontal" action="clientes_insert.jsp" onsubmit="return validar();">
                    <table width="50%" border="0" align="center">
                      <tr>
                        <td>IdCliente:</td>
                        <td><label for="txt1"></label>
                          <input type="text" name="txt1" id="txt1" /></td>
                      </tr>
                      <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="txt2" id="txt2" /></td>
                      </tr>
                      <tr>
                        <td>Direccion:</td>
                        <td><input type="text" name="txt3" id="txt3" /></td>
                      </tr>
                      <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="txt4" id="txt4" /></td>
                      </tr>
                      
                       <tr>
                        <td>Ruc:</td>
                        <td><input type="text" name="txt5" id="txt5" /></td>
                      </tr>
                        
                        <tr>
                        <td>Imagen</td>
                        <td><input type="file" name="txt6" id="txt6" onchange="nombre(this.value)"/> </td>
                      </tr>
           
                      <tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="btnGuardar" id="btnGuardar" value="Guardar" class="btn btn-success" /></td>
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
