package br.com.proway.java.factory;

/**
 *
 * @author 89087
 */
public class RelatorioTexto extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Nome:").append("Nome do contato").append("\r\n")
                 .append("Email:").append("Email do contato").append("\r\n")
                 .append("Telefone:").append("Telefone do contato").append("\r\n");
                
        return resultado.toString();

    }
}
