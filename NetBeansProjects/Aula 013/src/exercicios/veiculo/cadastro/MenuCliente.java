package exercicios.veiculo.cadastro;

import exercicios.veiculo.cadastro.formatters.ClienteFormatter;
import exercicios.veiculo.model.Cliente;
import exercicios.veiculo.model.Endereco;
import exercicios.veiculo.repositorio.RepositorioCliente;
import exercicios.veiculo.validacao.Erro;
import exercicios.veiculo.validacao.ValidadorCliente;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuCliente extends MenuEntidade<Cliente> {

    private static final String TITULO = "MENU DE CLIENTES";

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu(0, "Cadastrar novo cliente");
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu(1, "Editar um cliente existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu(2, "Remover um cliente");
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu(3, "Listar todos os clientes");
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(4, "Voltar ao menu anterior");

    public MenuCliente(Scanner teclado) {
        super(teclado, RepositorioCliente.getInstance(), new ValidadorCliente(), Cliente.CAMPOS);
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
    public void solicitarInfos(Cliente obj, boolean permitirNulos) {
        String nome = ClienteFormatter.getNome(solicitarParametro(Cliente.CAMPO_NOME, permitirNulos));
        obj.setNome(nome == null ? obj.getNome() : nome);

        LocalDate dataNascimento = ClienteFormatter.getDataNascimento(solicitarParametro(Cliente.CAMPO_DATA_NASCIMENTO, permitirNulos));
        obj.setDataNascimento(dataNascimento == null ? obj.getDataNascimento() : dataNascimento);

        String nomePai = ClienteFormatter.getNome(solicitarParametro(Cliente.CAMPO_NOME_PAI, permitirNulos));
        obj.setNomePai(nomePai == null ? obj.getNomePai() : nomePai);

        String nomeMae = ClienteFormatter.getNome(solicitarParametro(Cliente.CAMPO_NOME_MAE, permitirNulos));
        obj.setNomeMae(nomeMae == null ? obj.getNomeMae() : nomeMae);

        String cpf = ClienteFormatter.getCpf(solicitarParametro(Cliente.CAMPO_CPF, permitirNulos));
        obj.setCpf(cpf == null ? obj.getCpf() : cpf);

        String telefone = ClienteFormatter.getTelefone(solicitarParametro(Cliente.CAMPO_TELEFONE, permitirNulos));
        obj.setTelefone(telefone == null ? obj.getTelefone() : telefone);

        Endereco endereco = ClienteFormatter.getEndereco(solicitarParametro(Cliente.CAMPO_ENDERECO, permitirNulos));
        obj.setEndereco(endereco == null ? obj.getEndereco() : endereco);
    }

    @Override
    public void adicionar() {
        adicionar(new Cliente());
    }

    public void listarPorNome() {
        if (!getRepositorio().getTodos().isEmpty()) {
            System.out.println("Forneça o nome do cliente:");
            String entrada = getInput();
            Erro erro = ((ValidadorCliente) getValidador()).validarNome(entrada);
            if (erro == null) {
                List<Cliente> obj = ((RepositorioCliente) getRepositorio()).buscarPorNome(entrada);
                obj.stream().forEach((obj1) -> System.out.println(obj1.infoLinhaString()));
            } else {
                imprimirErro(erro);
            }
        } else {
            System.out.println("Não há clientes cadastrados!");
        }
    }

}
