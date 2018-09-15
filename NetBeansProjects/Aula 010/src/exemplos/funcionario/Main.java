package exemplos.funcionario;

import exemplos.funcionario.acesso.Autenticador;
import exemplos.funcionario.folha.FolhaPagamento;
import exemplos.funcionario.rh.RelatorioFuncionario;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        Funcionario func = new Funcionario("bagrinho", "1234", "Bagrinho da Silva", "04923459410", "Programador", 1900, 2, "Ensino Fundamental", 1800.50);

        Autenticador aut = new Autenticador();
        RelatorioFuncionario rel = new RelatorioFuncionario();
        FolhaPagamento folha = new FolhaPagamento();
        
        rel.gerarRelatorio(func);
        System.out.println("");
        aut.autenticar(func);
        System.out.println("");
        folha.gerarHolerite(func);
    }
}
