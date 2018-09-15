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
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar ve�culo");
            System.out.println(OPCAO_LISTAR + " - Listar ve�culos");
            System.out.println(OPCAO_LISTAR_POR_MARCA + " - Listar ve�culos por marca");
            System.out.println(OPCAO_LISTAR_POR_MODELO + " - Listar ve�culos por modelo");
            System.out.println(OPCAO_LISTAR_POR_ANO_FABRICACAO + " - Listar ve�culos por ano de fabrica��o");
            System.out.println(OPCAO_LISTAR_POR_ANO_MODELO + " - Listar ve�culos por modelo de ano");
            System.out.println(OPCAO_LISTAR_POR_ANO_FABRICACAO_ATE + " - Listar ve�culos por per�odo");
            System.out.println(OPCAO_LISTAR_POR_ANO_MODELO_ATE + " - Listar ve�culos por modelo por per�odo");
            System.out.println(OPCAO_EDITAR + " - Editar ve�culo");
            System.out.println(OPCAO_REMOVER + " - Remover ve�culo");
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
        System.out.println("\nCADASTRO DE VE�CULO");
        RepositorioModelo repositorioModelo = new RepositorioModelo();

        System.out.println("Ano de Fabrica��o:");
        int ano = Integer.parseInt(teclado.nextLine());

        if (repositorioModelo.listar().isEmpty()) {
            System.out.println("N�o h� modelos cadastratos! Cadastre um novo modelo.");
            new CadastroModelo(teclado).cadastrar();
        }
        System.out.println("\nModelos dispon�veis:");
        System.out.println(repositorioModelo.modelosToString());
        System.out.println("Forne�a o ID do Modelo para o ve�culo:");

        Modelo modelo;
        do {
            modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
            if (modelo == null) {
                System.out.println("ID inv�lido.");
            }
        } while (modelo == null);

        cadastrar(modelo, ano);
        System.out.println("Ve�culo cadastrado com sucesso!");
    }

    private void cadastrar(Modelo modelo, int ano) {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        Veiculo veiculo = new Veiculo(modelo, ano);
        repositorio.salvar(veiculo);
    }

    private void listar() {
        System.out.println("\nLISTA DE VE�CULOS");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println(repositorio.veiculosToString());
    }

    private void editar() {
        System.out.println("\nEDI��O DE VE�CULO");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        RepositorioModelo repositorioModelo = new RepositorioModelo();

        System.out.println("Forne�a o ID do ve�culo:");
        Long id = Long.parseLong(teclado.nextLine());
        Veiculo veiculo = repositorio.getPorId(id);
        if (veiculo != null) {
            System.out.println("Informe o novo ano de fabrica��o ou enter para permanecer " + veiculo.getAnoFabricacao());
            String ano = teclado.nextLine();

            System.out.println("Informe o ID do novo modelo ou enter para permanecer " + veiculo.getModelo().getNome());
            System.out.println(repositorioModelo.modelosToString());
            String sModelo = teclado.nextLine();
            Modelo modelo = null;
            do {
                if (!"".equalsIgnoreCase(sModelo)) {
                    modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
                    if (modelo == null) {
                        System.out.println("ID inv�lido.");
                    }
                }
            } while (modelo == null && !"".equalsIgnoreCase(sModelo));

            veiculo.setModelo(!"".equalsIgnoreCase(sModelo) ? modelo : veiculo.getModelo());
            veiculo.setAnoFabricacao(!"".equalsIgnoreCase(ano) ? Integer.parseInt(ano) : veiculo.getAnoFabricacao());
            repositorio.salvar(veiculo);
            System.out.println("Ve�culo editado com sucesso.");
        } else {
            System.out.println("Ve�culo inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMO��O DE VE�CULO");
        RepositorioVeiculo repositorio = new RepositorioVeiculo();

        System.out.println("Forne�a o ID do ve�culo:");
        Long id = Long.parseLong(teclado.nextLine());
        Veiculo veiculo = repositorio.getPorId(id);
        if (veiculo != null) {
            repositorio.remover(veiculo);
            System.out.println("Ve�culo removido com sucesso.");
        } else {
            System.out.println("Ve�culo inexistente.");
        }
    }

    private void listarPorMarca() {
        RepositorioMarca repositorioMarca = new RepositorioMarca();
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR MARCA");
        System.out.println("Marcas cadastradas:");
        System.out.println(repositorioMarca.marcasToString());
        System.out.println("Forne�a o ID desejado para listar:");
        Marca marca;
        do {
            marca = repositorioMarca.getPorId(Long.parseLong(teclado.nextLine()));
            if (marca == null) {
                System.out.println("ID inv�lido");
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
        System.out.println("Forne�a o ID desejado para listar:");
        Modelo modelo;
        do {
            modelo = repositorioModelo.getPorId(Long.parseLong(teclado.nextLine()));
            if (modelo == null) {
                System.out.println("ID inv�lido");
            }
        } while (modelo == null);

        System.out.println(repositorio.veiculosToString(repositorio.listarPorModelo(modelo)));
    }

    private void listarPorAnoFabricacao() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR ANO DE FABRICA��O");
        System.out.println("Forne�a o ano desejado para listar:");
        int ano = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoFabricacao(ano)));
    }

    private void listarPorAnoModelo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR ANO DE MODELO");
        System.out.println("Forne�a o ano desejado para listar:");
        int ano = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoModelo(ano)));
    }

    private void listarPorAnoFabricacaoPeriodo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR PER�ODO DE FABRICA��O");
        System.out.println("Forne�a o ano \"de\" para listar:");
        int anoDe = Integer.parseInt(teclado.nextLine());
        System.out.println("Forne�a o ano \"at�\" para listar:");
        int anoAte = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoFabricacaoPeriodo(anoDe, anoAte)));
    }

    private void listarPorAnoModeloPeriodo() {
        RepositorioVeiculo repositorio = new RepositorioVeiculo();
        System.out.println("\nLISTAR POR PER�ODO DE MODELO");
        System.out.println("Forne�a o ano \"de\" para listar:");
        int anoDe = Integer.parseInt(teclado.nextLine());
        System.out.println("Forne�a o ano \"at�\" para listar:");
        int anoAte = Integer.parseInt(teclado.nextLine());
        System.out.println(repositorio.veiculosToString(repositorio.listarPorAnoModeloPeriodo(anoDe, anoAte)));
    }
}
