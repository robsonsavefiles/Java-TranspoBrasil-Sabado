package org.apache.jsp.internet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import GestionBD.GestionBD;

public final class catalogo_005fdetalles_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>AlphaImport</title>\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo1.css\"/>\r\n");
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
      out.write("     ");

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
	 
      out.write("\r\n");
      out.write("          <br />\r\n");
      out.write("     \r\n");
      out.write("      <table width=\"960\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("            <table width=\"40%\" border=\"0\" align=\"center\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"50%\">Codigo;</td>\r\n");
      out.write("                <td width=\"50%\">");
out.print(i);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>Descripcion:</td>\r\n");
      out.write("                <td>");
out.print(d);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>Marca:</td>\r\n");
      out.write("                <td>");
out.print(m);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>Precio:</td>\r\n");
      out.write("                <td>");
out.print(pr);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>Stock:</td>\r\n");
      out.write("                <td>");
out.print(s);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>Categoria</td>\r\n");
      out.write("                <td>");
out.print(cc);
      out.write("</td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("            <td colspan=\"2\"><div align=\"center\">\r\n");
      out.write("\t\t\t");
out.print("<img src="+im+" width=200 height=200>");
      out.write("</div>\r\n");
      out.write("            </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td colspan=\"2\"><form id=\"form1\" name=\"form1\" method=\"post\" action=\"carrito_insert.jsp\">\r\n");
      out.write("                  <table width=\"30%\" border=\"0\" align=\"center\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>Cantidad </td>\r\n");
      out.write("                      <td><label for=\"txtcantidad\"></label>\r\n");
      out.write("                        <input name=\"txtcantidad\" type=\"text\" id=\"txtcantidad\" value=\"1\" size=\"10\" /></td>\r\n");
      out.write("                      <td><input type=\"submit\" name=\"btnadd\" id=\"btnadd\" value=\"Agregar al carrito\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </table>\r\n");
      out.write("                </form></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
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
