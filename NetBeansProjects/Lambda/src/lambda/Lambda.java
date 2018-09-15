package lambda;

import java.util.List;

/**
 *
 * @author 78522
 */
public class Lambda {

    public static void main(String[] args) {
        Email email = new Email();
        FaturaDAO dao = new FaturaDAO();
        List<Fatura> faturas = dao.buscaFaturasVencidas();

        faturas.forEach(f -> email.enviar(f.getEmailDevedor(), f.toString()));
    }

}
