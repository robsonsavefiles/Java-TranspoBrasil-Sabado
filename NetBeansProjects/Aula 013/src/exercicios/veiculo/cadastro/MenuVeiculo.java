package exercicios.veiculo.cadastro;

import exercicios.veiculo.cadastro.formatters.VeiculoFormatter;
import exercicios.veiculo.model.Modelo;
import exercicios.veiculo.model.Veiculo;
import exercicios.veiculo.repositorio.RepositorioVeiculo;
import exercicios.veiculo.validacao.Erro;
import exercicios.veiculo.validacao.ValidadorModelo;
import exercicios.veiculo.validacao.ValidadorVeiculo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuVeiculo extends MenuEntidade<Veiculo> {

    private static final String TITULO = "MENU DE VEÍCULOS";

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu(0, "Cadastrar novo veículo");
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu(1, "Editar um veículo existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu(2, "Remover um veículo");
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu(3, "Listar todos os veículos");
    public static final OpcaoMenu OPCAO_LISTAR_ANO_FABRICACAO = new OpcaoMenu(4, "Listar veículos por ano de fabricação");
    public static final OpcaoMenu OPCAO_LISTAR_ANO_MODELO = new OpcaoMenu(5, "Listar veículos por ano de modelo");
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
            System.out.println("Forneça a placa do veículo:");
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
            System.out.println("Não há veículos cadastrados!");
        }
    }

    public void listarPorAnoFabricacao() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o ano de fabricação:");
            String entrada = getInput();
            Erro erro = ((ValidadorVeiculo) getValidador()).validarAnoFabricacao(entrada);
            if (erro == null) {
                List<Veiculo> veiculos = ((RepositorioVeiculo) getRepositorio()).buscarPorAnoFabricacao(Integer.parseInt(entrada));
                veiculos.stream().forEach((veiculo) -> System.out.println(veiculo.infoLinhaString()));
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não há veículos cadastrados!");
        }
    }

    public void listarPorAnoModelo() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o ano do modelo:");
            String entrada = getInput();
            Erro erro = new ValidadorModelo().validarAno(entrada);
            if (erro == null) {
                List<Veiculo> veiculos = ((RepositorioVeiculo) getRepositorio()).buscarPorAnoModelo(Integer.parseInt(entrada));
                veiculos.stream().forEach((veiculo) -> System.out.println(veiculo.infoLinhaString()));
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não há veículos cadastrados!");
        }
    }

}
