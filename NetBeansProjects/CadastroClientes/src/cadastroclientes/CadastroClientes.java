package cadastroclientes;


import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import cadastroclientes.ClientesGravar;

public class CadastroClientes {

    Scanner teclado = new Scanner(System.in);

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void menu() {
        String opcao = "";
        do {
            System.out.println("OFICINA TA NA MAO");
            System.out.println("=====Escolha a opção desejada=====");
            System.out.println("1 - Inserir Novo Cliente:");
            System.out.println("2 - Editar Cliente:");
            System.out.println("3 - Listar todos:");
            System.out.println("4 - Remover Cliente:");
            System.out.println("5 - Sair da aplicação");
            opcao = teclado.nextLine();
            tratarOpcoes(opcao);
        } while (!opcao.equalsIgnoreCase("5"));

    }

    public void tratarOpcoes(String opcao) {

        switch (opcao) {
            case "1":
                inserir();
                break;
            case "2":
                editar();
                break;
            case "3":
                menu2();
                break;
            case "4":
                remover();
                break;
            case "5":
                break;

        }
    }

    public void menu2() {
        String op = "";

        do {
            System.out.println("===== Deseja listar por =====");
            System.out.println("1 - Buscar Cliente pelo ID:");
            System.out.println("2 - Buscar Cliente pelo Nome:");
            System.out.println("3 - Buscar Clinte pelo CPF:");

            op = teclado.nextLine();
            tratarListar(op);

        } while (!op.equalsIgnoreCase("8"));
    }

// *Telefone
// *Endereço(Rua, numero,complemento,bairro,cidade,cep,estado)
    private void inserir() {

        System.out.println("=============CADASTRANDO NOVO CLIENTE==============");

        System.out.println("Informe o Nome:");
        String nome = teclado.nextLine();
        System.out.println("Informe o CPF:");
        String cpf = teclado.nextLine();
        System.out.println("Informe a data Nascimento :dd/mm/aaaa");
        String dataNascimento = teclado.nextLine();
        System.out.println("Nome do Pai:");
        String nomePai = teclado.nextLine();
        System.out.println("Nome da Mae:");
        String nomeMae = teclado.nextLine();
        System.out.println("Informe o Telefone:");
        String telefone = teclado.nextLine();
        System.out.println("Informe o Endereço:");
        System.out.println("Rua:");
        String rua = teclado.nextLine();
        System.out.println("Numero:");
        String numero = teclado.nextLine();
        System.out.println("Complemento:");
        String complemento = teclado.nextLine();
        System.out.println("Informe o Bairro:");
        String bairro = teclado.nextLine();
        System.out.println("Cidade:");
        String cidade = teclado.nextLine();
        System.out.println("Estado:");
        String estado = teclado.nextLine();
        System.out.println("CEP:");
        String cep = teclado.nextLine();

        novoCliente(nome, cpf,telefone);

    }

    private void novoCliente(String nome, String cpf, String telefone) {
        RepositorioClientes repositorio = new RepositorioClientes();
        ValidadorCliente validadorCliente = new ValidadorCliente();
       // Cliente novoCliente = new Cliente(Long.MIN_VALUE, nome, cpf, telefone);
        //repositorio.salvar(novoCliente);
        File file = new File("Clientes.txt");

    }

    private void editar() {

        Date agora = new Date();
        File file = new File("Clientes.txt");
        System.out.println("Editando um Cliente");
        System.out.println("Digite o id do Cliente para ser editado");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioClientes repositorio = new RepositorioClientes();
        Cliente cliente = repositorio.buscarPorId(id);
        if (cliente != null) {

            System.out.printf("Informe o NOME  ou enter para permanecer %s :", cliente.getNome());
            String nome = teclado.nextLine();

            System.out.printf("Informe o CPF ou enter para permanecer %s :", cliente.getCpf(nome));
            String cpf = teclado.nextLine();

            System.out.printf("Informe  ou enter para permanecer %s :", cliente.getDataNascimento());
            String dataNascimento = teclado.nextLine();

            System.out.printf("Informe o nome da Mae ou enter para permanecer %s :", cliente.getNomeMae());
            String nomeMae = teclado.nextLine();

            System.out.printf("Informe o nome da Mae ou enter para permanecer %s :", cliente.getNomePai());
            String nomePai = teclado.nextLine();

            System.out.printf("Informe Telefone ou enter para permanecer %s :", cliente.getNomePai());
            String telefone = teclado.nextLine();

            System.out.printf("Informe Endereço ou enter para permanecer %s :");
            System.out.println("Informe a rua para editar:");
            String rua = teclado.nextLine();
            System.out.println("Informe a numero para editar:");
            String numero = teclado.nextLine();
            System.out.println("Informe a complemento para editar:");
            String complemento = teclado.nextLine();
            System.out.println("Informe a bairro para editar:");
            String bairro = teclado.nextLine();
            System.out.println("Informe a cidade para editar:");
            String cidade = teclado.nextLine();
            System.out.println("Informe a estado para editar:");
            String estado = teclado.nextLine();
            System.out.println("Informe a cep para editar:");
            String cep = teclado.nextLine();

            if (!"".equalsIgnoreCase(cpf)) {
                cliente.setCpf((cpf));
            }

            if (!"".equalsIgnoreCase(telefone)) {
                cliente.setTelefone(telefone);
            }

            cliente.setNome(!"".equalsIgnoreCase(nome) ? nome : cliente.getNome());
            cliente.setCpf(!"".equalsIgnoreCase(cpf) ? cpf : cliente.getCpf(cpf));
            cliente.setTelefone(!"".equalsIgnoreCase(telefone) ? telefone : cliente.getTelefone());

            // veiculo.setAnoFabricacao(anoFabricacao != veiculo.getAnoFabricacao()? anoFabricacao : veiculo.getAnoFabricacao());
            //  veiculo.setAnoModelo(anoModelo != veiculo.getAnoModelo() ? anoModelo : veiculo.getAnoModelo());
            //          produto.setValor(!"".equalsIgnoreCase(valor)? valor :produto.getValor());
            nome = cliente.getNome();
            cpf = cliente.getCpf(cpf);
            telefone = cliente.getTelefone();

            cliente.setDataAltercao(agora);
            ClientesGravar.gravarUtilizandoFilerPrintWriter(file, cliente);
            repositorio.salvar(cliente);
        }

    }

