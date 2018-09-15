package exemplos.adapter;

import exemplos.adapter.sistema1.Cliente1Adapter;
import exemplos.adapter.sistema2.Cliente2Adapter;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RelatorioCliente {

    public static void main(String[] args) {
        List<exemplos.adapter.sistema1.Cliente> lista1 = exemplos.adapter.sistema1.Repositorio.getClientes();
        List<exemplos.adapter.sistema2.Cliente> lista2 = exemplos.adapter.sistema2.Repositorio.getClientes();

        lista1.stream().forEach((cliente) -> gerarRelatorio(new Cliente1Adapter(cliente)));

        lista2.stream().forEach((cliente) -> gerarRelatorio(new Cliente2Adapter(cliente)));
    }

    public static void gerarRelatorio(ClienteAdapter cliente) {
        System.out.println("=== INÍCIO RELATÓRIO ===");
        System.out.println("Nome: " + cliente.getNomeCompleto());
        System.out.println("CPF: " + cliente.getCPF());
        System.out.println("Idade: " + cliente.getIdade());
        System.out.println("\n");
    }

}
