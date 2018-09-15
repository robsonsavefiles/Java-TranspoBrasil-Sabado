package exercicio_veiculo.cadastro;

import exercicio_veiculo.repositorio.RepositorioMarca;
import exercicio_veiculo.model.Marca;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class CadastroMarca {

    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_LISTAR = "2";
    private static final String OPCAO_EDITAR = "3";
    private static final String OPCAO_REMOVER = "4";
    private static final String OPCAO_SAIR = "5";

    private Scanner teclado;

    public CadastroMarca(Scanner teclado) {
        this.teclado = teclado;
    }

    public CadastroMarca() {
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("\nMENU MARCAS");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar marca");
            System.out.println(OPCAO_LISTAR + " - Listar marcas");
            System.out.println(OPCAO_EDITAR + " - Editar marca");
            System.out.println(OPCAO_REMOVER + " - Remover marca");
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
        System.out.println("\nCADASTRO DE MARCA");

        System.out.println("Nome:");
        String nome = teclado.nextLine();

        cadastrar(nome);
        System.out.println("Marca cadastrada com sucesso!");
    }

    private void cadastrar(String nome) {
        RepositorioMarca repositorioProduto = new RepositorioMarca();
        Marca produto = new Marca(nome);
        repositorioProduto.salvar(produto);
    }

    private void listar() {
        System.out.println("\nLISTA DE MARCAS");
        RepositorioMarca repositorio = new RepositorioMarca();
        System.out.println(repositorio.marcasToString());
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE MARCAS");
        RepositorioMarca repositorioMarca = new RepositorioMarca();

        System.out.println("ForneÃ§a o ID da marca:");
        Long id = Long.parseLong(teclado.nextLine());
        Marca marca = repositorioMarca.getPorId(id);
        if (marca != null) {
            System.out.println("Informe o novo nome ou enter para permanecer " + marca.getNome());
            String nome = teclado.nextLine();

            marca.setNome(!"".equalsIgnoreCase(nome) ? nome : marca.getNome());
            repositorioMarca.salvar(marca);
            System.out.println("Marca editado com sucesso.");
        } else {
            System.out.println("Marca inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE MARCA");
        RepositorioMarca repositorioMarca = new RepositorioMarca();

        System.out.println("Forneça o ID da marca:");
        Long id = Long.parseLong(teclado.nextLine());
        Marca marca = repositorioMarca.getPorId(id);
        if (marca != null) {
            repositorioMarca.remover(marca);
            System.out.println("Marca removida com sucesso.");
        } else {
            System.out.println("Marca inexistente.");
        }
    }
}
