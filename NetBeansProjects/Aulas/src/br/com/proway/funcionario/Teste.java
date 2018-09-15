package aula.pkg009;

/**
 *
 * @author 78522
 */
public class Teste {

    public static void main(String[] args) {
        Cargo cargo1 = new Atendente(0L, "Atendente de Caixa", 1200);
        Cargo cargo2 = new Vendedor(1L, "Vendedor", 1800, 40000, 0.02);
        Cargo cargo3 = new Gerente(0L, "Gerente", 1200, 500);

        FolhaPagamento folhaPagamento = new FolhaPagamento();

    }
}
