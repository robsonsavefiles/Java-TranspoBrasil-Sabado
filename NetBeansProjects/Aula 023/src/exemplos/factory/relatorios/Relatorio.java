package exemplos.factory.relatorios;

/**
 *
 * @author 78522
 */
public abstract class Relatorio {

    public enum Tipo {

        XML, HTML, TXT, JSON;
    }

    public abstract Object gerar();

    public static Relatorio getRelatorio(Tipo tipo) {
        Relatorio relatorio = null;
        switch (tipo) {
            case XML:
                relatorio = new RelatorioXML();
                break;
            case HTML:
                relatorio = new RelatorioHTML();
                break;
            case TXT:
                relatorio = new RelatorioTXT();
                break;
            case JSON:
                relatorio = new RelatorioJSON();
                break;
        }
        return relatorio;
    }

}
