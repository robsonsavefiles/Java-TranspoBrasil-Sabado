package exer26ate28.cadastro;

import exer26ate28.produto.cadastro.formatters.VeiculoFormatter;
import exer26ate28.produto.model.Modelo;
import exer26ate28.produto.model.Veiculo;
import exer26ate28.produto.repositorio.RepositorioVeiculo;
import exer26ate28.produto.validacao.Erro;
import exer26ate28.produto.validacao.ValidadorModelo;
import exer26ate28.produto.validacao.ValidadorVeiculo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuVeiculo extends MenuEntidade<Veiculo> {

    private static final String TITULO = "MENU DE PRODUTOS";

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu(0, "Cadastrar novo Cliente:");
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu(1, "Editar um CLiente:");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu(2, "Remover um Produto:");
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu(3, "Listar todos os Produto:");
    public static final OpcaoMenu OPCAO_LISTAR_ANO_FABRICACAO = new OpcaoMenu(4, "Listar Produto fabrica��o");
    public static final OpcaoMenu OPCAO_LISTAR_ANO_MODELO = new OpcaoMenu(5, "Listar ve�culos por ano de modelo");
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(6, "Voltar ao menu anterior");

    public MenuVeiculo(Scanner teclado) {
        super(teclado, RepositorioVeiculo.getInstance(), new ValidadorVeiculo(), Veiculo.CAMPOS);
        setTitulo(TITULO);
        addOpcao(OPCAO_CADASTRAR);
        addOpcao(OPCAO_EDITAR);
        addOpcao(OPCAO_REMOVER);
        addOpcao(OPCAO_LISTAR_TODOS);
        addOpcao(OPCAO_LISTAR_ANO_FABRICACAO);
        addOpcao(OPCAO_LISTAR_ANO_MODELO);
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
        if (opcao == OPCAO_LISTAR_ANO_FABRICACAO) {
            listarPorAnoFabricacao();
        }
        if (opcao == OPCAO_LISTAR_ANO_MODELO) {
            listarPorAnoModelo();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);

    }

    @Override
    public void solicitarInfos(Veiculo obj, boolean permitirNulos) {
        String placa = VeiculoFormatter.getPlaca(solicitarParametro(Veiculo.CAMPO_PLACA, permitirNulos));
        obj.setPlaca(placa == null ? obj.getPlaca() : placa);

        String cor = VeiculoFormatter.getCor(solicitarParametro(Veiculo.CAMPO_COR, permitirNulos));
        obj.setCor(cor == null ? obj.getCor() : cor);

        Integer anoFabricacao = VeiculoFormatter.getAnoFabricacao(solicitarParametro(Veiculo.CAMPO_ANO_FABRICACAO, permitirNulos));
        obj.setAnoFabricacao(anoFabricacao == null ? obj.getAnoFabricacao() : anoFabricacao);

        Modelo modelo = VeiculoFormatter.getModelo(solicitarParametro(Veiculo.CAMPO_MODELO, permitirNulos));
        obj.setModelo(modelo == null ? obj.getModelo() : modelo);
    }

    @Override
    public void adicionar() {
        adicionar(new Veiculo());
    }

    public void listarPorPlaca() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forne�a a placa do ve�culo:");
            String entrada = getInput();
            Erro erro = ((ValidadorVeiculo) getValidador()).validarPlaca(entrada);
            if (erro == null) {
                Veiculo veiculo = ((RepositorioVeiculo) getRepositorio()).buscarPorPlaca(entrada);
                if (veiculo != null) {
                    System.out.println(veiculo);
                }
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("N�o h� ve�culos cadastrados!");
        }
    }

    public void listarPorAnoFabricacao() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forne�a o ano de fabrica��o:");
            String entrada = getInput();
            Erro erro = ((ValidadorVeiculo) getValidador()).validarAnoFabricacao(entrada);
            if (erro == null) {
                List<Veiculo> veiculos = ((RepositorioVeiculo) getRepositorio()).buscarPorAnoFabricacao(Integer.parseInt(entrada));
                veiculos.stream().forEach((veiculo) -> System.out.println(veiculo.infoLinhaString()));
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("N�o h� ve�culos cadastrados!");
        }
    }

    public void listarPorAnoModelo() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forne�a o ano do modelo:");
            String entrada = getInput();
            Erro erro = new ValidadorModelo().validarAno(entrada);
            if (erro == null) {
                List<Veiculo> veiculos = ((RepositorioVeiculo) getRepositorio()).buscarPorAnoModelo(Integer.parseInt(entrada));
                veiculos.stream().forEach((veiculo) -> System.out.println(veiculo.infoLinhaString()));
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("N�o h� ve�culos cadastrados!");
        }
    }

}
