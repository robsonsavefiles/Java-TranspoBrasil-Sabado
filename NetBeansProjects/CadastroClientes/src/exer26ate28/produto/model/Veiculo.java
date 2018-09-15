package exer26ate28.produto.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 78522
 */
public class Veiculo extends Entidade implements Serializable {

    public static final Map<String, InfoCampo> CAMPOS = new HashMap();

    public static final InfoCampo CAMPO_MARCA = new InfoCampo("Marca", 50);
    public static final InfoCampo CAMPO_MODELO = new InfoCampo("Modelo", 50);
    public static final InfoCampo CAMPO_PLACA = new InfoCampo("Placa", 10);
    public static final InfoCampo CAMPO_COR = new InfoCampo("Cor", 10);
    public static final InfoCampo CAMPO_ANO_FABRICACAO = new InfoCampo("Ano de Fabrica��o", 10);

    static {
        CAMPOS.put(CAMPO_ID.getNome(), CAMPO_ID);
        CAMPOS.put(CAMPO_DATA_CRIACAO.getNome(), CAMPO_DATA_CRIACAO);
        CAMPOS.put(CAMPO_DATA_ALTERACAO.getNome(), CAMPO_DATA_ALTERACAO);
        CAMPOS.put(CAMPO_MARCA.getNome(), CAMPO_MARCA);
        CAMPOS.put(CAMPO_MODELO.getNome(), CAMPO_MODELO);
        CAMPOS.put(CAMPO_PLACA.getNome(), CAMPO_PLACA);
        CAMPOS.put(CAMPO_COR.getNome(), CAMPO_COR);
        CAMPOS.put(CAMPO_ANO_FABRICACAO.getNome(), CAMPO_ANO_FABRICACAO);
    }

    private Modelo modelo;
    private String placa;
    private String cor;
    private int anoFabricacao;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Veiculo() {
    }

    public Veiculo(LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String placa, String cor, Modelo modelo, int anoFabricacao) {
        this(null, dataCriacao, dataAlteracao, placa, cor, modelo, anoFabricacao);
    }

    public Veiculo(Long id, LocalDateTime dataCriacao, LocalDateTime dataAlteracao, String placa, String cor, Modelo modelo, int anoFabricacao) {
        super(id, dataCriacao, dataAlteracao);
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    @Override
    public String infoLinhaString() {
        String retorno = "";
        retorno += super.infoLinhaString() + "|";
        retorno += String.format("%-" + CAMPO_PLACA.getTamanhoImpressao() + "s", placa) + "|";
        retorno += String.format("%-" + CAMPO_COR.getTamanhoImpressao() + "s", cor) + "|";
        retorno += String.format("%-" + CAMPO_ANO_FABRICACAO.getTamanhoImpressao() + "d", anoFabricacao) + "|";
        retorno += modelo.infoLinhaString();
        return retorno;
    }

    @Override
    public Map<String, InfoCampo> getCampos() {
        return CAMPOS;
    }
}
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        setId((Long) in.readObject());
//        setNome();
//        telefone = new Telefone();
//        telefone.setCodigoPais((String) in.readObject());
//        telefone.setCodigoArea((String) in.readObject());
//        telefone.setNumero((String) in.readObject());
//    }
//
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//
//        out.writeObject(getNome());
//
//        out.writeObject(telefone.getCodigoPais());
//        out.writeObject(telefone.getCodigoArea());
//        out.writeObject(telefone.getNumero());
////        out.writeObject(telefone.getCodigoPais() != null ? telefone.getCodigoPais() : null);
////        out.writeObject(telefone.getCodigoArea() != null ? telefone.getCodigoArea() : null);
////        out.writeObject(telefone.getNumero() != null ? telefone.getNumero() : null);
//    }
//}
