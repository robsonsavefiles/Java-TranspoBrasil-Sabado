<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/masterpages.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AlphaImport</title>
<link rel="stylesheet"  href="planillas/estilo1.css"/>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../css/js/jquery-1.11.0.min.js" type="text/javascript"></script>
</head>
    <span id="liveclock" style=" position: fixed;left:0;top:4;"></span>
       <%-- Reloj   --%>
       <script language="JavaScript" type="text/javascript">
<!--

function show5(){
if (!document.layers&&!document.all&&!document.getElementById)
return;

 var Digital=new Date();
 var hours=Digital.getHours();
 var minutes=Digital.getMinutes();
 var seconds=Digital.getSeconds();

var dn="PM";
if (hours<12)
dn="AM";
if (hours>12)
hours=hours-12;
if (hours==0)

hours=12;

 if (minutes<=9)
 minutes="0"+minutes;
 if (seconds<=9)
 seconds="0"+seconds;
//change font size here to your desire
myclock="<font size='5' face='Arial' ><b>"+hours+":"+minutes+":"+seconds+" "+dn+"</b></font>";
if (document.layers){
document.layers.liveclock.document.write(myclock);
document.layers.liveclock.document.close();
}
else if (document.all)
liveclock.innerHTML=myclock;
else if (document.getElementById)
document.getElementById("liveclock").innerHTML=myclock;
setTimeout("show5()",1000);
 }


window.onload=show5;
 //-->
 </script>
 
    <script type="text/javascript">
        img = new Array(); 
img.push('/bootstrap/img/lapt1.jpg'); 
img.push('bootstrap/img/lapt.jpg'); 
img.push('bootstrap/img/monitor.jpg'); 
       
       
    index = 0; 
function altBg(){ 
document.body.style.backgroundImage = 'url(' + img[index % img.length] + ')'; 
index++; 
} 
window.onload = function(){ 
setInterval('altBg()', 2000); 
// 5000 milisegundos equivalente a 5 segundos; 
}; 
    
    </script>
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
                    <td><a href="index.jsp">Inicio</a></td>
                <td><a href="internet/empresa.jsp">Empresa</a></td>
                <td><a href="internet/ubicacion.jsp">Ubicaci&oacute;n</a></td>
                <td><a href="internet/productos.jsp">Productos</a></td>
                <td><a href="internet/catalogo.jsp">Cat&aacute;logo</a></td>
                <td><a href="internet/clientes.jsp">Clientes</a></td>
                <td><a href="internet/contactenos.jsp">Cont&aacute;ctenos</a></td>
                <td><a href="internet/intranet.jsp">Intranet</a></td>
            </tr>
        </table>
    </div>
    <div id="contenido"><!-- InstanceBeginEditable name="EditRegion1" -->
      <table width="960" border="0">
        <tr>
          <td><table width="100%" border="0">
      <tr>
          <td align="center"><h1><p class="text-center">
                      <marquee  scrolldelay="1" scrollamount="2" direction="left" loop="infinite" onmouseout="this.start()" onmouseover="this.stop()">Bienvenidos a Alpha Import S.A.</marquee></p></h1></td>
      </tr>
      <tr>
        <td align="center"><img src="recursos/imagen01.jpg" width="500" height="350" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    </td>
        </tr>
      </table>
    <!-- InstanceEndEditable --></div>
    <div id="separador"></div>
    <div id="pie">
        
    </div>
</div>
</center>
</body>
<!-- InstanceEnd --></html>
