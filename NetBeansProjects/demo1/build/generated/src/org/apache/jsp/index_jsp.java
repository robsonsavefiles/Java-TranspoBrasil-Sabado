package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Exemplo AJAX</title>\n");
      out.write("    </head>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("          var request;\n");
      out.write("  \n");
      out.write("          function sendRequest() {\n");
      out.write("  \n");
      out.write("          //Determina o estado selecionado\n");
      out.write("          combo = document.getElementById(\"estado\");\n");
      out.write("          estado = combo.options[combo.selectedIndex].value;\n");
      out.write("  \n");
      out.write("          //Retorna quando nenhum estado for selecionado\n");
      out.write("          if(estado == \"-1\")\n");
      out.write("              return;\n");
      out.write("  \n");
      out.write("          //Monta a url de requisicao para o servidor\n");
      out.write("          url = \"cadastrarCliente?action=preencherCidades&estado=\"\n");
      out.write("                + estado;\n");
      out.write("  alert(url);\n");
      out.write("          //Inicializa o objeto XMLHttpRequest para o Mozilla\n");
      out.write("          if ( window.XMLHttpRequest ) {\n");
      out.write("              request = new XMLHttpRequest();\n");
      out.write("          }\n");
      out.write("\n");
      out.write("         //Inicializa o objeto XMLHttpRequest para o Internet Explorer\n");
      out.write("          else if (window.ActiveXObject) {\n");
      out.write("              request = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("          }\n");
      out.write("  \n");
      out.write("          //determina a função para processamento da requisição\n");
      out.write("          request.onreadystatechange = processRequest;\n");
      out.write("  \n");
      out.write("          //configura a requisição\n");
      out.write("          request.open(\"GET\",url,true);\n");
      out.write("  \n");
      out.write("          //envia a requisição\n");
      out.write("          request.send(null);\n");
      out.write("          }\n");
      out.write("  \n");
      out.write("          function processRequest() {\n");
      out.write("              //Verifica se a resposta já foi recebida por completo\n");
      out.write("              if(request.readyState == 4) {\n");
      out.write("              //Verifica se o status é OK\n");
      out.write("                  if(request.status == 200) {\n");
      out.write("                      //Faz a leitura do documento XML recebido\n");
      out.write("                      var response = request.responseXML;\n");
      out.write("                      var raiz =\n");
      out.write("                      response.getElementsByTagName(\"cidades\").item(0);\n");
      out.write("                      var cidades = raiz.getElementsByTagName(\"cidade\");\n");
      out.write("  \n");
      out.write("                      //Seleciona a caixa de selecao de cidades\n");
      out.write("                      var selectNode = document.getElementById(\"cidade\");\n");
      out.write("  \n");
      out.write("                      //Apaga as opções atuais da caixa de seleção\n");
      out.write("                      selectNode.options.length = 0;\n");
      out.write("  \n");
      out.write("                      //preenche a caixa de opções com os valores recebidos\n");
      out.write("                      for(var i = 0; i < cidades.length; i++) {\n");
      out.write("                          var txtCidade = cidades.item(i).firstChild.data;\n");
      out.write("                          var option = new Option(txtCidade);\n");
      out.write("                          selectNode.add(option,null);\n");
      out.write("                      }\n");
      out.write("                  }\n");
      out.write("              }\n");
      out.write("          }\n");
      out.write("    </script>    \n");
      out.write("    <body>\n");
      out.write("        <h1>Cadastro de Clientes</h1>\n");
      out.write("        <form action='");
      out.print(request.getContextPath()+"/cadastrarCliente");
      out.write("'\n");
      out.write("              method='post'>\n");
      out.write("            <fieldset><legend>Dados do cliente</legend>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for='nome'>Nome:</label></td>\n");
      out.write("                        <td colspan='3'>\n");
      out.write("                            <input name='nome' id='nome' type='text'\n");
      out.write("                                   size='75' maxlength='255'></input>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for='telefone'>Telefone: (0000-0000)\n");
      out.write("                            </label>\n");
      out.write("                        </td>\n");
      out.write("                        <td><input name='telefone' id='telefone'\n");
      out.write("                                       type='text' size='16'></input>\n");
      out.write("                        </td>\n");
      out.write("                        <td><label for='email'>e-mail:</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td><input name='email' id='email' type='text'\n");
      out.write("                                       size='37'></input>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("            <fieldset>\n");
      out.write("                <legend></legend>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for='endereco'>Rua/Av:</label></td>\n");
      out.write("                        <td><input name='rua' id='rua' type='text'\n");
      out.write("                                       size='40' maxlength='255'></input>\n");
      out.write("                        </td>\n");
      out.write("                        <td><label for='numero'>Número:</label></td>\n");
      out.write("                        <td><input name='numero' id='numero' type='text'\n");
      out.write("                                       size='8' maxlength='5'></input>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for='bairro'>Bairro:</label></td>\n");
      out.write("                        <td><input name='bairro' id='bairro' type='text'>\n");
      out.write("                            </input>\n");
      out.write("                        </td>\n");
      out.write("                        <td><label for='cep'>CEP (00000-000):</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td><input name='cep' id='cep' type='text'\n");
      out.write("                                       size='8'></input>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td><label for='estado'>Estado:</label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name='estado' id='estado'\n");
      out.write("                                    onchange='sendRequest();'>\n");
      out.write("                                <option value='-1'>Escolha um estado\n");
      out.write("                                </option>\n");
      out.write("                                <option value='MG'>MG</option>\n");
      out.write("                                <option value='SP'>SP</option>\n");
      out.write("                                <option value='RJ'>RJ</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <label for='cidade'>Cidade:</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td><select name='cidade' id='cidade'\n");
      out.write("                                        style=\"width:200px\"></select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("            <input type='submit' value=\"Salvar\"></input>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