    private void buscarporId() {
        String op = "";
        tratarListar(op);

        System.out.println("============================Lista de todos os veiculos=============================");
        RepositorioClientes repositorio = new RepositorioClientes();
        ArrayList<Cliente> lista = repositorio.buscarTodos();
        if (lista.isEmpty()) {
            System.out.println("Não existe veiculos cadastrados");
        } else {
            System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n", "ID", "PLACA", "MARCA", "MODELO", "COR", "ANOMODELO", "ANOFABRICAÇÃO");
            for (Cliente cliente : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(null),
                        cliente.getTelefone());

                
            }
        }
    }

    private void remover() {
        System.out.println("Removendo o veiculo");
        System.out.println("Digiete o id do veiculo a ser removido");
        Long id = Long.parseLong(teclado.nextLine());
        RepositorioClientes repositorio = new RepositorioClientes();
        Cliente cliente = repositorio.buscarPorId(id);
        if (cliente != null) {
            repositorio.remover(cliente);
        }
        System.out.println("Id não encontrado");
    }

    private void listarNome(Cliente cliente) {
        System.out.println("============================Listar Todos Clientes============================");

        System.out.println("Digite nome  do cliente:");
        String nome = (teclado.nextLine());
        RepositorioClientes repositorio = new RepositorioClientes();

        if (cliente.getNome().equalsIgnoreCase(nome)) {
            System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n", "ID", "NOME", "CPF", "TELEFONE");

            System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(null),
                        cliente.getTelefone());


        } else {
            System.out.println("Veiculo não cadastrado");
        }

    }

    private void buscarPorCpf() {

        System.out.println("Lista de todos os CPF cadastrados");
        RepositorioClientes repositorio = new RepositorioClientes();
       // ArrayList<Cliente> listaModelo = repositorio.listarPorCpf(null);
//        if (listaModelo.isEmpty()) {
//            System.out.println("Não existe Clientes cadastrados");
//        } else {
//             System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n", "ID", "NOME", "CPF", "TELEFONE");
//            for (Cliente cliente : listaModelo) {
//                  System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n",
//                        cliente.getId(),
//                        cliente.getNome(),
//                        cliente.getCpf(null),
//                        cliente.getTelefone());
//
//            }
//        }
    }

    private void tratarListar(String op) {

        switch (op) {
            case "1":
                compararPorId();
                break;
            case "2":
                compararPorNome();
                break;
            case "3":
                compararPorCpf();
                break;
           

        }
    }

    private void compararPorId() {
        RepositorioClientes repositorio = new RepositorioClientes();
        ArrayList<Cliente> lista = repositorio.buscarTodos();
        Comparator<Cliente> comparatorPorId = new Comparator<Cliente>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        Collections.sort(lista, comparatorPorId);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
         System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n", "ID", "NOME", "CPF", "TELEFONE");
            for (Cliente cliente : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(null),
                        cliente.getTelefone());

            }
        }

    }

    private void compararPorCpf() {
        RepositorioClientes repositorio = new RepositorioClientes();
        ArrayList<Cliente> lista = repositorio.buscarTodos();
        Comparator<Cliente> comparatorPorCpf = new Comparator<Cliente>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getCpf(null).compareTo(o2.getCpf(null));
            }
        };

        Collections.sort(lista, comparatorPorCpf);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
           System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n", "ID", "NOME", "CPF", "TELEFONE");
            for (Cliente cliente : lista) {
             System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(null),
                        cliente.getTelefone());
            }
        }
    }

    private void compararPorNome() {
        RepositorioClientes repositorio = new RepositorioClientes();
        ArrayList<Cliente> lista = repositorio.buscarTodos();
        Comparator<Cliente> comparatorPorNome = new Comparator<Cliente>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };

        Collections.sort(lista, comparatorPorNome);

        if (lista.isEmpty()) {
            System.out.println("Não existe contatos cadastrados");
        } else {
             System.out.printf("%-30s|%-30s|%-30s|%-30s\r\n", "ID", "NOME", "CPF", "TELEFONE");
            for (Cliente cliente : lista) {
                System.out.printf("%-30s|%-30s|%-30s|%-30s|%-30s\r\n",
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(null),
                        cliente.getTelefone());
            }
        }
    }

}
