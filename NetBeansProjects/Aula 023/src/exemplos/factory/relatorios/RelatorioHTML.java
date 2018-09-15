package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
class RelatorioHTML extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<html>").append("\r\n")
                .append("<head>").append("\r\n")
                .append("<title>").append("Relatório Contatos").append("</title>").append("\r\n")
                .append("</head>").append("\r\n")
                .append("<body>").append("\r\n")
                .append("<h1>").append("Lista de Contatos").append("</h1>").append("\r\n")
                .append("<table>").append("\r\n")
                .append("<thead>").append("\r\n")
                .append("<tr>").append("\r\n")
                .append("<th>").append("Nome").append("</th>").append("\r\n")
                .append("<th>").append("Email").append("</th>").append("\r\n")
                .append("<th>").append("Telefone").append("</th>").append("\r\n")
                .append("</tr>").append("\r\n")
                .append("</thead>").append("\r\n")
                .append("<tbody>").append("\r\n")
                .append("<tr>").append("\r\n")
                .append("<td>").append("Nome do Contato").append("</td>").append("\r\n")
                .append("<td>").append("Email do Contato").append("</td>").append("\r\n")
                .append("<td>").append("Telefone do Contato").append("</td>").append("\r\n")
                .append("</tr>").append("\r\n")
                .append("</tbody>").append("\r\n")
                .append("</table>").append("\r\n")
                .append("</body>").append("\r\n")
                .append("</html>");
        return resultado.toString();
    }

}
