package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
class RelatorioJSON extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("{ ").append("\r\n")
                .append("Nome: ").append("Nome do Contato").append("\r\n")
                .append("Email: ").append("Email do Contato").append("\r\n")
                .append("Telefone: ").append("Telefone do Contato").append("\r\n")
                .append("}").append("\r\n");
        return resultado.toString();
    }

}
