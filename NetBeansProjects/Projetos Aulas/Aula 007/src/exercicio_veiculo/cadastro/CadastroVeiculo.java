package exercicio_veiculo.cadastro;

import exercicio_veiculo.repositorio.RepositorioMarca;
import exercicio_veiculo.repositorio.RepositorioModelo;
import exercicio_veiculo.repositorio.RepositorioVeiculo;
import exercicio_veiculo.model.Veiculo;
import exercicio_veiculo.model.Marca;
import exercicio_veiculo.model.Modelo;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class CadastroVeiculo {

    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_LISTAR = "2";
    private static final String OPCAO_LISTAR_POR_MARCA = "3";
    private static final String OPCAO_LISTAR_POR_MODELO = "4";
    private static final String OPCAO_LISTAR_POR_ANO_FABRICACAO = "5";
    private static final String OPCAO_LISTAR_POR_ANO_MODELO = "6";
    private static final String OPCAO_LISTAR_POR_ANO_FABRICACAO_ATE = "7";
    private static final String OPCAO_LISTAR_POR_ANO_MODELO_ATE = "8";
    private static final String OPCAO_EDITAR = "9";
    private static final String OPCAO_REMOVER = "10";
    private static final String OPCAO_SAIR = "11";

    private Scanner teclado;

    public CadastroVeiculo(Scanner teclado) {
        this.teclado = teclado;
    }

    public CadastroVeiculo() {
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("\nMENU VEICULOS");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar veículo");
            System.out.println(OPCAO_LISTAR + " - Listar veículos");
            System.out.println(OPCAO_LISTAR_POR_MARCA + " - Listar veículos por marca");
            System.out.println(OPCAO_LISTAR_POR_MODELO + " - Listar veículos por modelo");
            System.out.println(OPCAO_LISTAR_POR_ANO_FABRICACAO + " - Listar veículos por ano de fabricação");
            System.out.println(OPCAO_LISTAR_POR_ANO_MODELO + " - Listar veículos por modelo de ano");
            System.out.println(OPCAO_LISTAR_POR_ANO_FABRICACAO_ATE + " - Listar veículos por período");
            System.out.println(OPCAO_LISTAR_POR_ANO_MODELO_ATE + " - Listar veículos por modelo por período");
            System.out.println(OPCAO_EDITAR + " - Editar veículo");
            System.out.println(OPCAO_REMOVER + " - Remover veículo");
            System.out.println(OPCAO_SAIR + " - Voltar");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!OPCAO_SAIR.equalsIgnoreCase(opcao));
    }

    public void tratarOpcoes(String opcao) {
        switch (opcao) {
            case OPCAO_CADASTRAR:
                cadastrar();
                break;
            case OPCAO_LISTAR:
                listar();
                break;
            case OPCAO_LISTAR_POR_MARCA:
                listarPorMarca();
                break;
            case OPCAO_LISTAR_POR_MODELO:
                listarPorModelo();
                break;
            case OPCAO_LISTAR_POR_ANO_FABRICACAO:
                listarPorAnoFabricacao();
                break;
            case OPCAO_LISTAR_POR_ANO_MODELO:
                listarPorAnoModelo();
                break;
            case OPCAO_LISTAR_POR_ANO_FABRICACAO_ATE:
                listarPorAnoFabricacaoPeriodo();
                break;
            case OPCAO_LISTAR_POR_ANO_MODELO_ATE:
                listarPorAnoModeloPeriodo();
                break;
            case OPCAO_EDITAR:
                editar();
                break;
            case OPCAO_REMOVER:
                remover();
                break;
        }
    }

    private void cadastrar() {
        System.out.println("\nCADASTRO DE VEÍCULO");
        RepositorioModelo repositorioModelo = new RepositorioModelo();

        System.out.println("Ano de Fabricação:");
        int ano = Integer.parseInt(teclado.nextLine());

        if (repositorioModelo.listar().isEmpty()) {
            System.out.println("Não há modelos cadastratos! Cadastre um novo modelo.");
            new CadastroModelo(teclado).cadastrar();
        }
        System.out.println("\nModelos disponíveis:");
        System.out.println(repositorioModelo.modelosToString());
        System.out.println("Forneça o ID do Modelo para o veículo:");

        Modelo modelo;
        do {
            modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
            if (modelo == null) {
                System.out.println("ID inválido.");
            }
        } while (modelo == null);

        cadastrar(modelo, ano);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private void cadastrar(Modelo modelo, int ano) {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        Veiculo veiculo = new Veiculo(modelo, ano);
        repositorio.salvar(veiculo);
    }

    private void listar() {
        System.out.println("\nLISTA DE VEÍCULOS");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println(repositorio.veiculosToString());
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE VEÍCULO");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        RepositorioModelo repositorioModelo = new RepositorioModelo();

        System.out.println("Forneça o ID do veículo:");
        Long id = Long.parseLong(teclado.nextLine());
        Veiculo veiculo = repositorio.getPorId(id);
        if (veiculo != null) {
            System.out.println("Informe o novo ano de fabricação ou enter para permanecer " + veiculo.getAnoFabricacao());
            String ano = teclado.nextLine();

            System.out.println("Informe o ID do novo modelo ou enter para permanecer " + veiculo.getModelo().getNome());
            System.out.println(repositorioModelo.modelosToString());
            String sModelo = teclado.nextLine();
            Modelo modelo = null;
            do {
                if (!"".equalsIgnoreCase(sModelo)) {
                    modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
                    if (modelo == null) {
                        System.out.println("ID inválido.");
                    }
                }
            } while (modelo == null && !"".equalsIgnoreCase(sModelo));

            veiculo.setModelo(!"".equalsIgnoreCase(sModelo) ? modelo : veiculo.getModelo());
            veiculo.setAnoFabricacao(!"".equalsIgnoreCase(ano) ? Integer.parseInt(ano) : veiculo.getAnoFabricacao());
            repositorio.salvar(veiculo);
            System.out.println("Veículo editado com sucesso.");
        } else {
            System.out.println("Veículo inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE VEÍCULO");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();

        System.out.println("Forneça o ID do veículo:");
        Long id = Long.parseLong(teclado.nextLine());
        Veiculo veiculo = repositorio.getPorId(id);
        if (veiculo != null) {
            repositorio.remover(veiculo);
            System.out.println("Veículo removido com sucesso.");
        } else {
            System.out.println("Veículo inexistente.");
        }
    }

    private void listarPorMarca() {
        RepositorioMarca repositorioMarca = new RepositorioMarca();
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR MARCA");
        System.out.println("Marcas cadastradas:");
        System.out.println(repositorioMarca.marcasToString());
        System.out.println("Forneça o ID desejado para listar:");
        Marca marca;
        do {
            marca = repositorioMarca.getPorId(Long.parseLong(teclado.nextLine()));
            if (marca == null) {
                System.out.println("ID inválido");
            }
        } while (marca == null);

        System.out.println(repositorio.veiculosToString(repositorio.listarPorMarca(marca)));
    }

    private void listarPorModelo() {
        RepositorioModelo repositorioModelo = new RepositorioModelo();
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR MODELO");
        System.out.println("Modelos cadastrados:");
        System.out.println(repositorioModelo.modelosToString());
        System.out.println("Forneça o ID desejado para listar:");
        Modelo modelo;
        do {
            modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
            if (modelo == null) {
                System.out.println("ID inválido");
            }
        } while (modelo == null);

        System.out.println(repositorio.veiculosToString(repositorio.listarPorModelo(modelo)));
    }

    private void listarPorAnoFabricacao() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR ANO DE FABRICAÇÃO");
        System.out.println("Forneça o ano desejado para listar:");
        int ano = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoFabricacao(ano)));
    }

    private void listarPorAnoModelo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR ANO DE MODELO");
        System.out.println("Forneça o ano desejado para listar:");
        int ano = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoModelo(ano)));
    }

    private void listarPorAnoFabricacaoPeriodo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR PERÍODO DE FABRICAÇÃO");
        System.out.println("Forneça o ano \"de\" para listar:");
        int anoDe = Integer.parseInt(teclado.nextLine());
        System.out.println("Forneça o ano \"até\" para listar:");
        int anoAte = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoFabricacaoPeriodo(anoDe, anoAte)));
    }

    private void listarPorAnoModeloPeriodo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR PERÍODO DE MODELO");
        System.out.println("Forneça o ano \"de\" para listar:");
        int anoDe = Integer.parseInt(teclado.nextLine());
        System.out.println("Forneça o ano \"até\" para listar:");
        int anoAte = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoModeloPeriodo(anoDe, anoAte)));
    }
}
