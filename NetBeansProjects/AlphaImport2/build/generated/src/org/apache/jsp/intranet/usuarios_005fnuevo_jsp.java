package org.apache.jsp.intranet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usuarios_005fnuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo2.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<div id=\"contenedor\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"cabecera\">\r\n");
      out.write("    \t<div id=\"logo\"></div>    \t\r\n");
      out.write("        <div id=\"cliente\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"banner\"></div>\r\n");
      out.write("    <div id=\"menu\">\r\n");
      out.write("   \t  <table>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("            \t<td><a href=\"index.jsp\">Inicio</a>\r\n");
      out.write("                <td>Productos\r\n");
      out.write("                <td>Proveedores\r\n");
      out.write("                <td>Clientes\r\n");
      out.write("                <td>Contactos\r\n");
      out.write("                <td>Usuarios\r\n");
      out.write("                <td>Pedidos\r\n");
      out.write("           \t\t<td>&nbsp;\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contenido\">\r\n");
      out.write("    \t<table width=\"960\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><!-- InstanceBeginEditable name=\"EditRegion1\" -->\r\n");
      out.write("              <table width=\"100%\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <td><form id=\"form1\" name=\"form1\" method=\"post\" action=\"usuarios_insert.jsp\">\r\n");
      out.write("                    <table width=\"50%\" border=\"0\" align=\"center\">\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>IdUsuario</td>\r\n");
      out.write("                        <td><label for=\"txt1\"></label>\r\n");
      out.write("                          <input type=\"text\" name=\"txt1\" id=\"txt1\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Nombres</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt2\" id=\"txt2\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Alias</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"txt3\" id=\"txt3\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Password</td>\r\n");
      out.write("                        <td><input type=\"password\" name=\"txt4\" id=\"txt4\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>Perfil</td>\r\n");
      out.write("                        <td><label for=\"cboPerfil\"></label>\r\n");
      out.write("                          <select name=\"cboPerfil\" id=\"cboPerfil\">\r\n");
      out.write("                            <option value=\"ADM\">ADMINISTRADOR</option>\r\n");
      out.write("                            <option value=\"OPE\">OPERADOR</option>\r\n");
      out.write("                        </select></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      <tr>\r\n");
      out.write("                        <td>&nbsp;</td>\r\n");
      out.write("                        <td><input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" /></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                  </form></td>\r\n");
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
