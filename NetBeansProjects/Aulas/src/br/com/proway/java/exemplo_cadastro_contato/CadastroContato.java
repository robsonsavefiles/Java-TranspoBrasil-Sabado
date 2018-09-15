package exemplo_cadastro_contato;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class CadastroContato {

    private final static String OPCAO_CADASTRAR = "1";
    private final static String OPCAO_LISTAR = "2";
    private final static String OPCAO_EDITAR = "3";
    private final static String OPCAO_REMOVER = "4";
    private final static String OPCAO_SAIR = "5";

    private Scanner teclado;

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public CadastroContato() {
    }

    public CadastroContato(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("MENU PRINCIPAL");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar Contato");
            System.out.println(OPCAO_LISTAR + " - Listar Contato");
            System.out.println(OPCAO_EDITAR + " - Editar Contato");
            System.out.println(OPCAO_REMOVER + " - Remover Contato");
            System.out.println(OPCAO_SAIR + " - Sair");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!OPCAO_SAIR.equalsIgnoreCase(opcao));

    }

    private void tratarOpcoes(String opcao) {
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

    private void cadastrar() {
        System.out.println("\nCADASTRO DE CONTATO");
        System.out.println("Nome:");
        String nome = teclado.nextLine();
        System.out.println("E-mail:");
        String email = teclado.nextLine();
        System.out.println("Telefone:");
        String telefone = teclado.nextLine();
        cadastrar(nome, email, telefone);
    }

    private void cadastrar(String nome, String email, String telefone) {
        RepositorioContato repositorio = new RepositorioContato();
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setTelefone(telefone);
        repositorio.salvar(contato);
    }

    private void listar() {
        System.out.println("\nLISTA DE CONTATOS");
        RepositorioContato repositorio = new RepositorioContato();
        List<Contato> contatos = repositorio.listar();
        if (contatos.isEmpty()) {
            System.out.println("Não existem contatos cadastrados.");
        } else {
            System.out.printf("%-20s|%-50s|%-30s|%-20s\r\n",
                    "ID", "NOME", "EMAIL", "TELEFONE");
            contatos.stream().forEach((contato) -> System.out.printf("%-20s|%-50s|%-30s|%-20s\r\n",
                    contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone()));
        }
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE CONTATO");
        RepositorioContato repositorio = new RepositorioContato();

        System.out.println("Informe o ID do contato para edição: ");
        Long id = Long.parseLong(teclado.nextLine());
        Contato contato = repositorio.buscarPorId(id);
        if (contato != null) {
            System.out.println("Informe o novo nome ou enter para permanecer " + contato.getNome());
            String nome = teclado.nextLine();

            System.out.println("Informe o novo email ou enter para permanecer " + contato.getEmail());
            String email = teclado.nextLine();

            System.out.println("Informe o novo telefone ou enter para permanecer " + contato.getTelefone());
            String telefone = teclado.nextLine();

            contato.setNome(!"".equals(nome) ? nome : contato.getNome());
            contato.setEmail(!"".equals(email) ? email : contato.getEmail());
            contato.setTelefone(!"".equals(telefone) ? telefone : contato.getTelefone());
            repositorio.salvar(contato);
            System.out.println("Contato editado com sucesso.");
        } else {
            System.out.println("Contato inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE CONTATO");
        RepositorioContato repositorio = new RepositorioContato();

        System.out.println("Informe o ID do contato para remoção: ");
        Long id = Long.parseLong(teclado.nextLine());
        Contato contato = repositorio.buscarPorId(id);
        if (contato != null) {
            repositorio.remover(contato);
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato inexistente.");
        }
    }
}
