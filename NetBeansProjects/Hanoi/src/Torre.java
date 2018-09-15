
/**
 *
 * @author 78522
 */
public class Torre {

    private final int tamMax;
    private final Disco[] discos;
    private int lastPos;

    public Torre(int tamMax) {
        this.tamMax = tamMax;
        discos = new Disco[tamMax];
        lastPos = 0;
    }

    public int getQtdDiscos() {
        int qtd = 0;
        for (Disco disco : discos) {
            if (disco != null) {
                qtd++;
            }
        }
        return qtd;
    }

    public void popular(int qtdDiscos) {
        for (int i = 0; i < qtdDiscos; i++) {
            adicionarDisco(new Disco(qtdDiscos - i));
        }
    }

    public void adicionarDisco(Disco disco) {
        if (lastPos < tamMax) {
            if (lastPos == 0) {
                discos[lastPos++] = disco;
            } else {
                if (discos[lastPos - 1].getDiametro() > disco.getDiametro()) {
                    discos[lastPos++] = disco;
                } else {
                    throw new IllegalArgumentException("Não pode colocar um disco em cima de um menor!");
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("O tamanho máximo de discos foi alcançado!");
        }
    }

    public Disco retirarDisco() {
        if (lastPos > 0) {
            Disco disco = discos[lastPos--];
            discos[lastPos] = null;
            return disco;
        } else {
            throw new ArrayIndexOutOfBoundsException("O tamanho máximo de discos foi alcançado!");
        }
    }

    public String imprimir() {
        String retorno = "";
        for (Disco disco : discos) {
            if (disco != null) {
                retorno += "[" + disco.getDiametro() + "]";
            }
        }
        return retorno;
    }
}
