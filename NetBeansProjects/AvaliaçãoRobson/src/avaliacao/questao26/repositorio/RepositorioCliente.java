package avaliacao.questao26.repositorio;

import avaliacao.questao26.info.ClienteInfo;
import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.model.Cliente;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.validacao.ValidadorCliente;
import avaliacao.questao26.validacao.ValidadorEntidade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioCliente implements Repositorio {

    private final static String FILE_NAME = "clientes.txt";
    private final static InfoCampo ORDEM_PADRAO = ClienteInfo.CAMPO_ID;

    private static List<Cliente> objs;
    private static RepositorioCliente repositorio;

    private RepositorioCliente() {
        objs = (List<Cliente>) lerObjetosDoArquivo();
    }

    public static RepositorioCliente getInstance() {
        if (repositorio == null) {
            repositorio = new RepositorioCliente();
        }
        return repositorio;
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public InfoCampo getOrdemPadrao() {
        return ORDEM_PADRAO;
    }

    @Override
    public List<Cliente> getTodos() {
        return ordenar(objs, ORDEM_PADRAO);
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorCliente();
    }

    @Override
    public List<Cliente> getTodosPorOrdem(InfoCampo campo) {
        return ordenar(getTodos(), campo);
    }

    @Override
    public List getPesquisaPorOrdem(InfoCampo campoPesquisa, String pesquisa, boolean exato, InfoCampo campoOrdem) {
        List<Cliente> retorno = new ArrayList();
        getTodos().stream().forEach((obj) -> {
            if (exato) {
                if ((String.valueOf(ClienteInfo.getValueCampo(obj, campoPesquisa))).equalsIgnoreCase(pesquisa)) {
                    retorno.add(obj);
                }
            } else {
                if ((String.valueOf(ClienteInfo.getValueCampo(obj, campoPesquisa))).toLowerCase().contains(pesquisa.toLowerCase())) {
                    retorno.add(obj);
                }
            }
        });
        return ordenar(retorno, campoOrdem);
    }

    @Override
    public List<Cliente> ordenar(List lista, InfoCampo campo) {
        List<Cliente> listaOrdenada = lista;
        if (campo == ClienteInfo.CAMPO_ID) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == ClienteInfo.CAMPO_NOME) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getNome().compareTo(v2.getNome()));
        }
        if (campo == ClienteInfo.CAMPO_CPF) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getCpf().compareTo(v2.getCpf()));
        }
        if (campo == ClienteInfo.CAMPO_TELEFONE) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getTelefone().compareTo(v2.getTelefone()));
        }
        if (campo == ClienteInfo.CAMPO_CELULAR) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getCelular().compareTo(v2.getCelular()));
        }
        return listaOrdenada;
    }

    @Override
    public String infoString(List<Entidade> objs) {
        String retorno = ClienteInfo.infoCabecalhoString().toUpperCase() + "\n";
        retorno = objs.stream().map((obj) -> ClienteInfo.infoLinhaString((Cliente) obj) + "\r\n").reduce(retorno, String::concat);
        return retorno;
    }

}
