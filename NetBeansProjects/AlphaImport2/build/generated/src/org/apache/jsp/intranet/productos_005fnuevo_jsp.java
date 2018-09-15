package org.apache.jsp.intranet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productos_005fnuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages2.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>AlphaImport</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/jquery.js\"></script>\r\n");
      out.write("      \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function nombre(fic) {\r\n");
      out.write("             fic = fic.split('\\\\');\r\n");
      out.write("             alert(fic[fic.length-1]);\r\n");
      out.write("           }\r\n");
      out.write("        function validar(){\r\n");
      out.write("            \r\n");
      out.write("          \tif (document.form1.txt1.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que escribir su codigo producto\") \r\n");
      out.write("      \tdocument.form1.txt1.focus() \r\n");
      out.write("       return false;\r\n");
      out.write("   \t} \r\n");
      out.write("        \r\n");
      out.write("        if (document.form1.txt2.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que escribir su detalle\") \r\n");
      out.write("      \tdocument.form1.txt2.focus() \r\n");
      out.write("      return false;\r\n");
      out.write("   \t} \r\n");
      out.write("          if (document.form1.txt3.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que escribir su marca\") \r\n");
      out.write("      \tdocument.form1.txt3.focus() \r\n");
      out.write("      \t  return false;\r\n");
      out.write("   \t} \r\n");
      out.write("          if (document.form1.txt4.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que escribir su precio\") \r\n");
      out.write("      \tdocument.form1.txt4.focus() \r\n");
      out.write("      \t  return false;\r\n");
      out.write("   \t} \r\n");
      out.write("          if (document.form1.txt5.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que escribir su stock\") \r\n");
      out.write("      \tdocument.form1.txt5.focus() \r\n");
      out.write("      \t  return false;\r\n");
      out.write("   \t} \r\n");
      out.write("          if (document.form1.txt6.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que agregar Imagen\") \r\n");
      out.write("      \tdocument.form1.txt6.focus() \r\n");
      out.write("      \t  return false;\r\n");
      out.write("   \t} \r\n");
      out.write("            if (document.form1.cbcat.value.length==0){ \r\n");
      out.write("      \talert(\"Tiene que agregar Categoria\") \r\n");
      out.write("      \tdocument.form1.cbcat.focus() \r\n");
      out.write("      \t  return true;\r\n");
      out.write("   \t} \r\n");
      out.write("   \r\n");
      out.write("   \t//el formulario se envia \r\n");
      out.write("   \talert(\"Se guardo el registro del Nuevo Producto\"); \r\n");
      out.write("   \tdocument.form1.submit(); \r\n");
      out.write("}        \r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo2.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<div id=\"contenedor\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"cabecera\">\r\n");
      out.write("    \t<div id=\"logo\"></div>    \t\r\n");
      out.write("        <div id=\"cliente\"><a href=\"../index.jsp\">Cerrar Sesion</a></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"banner\"></div>\r\n");
      out.write("    <div id=\"menu\">\r\n");
      out.write("   \t  <table>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("            \t<td><a href=\"index.jsp\">Inicio</a>\r\n");
      out.write("                <td><a href=\"productos.jsp\">Productos</a>\r\n");
      out.write("                <td><a href=\"clientes.jsp\">Clientes</a>\r\n");
      out.write("                <td><a href=\"contactos.jsp\">Contactos</a>\r\n");
      out.write("                <td><a href=\"usuarios.jsp\">Usuarios</a>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contenido\">\r\n");
      out.write("    \t<table width=\"960\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><!-- InstanceBeginEditable name=\"EditRegion1\" -->\r\n");
      out.write("              <table width=\"100%\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td>\r\n");
      out.write("                      <center>\r\n");
      out.write("                      <form id=\"form1\" name=\"form1\" method=\"post\" action=\"productos_insert.jsp\" onsubmit=\"return validar();\">\r\n");
      out.write("                    <table width=\"50%\" border=\"0\" align=\"center\">\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>IdProducto</td>\r\n");
      out.write("                        <td><label for=\"txt1\"></label>\r\n");
      out.write("                          <input type=\"text\" name=\"txt1\" id=\"txt1\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Detalle</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt2\" id=\"txt2\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Marca</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt3\" id=\"txt3\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Precio</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt4\" id=\"txt4\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      \r\n");
      out.write("                       <tr>\r\n");
      out.write("                        <td>Stock</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt5\" id=\"txt5\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                        \r\n");
      out.write("                        <tr>\r\n");
      out.write("                        <td>Imagen</td>\r\n");
      out.write("                        <td><input type=\"file\" name=\"txt6\" id=\"txt6\" onchange=\"nombre(this.value)\"/> </td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("           \r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>IdCategoria</td>\r\n");
      out.write("                        <td><label for=\"cboCat\"></label>\r\n");
      out.write("                          <select name=\"cboCat\" id=\"cboCat\">\r\n");
      out.write("                            <option value=\"001\">Almacenamiento</option>\r\n");
      out.write("                            <option value=\"002\">Procesamiento</option>\r\n");
      out.write("                             <option value=\"003\">DispositivoEntrada</option>\r\n");
      out.write("                            <option value=\"004\">DispositivoSalida</option>\r\n");
      out.write("                        </select></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" class=\"btn btn-success\"/></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                  </form>\r\n");
      out.write("                  </center>\r\n");
      out.write("                  </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </table>\r\n");
      out.write("          <!-- InstanceEndEditable --></tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"separador\"></div>\r\n");
      out.write("    <div id=\"pie\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("<!-- InstanceEnd --></html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
