package org.apache.jsp.intranet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import GestionBD.GestionBD;

public final class productos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages2.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>AlphaImport</title>\r\n");
      out.write("<link href=\"../bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../css/js/jquery-1.11.0.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/jquery.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            \r\n");
      out.write("            function eliminar(){\r\n");
      out.write("                if(confirm(\"confirma que desea eliminar producto\")){\r\n");
      out.write("                    return true;\r\n");
      out.write("                }\r\n");
      out.write("                return false;\r\n");
      out.write("                \r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo2.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color:#000\">\r\n");
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
      out.write("            \t<td><a href=\"index.jsp\">Inicio</a></td>\r\n");
      out.write("                <td><a href=\"productos.jsp\">Productos</a></td>\r\n");
      out.write("                <td><a href=\"clientes.jsp\">Clientes</a></td>\r\n");
      out.write("                <td><a href=\"contactos.jsp\">Contactos</a></td>\r\n");
      out.write("                <td><a href=\"usuarios.jsp\">Usuarios</a></td>\r\n");
      out.write("           \t\t\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contenido\">\r\n");
      out.write("    \t<table width=\"960\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><!-- InstanceBeginEditable name=\"EditRegion1\" -->\r\n");
      out.write("              <table width=\"100%\" border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <table width=\"100%\" border=\"0\">  \r\n");
      out.write("                        <tr>\r\n");
      out.write("                    <td width=\"50%\"></td>\r\n");
      out.write("                    <td width=\"50%\">\r\n");
      out.write("                    \t<form action=\"productos_nuevo.jsp\" method=\"post\">\r\n");
      out.write("                        \t<input type=\"submit\" class=\"btn-primary\" value=\"Agregar\" />\r\n");
      out.write("            \r\n");
      out.write("                        </form> \r\n");
      out.write("                        \r\n");
      out.write("                                \r\n");
      out.write("                   <form action=\"productos_eliminar.jsp\" class=\"form-horizontal\" method=\"post\" >         \r\n");
      out.write("                          <p>CODIGO:\r\n");
      out.write("              <label for=\"txtcodigo\"></label>\r\n");
      out.write("              <input type=\"text\" name=\"txtcodigo\" id=\"txtcodigo\" />\r\n");
      out.write("              <input type=\"submit\" name=\"btneliminar\" id=\"btneliminar\" class=\"btn btn-success\" value=\"Eliminar\" onclick=\"return eliminar();\"/>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                          \r\n");
      out.write("                          </p>\r\n");
      out.write("                   </form>     \r\n");
      out.write("                                \r\n");
      out.write("                       \r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td colspan=\"2\">\r\n");
      out.write("                    \r\n");
      out.write("                        \r\n");
      out.write("                        ");

        try{
        out.print("<br>");    
        GestionBD og=new GestionBD(); //instanciando la clase
        og.conectar();//abrimos la conexion
        String sql="select IdProducto,Descripcion,Marca,Precio,Stock,nombre from productos p, categoria c where  p.idcategoria=c.codigo order by 1 asc ";
        ResultSet rs=og.cargaDatos(sql);
        //creamos la tabla y los titulos de la columna
        out.print("<table class='table' width=750 align=center> <tr bgcolor=#dfdfdf>"
                + "<th>IdProducto"
                + "<th>Descripcion"
                + "<th>Marca"
                + "<th>Precio"
                + "<th>Stock"
                               
                + "<th>Categoria");
        while(rs.next()){
            //ejecuta la primera fila
            out.print("<tr>");
            for(int i=1;i<=6;i++){
                //centramos los td  
                  out.print("<td> <div align=left>" + rs.getString(i) + "</div>");
            }
                
          
            out.print("</tr>");
        }
        out.print("</table>");
        og.desconectar();
        }
        catch(Exception e){
            out.println("<center><h1>No se a Cargado la base de datos</h1></center>");
        }
        
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                     </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                </table>                  \r\n");
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
