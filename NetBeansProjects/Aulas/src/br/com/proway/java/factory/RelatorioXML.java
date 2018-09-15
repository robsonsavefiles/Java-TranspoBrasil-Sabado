package br.com.proway.java.factory;

/**
 *
 * @author 89087
 */
public class RelatorioXML extends Relatorio {

    @Override
    public Object gerar() {

        StringBuilder resultado = new StringBuilder();
        resultado.append("<contato>").append("\r\n");
        resultado.append("<nome>").append("Nome do contato").append("</nome>");
        resultado.append("<email>").append("Email do contato").append("</email>");
        resultado.append("<telefone>").append("Telefone do contato").append("</Telefone>");
        resultado.append("</contato>");
        return resultado.toString();
    }

}
