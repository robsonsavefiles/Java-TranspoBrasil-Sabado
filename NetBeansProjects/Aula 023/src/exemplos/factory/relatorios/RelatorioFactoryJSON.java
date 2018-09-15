package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
public class RelatorioFactoryJSON implements RelatorioFactory {

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio(Relatorio.Tipo.JSON);
    }

}
