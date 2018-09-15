package exemplos.funcionario.acesso;

/**
 *
 * @author 78522
 */
public class Autenticador {

    public void autenticar(FuncionarioAcesso funcionario) {
        System.out.println("=== Autenticando funcionário ===");
        String codigo = funcionario.getCodigoAutenticacao();
        if ("bagrinho".equals(codigo)) {
            System.out.println("Usuário autenticado");
        } else {
            System.out.println("Polícia Federal Acionada");
        }
    }
}
