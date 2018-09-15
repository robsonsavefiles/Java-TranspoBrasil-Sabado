package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
class RelatorioXML extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<contato>").append("\r\n");
        resultado.append("<nome>").append("Nome do Contato").append("</nome>").append("\r\n");
        resultado.append("<email>").append("Email do Contato").append("</email>").append("\r\n");
        resultado.append("<telefone>").append("Telefone do Contato").append("</telefone>").append("\r\n");
        resultado.append("</contato>");
        return resultado.toString();
    }

}
