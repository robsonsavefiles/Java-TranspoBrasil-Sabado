package exer26ate28.produto.repositorio;

import exer26ate28.produto.model.Cliente;
import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.validacao.ValidadorEntidade;
import exer26ate28.produto.validacao.ValidadorCliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 78522
 */
public class RepositorioCliente implements Repositorio<Cliente> {

    private final static String FILE_NAME = "clientes.txt";

    private static List<Cliente> objs;
    private static RepositorioCliente repositorio;

    private RepositorioCliente() {
        objs = lerObjetosDoArquivo();
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
    public List<Cliente> getTodos() {
        return objs;
    }

    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> retorno = new ArrayList();
        objs.stream().filter((obj) -> (obj.getNome().equals(nome))).forEach((obj) -> retorno.add(obj));
        return retorno;
    }

    @Override
    public ValidadorEntidade getValidador() {
        return new ValidadorCliente();
    }

    @Override
    public List<Cliente> getTodos(InfoCampo campo) {
        List<Cliente> lista = getTodos();

        if (campo == Cliente.CAMPO_ID) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> Long.compare(v1.getId(), v2.getId()));
        }
        if (campo == Cliente.CAMPO_NOME) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getNome().compareTo(v2.getNome()));
        }
        if (campo == Cliente.CAMPO_NOME_PAI) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getNomePai().compareTo(v2.getNomePai()));
        }
        if (campo == Cliente.CAMPO_NOME_MAE) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getNomeMae().compareTo(v2.getNomeMae()));
        }
        if (campo == Cliente.CAMPO_DATA_NASCIMENTO) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getDataNascimento().compareTo(v2.getDataNascimento()));
        }
        if (campo == Cliente.CAMPO_CPF) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getCpf().compareTo(v2.getCpf()));
        }
        if (campo == Cliente.CAMPO_TELEFONE) {
            Collections.sort(lista, (Cliente v1, Cliente v2) -> v1.getTelefone().compareTo(v2.getTelefone()));
        }

        return lista;
    }
}
