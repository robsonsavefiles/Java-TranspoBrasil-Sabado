package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/masterpages.dwt\" codeOutsideHTMLIsLocked=\"false\" -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>AlphaImport</title>\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"planillas/estilo1.css\"/>\r\n");
      out.write("<link href=\"../bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../css/js/jquery-1.11.0.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("    <span id=\"liveclock\" style=\" position: fixed;left:0;top:4;\"></span>\r\n");
      out.write("       ");
      out.write("\r\n");
      out.write("       <script language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\r\n");
      out.write("function show5(){\r\n");
      out.write("if (!document.layers&&!document.all&&!document.getElementById)\r\n");
      out.write("return;\r\n");
      out.write("\r\n");
      out.write(" var Digital=new Date();\r\n");
      out.write(" var hours=Digital.getHours();\r\n");
      out.write(" var minutes=Digital.getMinutes();\r\n");
      out.write(" var seconds=Digital.getSeconds();\r\n");
      out.write("\r\n");
      out.write("var dn=\"PM\";\r\n");
      out.write("if (hours<12)\r\n");
      out.write("dn=\"AM\";\r\n");
      out.write("if (hours>12)\r\n");
      out.write("hours=hours-12;\r\n");
      out.write("if (hours==0)\r\n");
      out.write("\r\n");
      out.write("hours=12;\r\n");
      out.write("\r\n");
      out.write(" if (minutes<=9)\r\n");
      out.write(" minutes=\"0\"+minutes;\r\n");
      out.write(" if (seconds<=9)\r\n");
      out.write(" seconds=\"0\"+seconds;\r\n");
      out.write("//change font size here to your desire\r\n");
      out.write("myclock=\"<font size='5' face='Arial' ><b>\"+hours+\":\"+minutes+\":\"+seconds+\" \"+dn+\"</b></font>\";\r\n");
      out.write("if (document.layers){\r\n");
      out.write("document.layers.liveclock.document.write(myclock);\r\n");
      out.write("document.layers.liveclock.document.close();\r\n");
      out.write("}\r\n");
      out.write("else if (document.all)\r\n");
      out.write("liveclock.innerHTML=myclock;\r\n");
      out.write("else if (document.getElementById)\r\n");
      out.write("document.getElementById(\"liveclock\").innerHTML=myclock;\r\n");
      out.write("setTimeout(\"show5()\",1000);\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("window.onload=show5;\r\n");
      out.write(" //-->\r\n");
      out.write(" </script>\r\n");
      out.write(" \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        img = new Array(); \r\n");
      out.write("img.push('/bootstrap/img/lapt1.jpg'); \r\n");
      out.write("img.push('bootstrap/img/lapt.jpg'); \r\n");
      out.write("img.push('bootstrap/img/monitor.jpg'); \r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("    index = 0; \r\n");
      out.write("function altBg(){ \r\n");
      out.write("document.body.style.backgroundImage = 'url(' + img[index % img.length] + ')'; \r\n");
      out.write("index++; \r\n");
      out.write("} \r\n");
      out.write("window.onload = function(){ \r\n");
      out.write("setInterval('altBg()', 2000); \r\n");
      out.write("// 5000 milisegundos equivalente a 5 segundos; \r\n");
      out.write("}; \r\n");
      out.write("    \r\n");
      out.write("    </script>\r\n");
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
      out.write("                    <td><a href=\"index.jsp\">Inicio</a></td>\r\n");
      out.write("                <td><a href=\"internet/empresa.jsp\">Empresa</a></td>\r\n");
      out.write("                <td><a href=\"internet/ubicacion.jsp\">Ubicaci&oacute;n</a></td>\r\n");
      out.write("                <td><a href=\"internet/productos.jsp\">Productos</a></td>\r\n");
      out.write("                <td><a href=\"internet/catalogo.jsp\">Cat&aacute;logo</a></td>\r\n");
      out.write("                <td><a href=\"internet/clientes.jsp\">Clientes</a></td>\r\n");
      out.write("                <td><a href=\"internet/contactenos.jsp\">Cont&aacute;ctenos</a></td>\r\n");
      out.write("                <td><a href=\"internet/intranet.jsp\">Intranet</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"contenido\"><!-- InstanceBeginEditable name=\"EditRegion1\" -->\r\n");
      out.write("      <table width=\"960\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td><table width=\"100%\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td align=\"center\"><h1><p class=\"text-center\">\r\n");
      out.write("                      <marquee  scrolldelay=\"1\" scrollamount=\"2\" direction=\"left\" loop=\"infinite\" onmouseout=\"this.start()\" onmouseover=\"this.stop()\">Bienvenidos a Alpha Import S.A.</marquee></p></h1></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"center\"><img src=\"recursos/imagen01.jpg\" width=\"500\" height=\"350\" /></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    <!-- InstanceEndEditable --></div>\r\n");
      out.write("    <div id=\"separador\"></div>\r\n");
      out.write("    <div id=\"pie\">\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
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
