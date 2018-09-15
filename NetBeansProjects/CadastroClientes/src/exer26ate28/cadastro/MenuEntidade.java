package exer26ate28.cadastro;

import exer26ate28.produto.model.Entidade;
import exer26ate28.produto.model.InfoCampo;
import exer26ate28.produto.repositorio.Repositorio;
import exer26ate28.produto.validacao.Erro;
import exer26ate28.produto.validacao.ValidadorEntidade;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 89087
 * @param <R>
 */
public abstract class MenuEntidade<R extends Entidade> extends Menu {

    private final ValidadorEntidade validador;
    private final Repositorio<R> repositorio;
    private final Map<String, InfoCampo> campos;

    public MenuEntidade(Scanner teclado, Repositorio<R> repositorio, ValidadorEntidade<R> validador, Map<String, InfoCampo> campos) {
        super(teclado);
        this.validador = validador;
        this.repositorio = repositorio;
        this.campos = campos;
    }

    public Repositorio<R> getRepositorio() {
        return repositorio;
    }

    public ValidadorEntidade<R> getValidador() {
        return validador;
    }

    public void listar() {
        new MenuOrdenacao("LISTAR", getTeclado(), getRepositorio(), campos.values()).mostrarMenu();
    }

    abstract public void solicitarInfos(R obj, boolean permitirNulos);

    public abstract void adicionar();

    public void adicionar(R obj) {
        solicitarInfos(obj, false);
        repositorio.salvar(obj);
    }

    public void editar() {
        System.out.println("EDITAR");
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forne�a o ID a ser editado:");
            String entrada = getInput();
            Erro erro = getValidador().validarId(entrada);
            if (erro == null) {
                Entidade obj = getRepositorio().buscarPorId(Long.parseLong(entrada));
                if (obj != null) {
                    solicitarInfos((R) obj, true);
                    getRepositorio().salvar((R) obj);
                } else {
                    System.out.println("ID inexistente.");
                }
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não Há objetos cadastrados!");
        }
    }

    public void remover() {
        System.out.println("REMOVER");
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o ID a ser removido:");
            String entrada = getInput();
            Erro erro = getValidador().validarId(entrada);
            if (erro == null) {
                Entidade obj = getRepositorio().buscarPorId(Long.parseLong(entrada));
                if (obj != null) {
                    getRepositorio().remover((R) obj);
                } else {
                    System.out.println("ID inexistente.");
                }
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("N�o h� objetos cadastrados!");
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
