package exemplos.funcionario.rh;

/**
 *
 * @author 78522
 */
public class RelatorioFuncionario {

    public void gerarRelatorio(FuncionarioRH funcionario) {
        System.out.println("=== Relatório Funcionário ===");
        System.out.printf("Codigo: %s\r\n", funcionario.getCodigo());
        System.out.printf("Nome: %s\r\n", funcionario.getNome());
        System.out.printf("CPF: %s\r\n", funcionario.getCpf());
        System.out.printf("Cargo: %s\r\n", funcionario.getCargo());
        System.out.printf("Ano Nascimento: %d\r\n", funcionario.getAnoNascimento());
        System.out.printf("Número Dependentes: %d\r\n", funcionario.getDependentes());
        System.out.printf("Eescolaridade: %s\r\n", funcionario.getEscolaridade());
    }
}
