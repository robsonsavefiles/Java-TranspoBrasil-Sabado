package exercicios.veiculo.cadastro;

import exercicios.veiculo.model.Entidade;
import exercicios.veiculo.model.InfoCampo;
import exercicios.veiculo.repositorio.Repositorio;
import exercicios.veiculo.validacao.Erro;
import exercicios.veiculo.validacao.ValidadorEntidade;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 78522
 * @param <T>
 */
public abstract class MenuEntidade<T extends Entidade> extends Menu {

    private final ValidadorEntidade validador;
    private final Repositorio<T> repositorio;
    private final Map<String, InfoCampo> campos;

    public MenuEntidade(Scanner teclado, Repositorio<T> repositorio, ValidadorEntidade<T> validador, Map<String, InfoCampo> campos) {
        super(teclado);
        this.validador = validador;
        this.repositorio = repositorio;
        this.campos = campos;
    }

    public Repositorio<T> getRepositorio() {
        return repositorio;
    }

    public ValidadorEntidade<T> getValidador() {
        return validador;
    }

    public void listar() {
        new MenuOrdenacao("LISTAR", getTeclado(), getRepositorio(), campos.values()).mostrarMenu();
    }

    abstract public void solicitarInfos(T obj, boolean permitirNulos);

    public abstract void adicionar();

    public void adicionar(T obj) {
        solicitarInfos(obj, false);
        repositorio.salvar(obj);
    }

    public void editar() {
        System.out.println("EDITAR");
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o ID a ser editado:");
            String entrada = getInput();
            Erro erro = getValidador().validarId(entrada);
            if (erro == null) {
                Entidade obj = getRepositorio().buscarPorId(Long.parseLong(entrada));
                if (obj != null) {
                    solicitarInfos((T) obj, true);
                    getRepositorio().salvar((T) obj);
                } else {
                    System.out.println("ID inexistente.");
                }
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não há objetos cadastrados!");
        }
    }

    public void remover() {
        System.out.println("REMOVER");
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o ID a ser removida:");
            String entrada = getInput();
            Erro erro = getValidador().validarId(entrada);
            if (erro == null) {
                Entidade obj = getRepositorio().buscarPorId(Long.parseLong(entrada));
                if (obj != null) {
                    getRepositorio().remover((T) obj);
                } else {
                    System.out.println("ID inexistente.");
                }
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não há objetos cadastrados!");
        }
    }

    public void imprimirErro(Erro erro) {
        System.out.println(erro.getMensagem());
    }

    public String solicitarParametro(InfoCampo campo, boolean permitirNulos) {
        while (true) {
            System.out.println(campo.getNome() + ":");
            String input = getInput();
            if (parametroIsValido(campo, input, permitirNulos)) {
                return input;
            }
        }
    }

    private boolean parametroIsValido(InfoCampo campo, String input, boolean permitirNulos) {
        if (permitirNulos && input.isEmpty()) {
            return true;
        }

        Erro erro = validador.validarCampo(campo, input);
        if (erro == null) {
            return true;
        } else {
            imprimirErro(erro);
            return false;
        }
    }

}
