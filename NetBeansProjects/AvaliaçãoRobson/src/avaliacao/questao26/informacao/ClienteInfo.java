package avaliacao.questao26.informacao;

import avaliacao.questao26.modelos.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 89087
 */
public abstract class ClienteInfo extends EntidadeInfo {

    public static final String NOME_SINGULAR = "Cliente";
    public static final String NOME_PLURAL = "Clientes";

    public static final InfoCampo CAMPO_NOME = new InfoCampo("Nome do " + NOME_SINGULAR, 50);
    public static final InfoCampo CAMPO_CPF = new InfoCampo("CPF do " + NOME_SINGULAR, 20);
    public static final InfoCampo CAMPO_TELEFONE = new InfoCampo("Telefone do " + NOME_SINGULAR, 20);
    public static final InfoCampo CAMPO_CELULAR = new InfoCampo("Celular do " + NOME_SINGULAR, 20);
    public static final InfoCampo CAMPO_ENDERECO = new InfoCampo("Endereço do "+ NOME_SINGULAR,100);

    public static List<InfoCampo> getCamposPesquisa() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_NOME);
        retorno.add(CAMPO_CPF);
        retorno.add(CAMPO_TELEFONE);
        retorno.add(CAMPO_CELULAR);
        retorno.add(CAMPO_ENDERECO);
        return retorno;
    }

    public static List<InfoCampo> getCamposOrdenacao() {
        List<InfoCampo> retorno = new ArrayList();
        retorno.add(CAMPO_ID);
        retorno.add(CAMPO_DATA_CRIACAO);
        retorno.add(CAMPO_NOME);
        retorno.add(CAMPO_CPF);
        retorno.add(CAMPO_TELEFONE);
        retorno.add(CAMPO_CELULAR);
        retorno.add(CAMPO_ENDERECO);
        return retorno;
    }

    public static String infoCabecalhoString() {
        String retorno = "";
        retorno += EntidadeInfo.infoCabecalhoString() + SEPARADOR;
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", CAMPO_NOME.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CPF.getTamanhoImpressao() + "s", CAMPO_CPF.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_TELEFONE.getTamanhoImpressao() + "s", CAMPO_TELEFONE.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CELULAR.getTamanhoImpressao() + "s", CAMPO_CELULAR.getNome());
        retorno += String.format("%-" + CAMPO_ENDERECO.getTamanhoImpressao() +"s",CAMPO_ENDERECO.getNome()) + SEPARADOR;
        return retorno;
    }

    public static String infoLinhaString(Cliente obj) {
        String retorno = "";
        retorno += EntidadeInfo.infoLinhaString(obj) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_NOME.getTamanhoImpressao() + "s", obj.getNome()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CPF.getTamanhoImpressao() + "s", obj.getCpf()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_TELEFONE.getTamanhoImpressao() + "s", obj.getTelefone()) + SEPARADOR;
        retorno += String.format("%-" + CAMPO_CELULAR.getTamanhoImpressao() + "s", obj.getCelular());
        retorno += String.format("%-" + CAMPO_ENDERECO.getTamanhoImpressao()+"s",obj.getEndereco());
        
        return retorno;
    }

    public static Object getValueCampo(Cliente cliente, InfoCampo campo) {
        if (campo == ClienteInfo.CAMPO_NOME) {
            return cliente.getNome();
        }
        if (campo == ClienteInfo.CAMPO_CPF) {
            return cliente.getCpf();
        }
        if (campo == ClienteInfo.CAMPO_TELEFONE) {
            return cliente.getTelefone();
        }
        if (campo == ClienteInfo.CAMPO_CELULAR) {
            return cliente.getCelular();
        }
        
        if(campo == ClienteInfo.CAMPO_ENDERECO){
            
        }
        return EntidadeInfo.getValueCampo(cliente, campo);
    }

}
