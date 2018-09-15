package exemplos.funcionario.folha;

/**
 *
 * @author 78522
 */
public class FolhaPagamento {

    public void gerarHolerite(FuncionarioFolha funcionario) {
        System.out.println("=== Holerite ===");
        System.out.printf("Codigo: %s\r\n", funcionario.getCodigo());
        System.out.printf("Nome: %s\r\n", funcionario.getNome());
        System.out.printf("CPF: %s\r\n", funcionario.getCpf());
        System.out.printf("Cargo: %s\r\n", funcionario.getCargo());
        System.out.printf("Salário: %.2f\r\n", funcionario.getSalario());
    }
}
