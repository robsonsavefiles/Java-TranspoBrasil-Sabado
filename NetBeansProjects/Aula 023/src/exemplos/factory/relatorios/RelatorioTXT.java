package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
class RelatorioTXT extends Relatorio {

    @Override
    public Object gerar() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Nome: ").append("Nome do Contato").append("\r\n")
                .append("Email: ").append("Email do Contato").append("\r\n")
                .append("Telefone: ").append("Telefone do Contato").append("\r\n");
        return resultado.toString();
    }

}
