package exemplos.factory.clientes;

import exemplos.factory.relatorios.Relatorio;
import exemplos.factory.relatorios.RelatorioFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class ClienteA {

    public static void main(String[] args) {
        try {
            RelatorioFactory factory = new Sistema().getRelatorioFactory();
            Relatorio relatorio = factory.getRelatorio();
            System.out.println(relatorio.gerar());
        } catch (Exception ex) {
            Logger.getLogger(ClienteA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
