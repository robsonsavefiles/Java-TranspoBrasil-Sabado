package exercicio_veiculo.cadastro;

import exercicio_veiculo.repositorio.RepositorioMarca;
import exercicio_veiculo.repositorio.RepositorioModelo;
import exercicio_veiculo.model.Marca;
import exercicio_veiculo.model.Modelo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class CadastroModelo {

    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_LISTAR = "2";
    private static final String OPCAO_EDITAR = "3";
    private static final String OPCAO_REMOVER = "4";
    private static final String OPCAO_SAIR = "5";

    private Scanner teclado;

    public CadastroModelo(Scanner teclado) {
        this.teclado = teclado;
    }

    public CadastroModelo() {
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("\nMENU MODELOS");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar modelo");
            System.out.println(OPCAO_LISTAR + " - Listar modelo");
            System.out.println(OPCAO_EDITAR + " - Editar modelo");
            System.out.println(OPCAO_REMOVER + " - Remover modelo");
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
            case OPCAO_EDITAR:
                editar();
                break;
            case OPCAO_REMOVER:
                remover();
                break;
        }
    }

    public void cadastrar() {
        System.out.println("\nCADASTRO DE MODELO");
        RepositorioMarca repositorioMarca = new RepositorioMarca();
        System.out.println("Nome:");
        String nome = teclado.nextLine();
        System.out.println("Ano:");
        int ano = Integer.parseInt(teclado.nextLine());

        if (repositorioMarca.listar().isEmpty()) {
            System.out.println("Não há marcas cadastratas! Cadastre uma nova marca.");
            new CadastroMarca(teclado).cadastrar();
        }
        System.out.println("\nMarcas disponíveis:");
        System.out.println(repositorioMarca.marcasToString());
        System.out.println("Forneça o ID da Marca para o modelo:");

        String sMarca = teclado.nextLine();
        Marca marca = null;
        do {
            if (!"".equalsIgnoreCase(sMarca)) {
                marca = repositorioMarca.getPorId(Long.parseLong(sMarca));
                if (marca == null) {
                    System.out.println("ID inválido.");
                }
            }
        } while (marca == null);

        cadastrar(marca, nome, ano);
        System.out.println("Modelo cadastrado com sucesso!");
    }

    private void cadastrar(Marca marca, String nome, int ano) {
        RepositorioModelo repositorio = new RepositorioModelo();
        Modelo modelo = new Modelo(marca, nome, ano);
        repositorio.salvar(modelo);
    }

    private void listar() {
        System.out.println("\nLISTA DE MODELOS");
        RepositorioModelo repositorio = new RepositorioModelo();
        System.out.println(repositorio.modelosToString());
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE MODELO");
        RepositorioModelo repositorio = new RepositorioModelo();
        RepositorioMarca repositorioMarca = new RepositorioMarca();

        System.out.println("Forneça o ID do modelo:");
        Long id = Long.parseLong(teclado.nextLine());
        Modelo modelo = repositorio.getPorId(id);
        if (modelo != null) {
            System.out.println("Informe o novo nome ou enter para permanecer " + modelo.getNome());
            String nome = teclado.nextLine();

            System.out.println("Informe o novo ano ou enter para permanecer " + modelo.getAno());
            String ano = teclado.nextLine();

            System.out.println("Informe o ID da nova marca ou enter para permanecer " + modelo.getMarca().getNome());
            System.out.println(repositorioMarca.marcasToString());
            String sMarca = teclado.nextLine();
            Marca marca;
            do {
                marca = repositorioMarca.getPorId(Long.parseLong(teclado.nextLine()));
                if (marca == null && !"".equalsIgnoreCase(sMarca)) {
                    System.out.println("ID inválido.");
                }
            } while (marca == null && !"".equalsIgnoreCase(sMarca));

            modelo.setMarca(!"".equalsIgnoreCase(sMarca) ? marca : modelo.getMarca());
            modelo.setNome(!"".equalsIgnoreCase(nome) ? nome : modelo.getNome());
            modelo.setAno(!"".equalsIgnoreCase(ano) ? Integer.parseInt(ano) : modelo.getAno());
            repositorio.salvar(modelo);
            System.out.println("Modelo editado com sucesso.");
        } else {
            System.out.println("Modelo inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE MODELO");
        RepositorioModelo repositorio = new RepositorioModelo();

        System.out.println("Forneça o ID do modelo:");
        Long id = Long.parseLong(teclado.nextLine());
        Modelo modelo = repositorio.getPorId(id);
        if (modelo != null) {
            repositorio.remover(modelo);
            System.out.println("Modelo removido com sucesso.");
        } else {
            System.out.println("Modelo inexistente.");
        }
    }
}
