package org.apache.jsp.intranet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import GestionBD.GestionBD;

public final class clientes_005feditar_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages2.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>AlphaImport</title>\n");
      out.write("\n");
      out.write("        <link href=\"../bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../css/js/jquery-1.11.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write(" function nombre(fic) {\n");
      out.write("             fic = fic.split('\\\\');\n");
      out.write("           }\n");
      out.write("        function validar(){\n");
      out.write("            \n");
      out.write("          \tif (document.form2.txt1.value.length==0){ \n");
      out.write("      \talert(\"Tiene que escribir su codigo \") \n");
      out.write("      \tdocument.form2.txt1.focus() \n");
      out.write("       return false;\n");
      out.write("   \t} \n");
      out.write("        \n");
      out.write("        if (document.form2.txt2.value.length==0){ \n");
      out.write("      \talert(\"Tiene que escribir su Nombre\") \n");
      out.write("      \tdocument.form2.txt2.focus() \n");
      out.write("      return false;\n");
      out.write("   \t} \n");
      out.write("          if (document.form2.txt3.value.length==0){ \n");
      out.write("      \talert(\"Tiene que escribir su Direccion\") \n");
      out.write("      \tdocument.form2.txt3.focus() \n");
      out.write("      \t  return false;\n");
      out.write("   \t} \n");
      out.write("        if (document.form2.txt4.value.length==0){ \n");
      out.write("      \talert(\"Tiene que escribir su Telefono\") \n");
      out.write("      \tdocument.form2.txt4.focus() \n");
      out.write("      \t  return false;\n");
      out.write("   \t} \n");
      out.write("        if (document.form2.txt5.value.length==0){ \n");
      out.write("      \talert(\"Tiene que escribir su RUC o DNI\") \n");
      out.write("      \tdocument.form2.txt5.focus() \n");
      out.write("      \t  return false;\n");
      out.write("   \t}\n");
      out.write("         \n");
      out.write("   \t//el formulario se envia \n");
      out.write("   \talert(\"Se actualizo Cliente\"); \n");
      out.write("   \tdocument.form2.submit(); \n");
      out.write("}        \n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\"  href=\"../planillas/estilo2.css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<center>\n");
      out.write("<div id=\"contenedor\">\n");
      out.write("\n");
      out.write("    <div id=\"cabecera\">\n");
      out.write("    \t<div id=\"logo\"></div>    \t\n");
      out.write("        <div id=\"cliente\"><a href=\"../index.jsp\">Cerrar Sesion</a></div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"banner\"></div>\n");
      out.write("    <div id=\"menu\">\n");
      out.write("   \t  <table>\n");
      out.write("        \t<tr>\n");
      out.write("                    <td><a href=\"index.jsp\">Inicio</a></td>\n");
      out.write("                <td><a href=\"productos.jsp\">Productos</a></td>\n");
      out.write("                <td><a href=\"clientes.jsp\">Clientes</a></td>\n");
      out.write("                <td><a href=\"contactos.jsp\">Contactos</a></td>\n");
      out.write("                <td><a href=\"usuarios.jsp\">Usuarios</a></td>\n");
      out.write("           \n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"contenido\">\n");
      out.write("    \t<table width=\"960\" border=\"0\">\n");
      out.write("          <tr>\n");
      out.write("            <td><!-- InstanceBeginEditable name=\"EditRegion1\" -->\n");
      out.write("              <table width=\"100%\" border=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                  <td>\n");
      out.write("                      <center>\n");
      out.write("                          <h1><p class=\"text-center\">Modificar Clientes</p></h1>  \n");
      out.write("                           ");

        try{
            String c=request.getParameter("txtcodigo");
            GestionBD og=new GestionBD(); //instanciando la clase
            og.conectar();//abrimos la conexion
            String sql="select * from clientes where IdCliente = '" + c +"'"; 
            ResultSet rs=og.cargaDatos(sql);
            rs.next();            
        
      out.write("\n");
      out.write("                      <form id=\"form2\" name=\"form2\" method=\"post\" class=\"form-horizontal\" action=\"clientes_update.jsp\" onsubmit=\"return validar();\">\n");
      out.write("                    <table width=\"50%\" border=\"0\" align=\"center\">\n");
      out.write("                      <tr>\n");
      out.write("                        <td>IdCliente:</td>\n");
      out.write("                        <td><label for=\"txt1\"></label>\n");
      out.write("                          <input type=\"text\" name=\"txtcodigo\" value=\"");
      out.print(rs.getString(1));
      out.write("\" id=\"txt1\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>Nombre:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txt2\" value=\"");
      out.print(rs.getString(2));
      out.write("\" id=\"txt2\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>Direccion:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txt3\" value=\"");
      out.print(rs.getString(3));
      out.write("\" id=\"txt3\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>Telefono:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txt4\" value=\"");
      out.print(rs.getString(4));
      out.write("\" id=\"txt4\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                      \n");
      out.write("                       <tr>\n");
      out.write("                        <td>Ruc:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txt5\" value=\"");
      out.print(rs.getString(5));
      out.write("\" id=\"txt5\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                        \n");
      out.write("                        <tr>\n");
      out.write("                        <td>Imagen</td>\n");
      out.write("                        <td><input type=\"file\" name=\"txt6\" id=\"txt6\" onchange=\"nombre(this.value)\"/> </td>\n");
      out.write("                      </tr>\n");
      out.write("           \n");
      out.write("                      <tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                      </tr>\n");
      out.write("                      <tr>\n");
      out.write("                        <td>&nbsp;</td>\n");
      out.write("                        <td><input type=\"submit\" name=\"btnGuardar\" id=\"btnGuardar\" value=\"Guardar\" class=\"btn btn-success\" /></td>\n");
      out.write("                      </tr>\n");
      out.write("                    </table>\n");
      out.write("                  </form>\n");
      out.write("                  </center>\n");
      out.write("                  </td>\n");
      out.write("                </tr>\n");
      out.write("              </table>\n");
      out.write("                      ");

               og.desconectar();
               }catch (Exception e){
               out.println("Debia ingresar un valor");
               }
            
      out.write("\n");
      out.write("          <!-- InstanceEndEditable --></tr>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"separador\"></div>\n");
      out.write("    <div id=\"pie\"></div>\n");
      out.write("</div>\n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("<!-- InstanceEnd --></html>");
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
