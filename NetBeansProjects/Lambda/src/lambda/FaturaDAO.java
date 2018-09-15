package lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 78522
 */
public class FaturaDAO {

    public List<Fatura> buscaFaturasVencidas() {
        Fatura fatura1 = new Fatura(19.9, LocalDate.now().minusDays(5), "maria@gmail.com");
        Fatura fatura2 = new Fatura(65.0, LocalDate.now().minusDays(8), "joao@gmail.com");
        Fatura fatura3 = new Fatura(10.8, LocalDate.now().minusDays(15), "jose@gmail.com");

        return Arrays.asList(fatura1, fatura2, fatura3);
    }
}
