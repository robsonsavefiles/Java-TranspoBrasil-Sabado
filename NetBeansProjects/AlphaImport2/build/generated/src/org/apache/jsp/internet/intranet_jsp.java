package org.apache.jsp.internet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import GestionBD.GestionBD;

public final class intranet_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>AlphaImport</title>\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo1.css\"/>\r\n");
      out.write("<link href=\"../bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../css/js/jquery-1.11.0.min.js\" type=\"text/javascript\"></script>\r\n");
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
      out.write("            \t<td><a href=\"../index.jsp\">Inicio</a>\r\n");
      out.write("                <td><a href=\"empresa.jsp\">Empresa</a>\r\n");
      out.write("                <td><a href=\"ubicacion.jsp\">Ubicaci&oacute;n</a>\r\n");
      out.write("                <td><a href=\"productos.jsp\">Productos</a>\r\n");
      out.write("                <td><a href=\"catalogo.jsp\">Cat&aacute;logo</a>\r\n");
      out.write("                <td><a href=\"clientes.jsp\">Clientes</a>\r\n");
      out.write("                <td><a href=\"contactenos.jsp\">Cont&aacute;ctenos</a>\r\n");
      out.write("                <td><a href=\"intranet.jsp\">Intranet</a>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contenido\"><!-- InstanceBeginEditable name=\"EditRegion1\" -->\r\n");
      out.write("      <table width=\"960\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td height=\"233\"><form name=\"Form1\" action=\"\" method=\"post\"><table width=\"80%\" border=\"0\" align=\"center\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"30%\" rowspan=\"6\"><img src=\"../recursos/seguridad.jpg\" width=\"196\" height=\"133\" /></td>\r\n");
      out.write("    <td width=\"20%\">Login</td>\r\n");
      out.write("    <td width=\"50%\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Usuario</td>\r\n");
      out.write("    <td><label for=\"txtusuario\"></label>\r\n");
      out.write("      <input type=\"text\" name=\"txtusuario\" class=\"form-control\" id=\"txtusuario\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Contrase&ntilde;a</td>\r\n");
      out.write("    <td><label for=\"txtpwd\"></label>\r\n");
      out.write("      <input type=\"password\" name=\"txtpwd\" id=\"inputPassword\"  />id=\"txtpwd\"</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"44\">&nbsp;</td>\r\n");
      out.write("    <td><input type=\"submit\" name=\"btniniciar\" id=\"btniniciar\" value=\"Iniciar Sesi&oacute;n\" /></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("        \r\n");
      out.write("        ");

            if(request.getParameter("txtusuario")!=null || request.getParameter("txtpwd")!=null ){
                String user=request.getParameter("txtusuario");
                String pwd=request.getParameter("txtpwd");
                GestionBD og=new GestionBD();
                og.conectar();
                String sql="Select * from usuarios where alias='"+
                        user+"' and pass='"+pwd+"'";
                ResultSet rs=og.cargaDatos(sql);
                if(rs.next()){
                    og.desconectar();
                    response.sendRedirect("../intranet/index.jsp");
                    
                }else{
                    og.desconectar();
                    JOptionPane.showMessageDialog(null, "Acceso Denegado");
                }
                    
            }
        
        
        
      out.write("\r\n");
      out.write("    <!-- InstanceEndEditable --></div>\r\n");
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
