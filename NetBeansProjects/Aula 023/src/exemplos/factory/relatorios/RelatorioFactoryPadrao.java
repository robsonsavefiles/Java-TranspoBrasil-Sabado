package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
public class RelatorioFactoryPadrao implements RelatorioFactory {

    @Override
    public Relatorio getRelatorio() {
        return Relatorio.getRelatorio(Relatorio.Tipo.TXT);
    }

}
