package cadastro_hospital;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class CadastroPacientes {
    
    private String nome;
    private String situacao;
    private String procedimento;
    private Date dataEntrada;
    private Date dataSaida;
    
    private static final String OPCAO_CADASTRAR = "1";
    private static final String OPCAO_LISTAR = "2";
    private static final String OPCAO_EDITAR = "3";
    private static final String OPCAO_BUSCAR = "4";
    private static final String OPCAO_REMOVER = "5";
    private static final String OPCAO_SAIR = "6";

    private Scanner teclado;

    public CadastroPacientes() {
    }

    public CadastroPacientes(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            if (!opcao.isEmpty()) {
                System.out.println();
            }
            System.out.println("MENU PRINCIPAL");
            System.out.println(OPCAO_CADASTRAR + " - Cadastrar Paciente");
            System.out.println(OPCAO_LISTAR + " - Listar Paciente");
            System.out.println(OPCAO_EDITAR + " - Editar Paciente");
            System.out.println(OPCAO_BUSCAR + " - Buscar Paciente por nome");
            System.out.println(OPCAO_REMOVER + " - Remover Paciente");
            System.out.println(OPCAO_SAIR + " - Sair");
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
            case OPCAO_BUSCAR:
                buscarPorNome();
                break;
        }
    }

    private void cadastrar() {
        System.out.println("\nCADASTRO DE PACIENTE");

        System.out.println("Nome:");
        String nome = teclado.nextLine();
        System.out.println("Situaçao:");
        String situacao = teclado.nextLine();
        System.out.println("Procedimento:");
        String procedimento = teclado.nextLine();
        

        cadastrar(nome,situacao,procedimento);
    }

    private void cadastrar(String nome, String situacao, String procedimento) {
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
        Pacientes paciente = new Pacientes(nome, situacao,procedimento);
        repositorioPaciente.salvar(paciente);
    }

    private void listar() {
        System.out.println("\nLISTA DE PACIENTES");
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();

        List<Pacientes> pacientes = repositorioPaciente.listar();
        imprimeLista(pacientes);
    }

    private void editar() {
        System.out.println("\nEDIÇÃO DE PACIENTES");
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();

        System.out.println("Forneça o ID do Paciente:");
        Long id = Long.parseLong(teclado.nextLine());
        Pacientes pacientes = repositorioPaciente.getPorId(id);
        if (pacientes != null) {
            System.out.println("Informe o novo nome ou enter para permanecer " + pacientes.getNome());
            String nome = teclado.nextLine();

            System.out.println("Informe a nova Situaçao ou enter para permanecer " + pacientes.getSituacao());
            String situacao = teclado.nextLine();

            System.out.println("Informe o novo Procedimento ou enter para permanecer " + pacientes.getProcedimento());
            String procedimento = teclado.nextLine();

            pacientes.setNome(!"".equalsIgnoreCase(nome) ? nome : pacientes.getNome());
            pacientes.setProcedimento(!"".equalsIgnoreCase(situacao) ? situacao : pacientes.getSituacao());
            repositorioPaciente.salvar(pacientes);
            System.out.println("Paciente editado com sucesso.");
        } else {
            System.out.println("Paciente inexistente.");
        }
    }

    private void remover() {
        System.out.println("\nREMOÇÃO DE CLIENTE");
        RepositorioPaciente repositorioCliente = new RepositorioPaciente();

        System.out.println("Forneça o ID do paciente:");
        Long id = Long.parseLong(teclado.nextLine());
        Pacientes paciente = repositorioCliente.getPorId(id);
        if (paciente != null) {
            repositorioCliente.remover(paciente);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente inexistente.");
        }
    }

    private void buscarPorNome() {
        System.out.println("\nBUSCA DE PACIENTES");
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();

        System.out.println("Informe o nome inteiro ou parcial do Paciente que procura:");
        String nome = teclado.nextLine();
        List<Pacientes> resultados = repositorioPaciente.getPorNome(nome);

        if (!resultados.isEmpty()) {
            imprimeLista(resultados);
        } else {
            System.out.println("Não foi encontrado nenhum paciente.");
        }
    }

    private void imprimeLista(List<Pacientes> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.printf("%-20s|%-50s|%-80s|%-20s\r\n",
                    "ID", "NOME", "SITUACAO", "PROCEDIMENTO","DATA DE ENTRADA","DATA SAIDA");
            pacientes.stream().forEach((paciente) -> System.out.printf("%-20s|%-50s|%-80s|%-20s%-20s|%-50s\r\n",
                    paciente.getId(), paciente.getNome(),paciente.getSituacao(), paciente.getProcedimento(),
                    paciente.getDataEntrada(),paciente.getDataSaida()));
        }
    }
}
