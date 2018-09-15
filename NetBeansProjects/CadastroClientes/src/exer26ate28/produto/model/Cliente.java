package exer26ate28.produto.model;

import static exer26ate28.produto.model.Entidade.CAMPO_DATA_ALTERACAO;
import static exer26ate28.produto.model.Entidade.CAMPO_DATA_CRIACAO;
import static exer26ate28.produto.model.Entidade.CAMPO_ID;
import static exer26ate28.produto.model.Modelo.CAMPOS;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class Cliente extends Entidade {

    public static final Map<String, InfoCampo> CAMPOS = new HashMap();

    public static final InfoCampo CAMPO_NOME = new InfoCampo("Nome", 50);
    public static final InfoCampo CAMPO_DATA_NASCIMENTO = new InfoCampo("Data de Nascimento", 10);
    public static final InfoCampo CAMPO_NOME_PAI = new InfoCampo("Nome do Pai", 50);
    public static final InfoCampo CAMPO_NOME_MAE = new InfoCampo("Nome da M�e", 50);
    public static final InfoCampo CAMPO_CPF = new InfoCampo("CPF", 20);
    public static final InfoCampo CAMPO_TELEFONE = new InfoCampo("Telefone", 20);
    public static final InfoCampo CAMPO_ENDERECO = new InfoCampo("Endere�o", 50);

    static {
        CAMPOS.put(CAMPO_ID.getNome(), CAMPO_ID);
        CAMPOS.put(CAMPO_DATA_CRIACAO.getNome(), CAMPO_DATA_CRIACAO);
        CAMPOS.put(CAMPO_DATA_ALTERACAO.getNome(), CAMPO_DATA_ALTERACAO);
        CAMPOS.put(CAMPO_NOME.getNome(), CAMPO_NOME);
        CAMPOS.put(CAMPO_DATA_NASCIMENTO.getNome(), CAMPO_DATA_NASCIMENTO);
        CAMPOS.put(CAMPO_NOME_PAI.getNome(), CAMPO_NOME_PAI);
        CAMPOS.put(CAMPO_NOME_MAE.getNome(), CAMPO_NOME_MAE);
        CAMPOS.put(CAMPO_CPF.getNome(), CAMPO_CPF);
        CAMPOS.put(CAMPO_TELEFONE.getNome(), CAMPO_TELEFONE);
        CAMPOS.put(CAMPO_ENDERECO.getNome(), CAMPO_ENDERECO);
    }

    private String nome;
    private LocalDate dataNascimento;
    private String nomePai;
    private String nomeMae;
    private String cpf;
    private String telefone;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome, LocalDate dataNascimento, String nomePai, String nomeMae, String Cpf, String telefone, Endereco endereco) {
        this(null, dataCriacao, dataAlteracao, nome, dataNascimento, nomePai, nomeMae, Cpf, telefone, endereco);
    }

    public Cliente(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String nome, LocalDate dataNascimento, String nomePai, String nomeMae, String Cpf, String telefone, Endereco endereco) {
        super(id, dataCriacao, dataAlteracao);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.cpf = Cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += super.infoLinhaString() + "|";
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", nome) + "|";
        retorno += String.format("%-" + CAMPO_DATA_NASCIMENTO.getTamanhoImpressao() + "s", dataNascimento) + "|";
        retorno += String.format("%-" + CAMPO_NOME_PAI.getTamanhoImpressao() + "s", nomePai) + "|";
        retorno += String.format("%-" + CAMPO_NOME_MAE.getTamanhoImpressao() + "s", nomeMae) + "|";
        retorno += String.format("%-" + CAMPO_CPF.getTamanhoImpressao() + "s", cpf) + "|";
        retorno += String.format("%-" + CAMPO_TELEFONE.getTamanhoImpressao() + "s", telefone) + "|";
        retorno += endereco.infoLinhaString();
        return retorno;
    }

    @Override
    public Map<String, InfoCampo> getCampos() {
        return CAMPOS;
    }

}
