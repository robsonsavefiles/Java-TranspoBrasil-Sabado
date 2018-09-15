package br.com.proway.java.factory;

/**
 *
 * @author 89087
 */
public class RelatorioHTML extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        
       resultado.append("<html>").append("\r\n")//
                .append("<head>").append("\r\n")//
                .append("<title>").append("Relatorio contatos").append("</title>")//
                .append("<body>").append("Lista de contatos").append("<h1>").append("\r\n")//
                .append("<table>").append("\r\n")//
                .append("<thead>").append("\r\n")//
                .append("tr").append("\r\n")//
                .append("th").append("Nome").append("Nome").append("</th>").append("\r\n")//
                .append("th").append("Email").append("Email").append("</th>").append("\r\n")//
                .append("th").append("Telefone").append("Telefone").append("</th>").append("\r\n")//
                .append("tr").append("\r\n")//
                .append("thead").append("\r\n")//
                .append("tbody").append("\r\n")//
                .append("tr").append("\r\n")//
                .append("td").append("\r\n").append("Nome do contato").append("</td>").append("\r\n")//
                .append("td").append("\r\n").append("Email do contato").append("</td>").append("\r\n")//
                .append("td").append("\r\n").append("Telefone do contato").append("</td>").append("\r\n")//
                .append("tr").append("\r\n")//
                .append("</tbody>").append("\r\n")//
                .append("</table>").append("\r\n")//
                .append("</body>").append("\r\n")//
                .append("</html>").append("\r\n");

        return resultado.toString();

    }

}
