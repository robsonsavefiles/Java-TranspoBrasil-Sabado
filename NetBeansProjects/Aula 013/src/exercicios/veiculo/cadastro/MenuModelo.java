package exercicios.veiculo.cadastro;

import exercicios.veiculo.cadastro.formatters.ModeloFormatter;
import exercicios.veiculo.model.Marca;
import exercicios.veiculo.model.Modelo;
import exercicios.veiculo.repositorio.RepositorioModelo;
import exercicios.veiculo.validacao.ValidadorModelo;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuModelo extends MenuEntidade<Modelo> {

    private static final String TITULO = "MENU DE MODELOS";

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu(0, "Cadastrar novo modelo");
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu(1, "Editar um modelo existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu(2, "Remover um modelo");
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu(3, "Listar todos os modelos");
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(4, "Voltar ao menu anterior");

    public MenuModelo(Scanner teclado) {
        super(teclado, RepositorioModelo.getInstance(), new ValidadorModelo(), Modelo.CAMPOS);
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
    public void solicitarInfos(Modelo obj, boolean permitirNulos) {
        String nome = ModeloFormatter.getNome(solicitarParametro(Modelo.CAMPO_NOME, permitirNulos));
        obj.setNome(nome == null ? obj.getNome() : nome);
        Integer ano = ModeloFormatter.getAno(solicitarParametro(Modelo.CAMPO_ANO, permitirNulos));
        obj.setAno(ano == null ? obj.getAno() : ano);
        Marca marca = ModeloFormatter.getMarca(solicitarParametro(Modelo.CAMPO_MARCA, permitirNulos));
        obj.setMarca(marca == null ? obj.getMarca() : marca);
    }

    @Override
    public void adicionar() {
        adicionar(new Modelo());
    }

}
