package exemplos.funcionario.acesso;

/**
 *
 * @author 78522
 */
public class Autenticador {

    public void autenticar(FuncionarioAcesso funcionario) {
        System.out.println("=== Autenticando funcion�rio ===");
        String codigo = funcionario.getCodigoAutenticacao();
        if ("bagrinho".equals(codigo)) {
            System.out.println("Usu�rio autenticado");
        } else {
            System.out.println("Pol�cia Federal Acionada");
        }
    }
}
