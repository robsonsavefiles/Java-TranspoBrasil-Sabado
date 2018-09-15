package exer26ate28.cadastro;

import exer26ate28.produto.cadastro.formatters.MarcaFormatter;
import exer26ate28.produto.model.Marca;
import exer26ate28.produto.repositorio.RepositorioMarca;
import exer26ate28.produto.validacao.ValidadorMarca;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuMarca extends MenuEntidade<Marca> {

    private static final String TITULO = "MENU DE MARCAS";

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu(0, "Cadastrar nova marca");
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu(1, "Editar uma marca existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu(2, "Remover uma marca");
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu(3, "Listar todas as marcas");
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(4, "Voltar ao menu anterior");

    public MenuMarca(Scanner teclado) {
        super(teclado, RepositorioMarca.getInstance(), new ValidadorMarca(), Marca.CAMPOS);
        setTitulo(TITULO);
        addOpcao(OPCAO_CADASTRAR);
        addOpcao(OPCAO_EDITAR);
        addOpcao(OPCAO_REMOVER);
        addOpcao(OPCAO_LISTAR_TODOS);
        addOpcao(OPCAO_SAIR);

    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_CADASTRAR) {
            adicionar();
        }
        if (opcao == OPCAO_EDITAR) {
            editar();
        }
        if (opcao == OPCAO_REMOVER) {
            remover();
        }
        if (opcao == OPCAO_LISTAR_TODOS) {
            listar();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

    @Override
    public void solicitarInfos(Marca obj, boolean permitirNulos) {
        String nome = MarcaFormatter.getNome(solicitarParametro(Marca.CAMPO_NOME, permitirNulos));
        obj.setNome(nome == null ? obj.getNome() : nome);
    }

    @Override
    public void adicionar() {
        adicionar(new Marca());
    }
}
