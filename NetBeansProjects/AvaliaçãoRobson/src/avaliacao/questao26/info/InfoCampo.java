package avaliacao.questao26.info;

/**
 *
 * @author 89087
 */
public class InfoCampo {

    private String nome;
    private int tamanhoImpressao;

    public InfoCampo() {
    }

    public InfoCampo(String nome, int tamanhoImpressao) {
        this.nome = nome;
        this.tamanhoImpressao = tamanhoImpressao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamanhoImpressao() {
        return tamanhoImpressao;
    }

    public void setTamanhoImpressao(int tamanhoImpressao) {
        this.tamanhoImpressao = tamanhoImpressao;
    }

}
