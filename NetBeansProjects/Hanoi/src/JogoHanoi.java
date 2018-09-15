
/**
 *
 * @author 78522
 */
public class JogoHanoi {

    private static final int QTD_MAX_DISCOS = 10;
    private static final int QTD_TORRES = 3;

    private final Torre[] torres;
    private int qtdJogadas;
    private int qtdDiscos;

    public JogoHanoi() {
        torres = new Torre[QTD_TORRES];
        qtdJogadas = 0;
        for (int i = 0; i < QTD_TORRES; i++) {
            torres[i] = new Torre(QTD_MAX_DISCOS);
        }
    }

    public void comecarJogo(int qtdDiscos) {
        if (qtdDiscos <= QTD_MAX_DISCOS) {
            this.qtdDiscos = qtdDiscos;
            torres[0].popular(qtdDiscos);
        } else {
            throw new IllegalArgumentException("Não da para jogar com mais de " + QTD_MAX_DISCOS + " discos!");
        }
    }

    public void imprimirTorres() {
        for (int i = 0; i < torres.length; i++) {
            System.out.printf("Torre" + (i + 1) + "\t");
            System.out.println(torres[i].imprimir());
        }
    }

    public void jogada() {

    }

    public boolean verificaVitoria() {
        if (torres[0].getQtdDiscos() == 0 && torres[1].getQtdDiscos() == 0 && torres[2].getQtdDiscos() == qtdDiscos) {
            return true;
        }
        return false;
    }
}
