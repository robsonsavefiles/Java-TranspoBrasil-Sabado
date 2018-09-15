package avaliacao.questao26.menus;

import avaliacao.questao26.informacao.ClienteInfo;
import avaliacao.questao26.modelos.Cliente;
import avaliacao.questao26.modelos.Entidade;
import avaliacao.questao26.repositorios.RepositorioCliente;
import avaliacao.questao26.validacoes.ValidadorCliente;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuCliente extends MenuEntidade {

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu("1", "Cadastrar novo " + ClienteInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu("2", "Editar um " + ClienteInfo.NOME_SINGULAR + " existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu("3", "Remover um " + ClienteInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu("4", "Listar todos os " + ClienteInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_PESQUISAR = new OpcaoMenu("5", "Pesquisar " + ClienteInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("6", "Voltar ao menu anterior");

    public MenuCliente(Scanner teclado) {
        super(teclado, RepositorioCliente.getInstance(), new ValidadorCliente(), ClienteInfo.getCamposOrdenacao(), ClienteInfo.getCamposPesquisa());
        addOpcao(OPCAO_CADASTRAR);
        addOpcao(OPCAO_EDITAR);
        addOpcao(OPCAO_REMOVER);
        addOpcao(OPCAO_LISTAR_TODOS);
        addOpcao(OPCAO_PESQUISAR);
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
        if (opcao == OPCAO_PESQUISAR) {
            pesquisar();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

    @Override
    public void adicionar() {
        adicionar(new Cliente());
    }

    @Override
    public void solicitarParametros(Entidade obj, boolean permitirNulos) {
        Cliente cliente = (Cliente) obj;

        String nome = solicitarParametro(ClienteInfo.CAMPO_NOME, permitirNulos);
        cliente.setNome((String) verificaQueInfoManter(nome, cliente.getNome()));

        String cpf = solicitarParametro(ClienteInfo.CAMPO_CPF, permitirNulos);
        cliente.setCpf((String) verificaQueInfoManter(cpf, cliente.getCpf()));

        String telefone = solicitarParametro(ClienteInfo.CAMPO_TELEFONE, permitirNulos);
        cliente.setTelefone((String) verificaQueInfoManter(telefone, cliente.getTelefone()));

        String celular = solicitarParametro(ClienteInfo.CAMPO_CELULAR, permitirNulos);
        cliente.setCelular((String) verificaQueInfoManter(celular, cliente.getCelular()));
        
        String endereco = solicitarParametro(ClienteInfo.CAMPO_ENDERECO,permitirNulos);
        cliente.setEndereco((String) verificaQueInfoManter(endereco,cliente.getEndereco()));
    }

    @Override
    public String getNomePlural() {
        return ClienteInfo.NOME_PLURAL;
    }

    @Override
    public String getNomeSingular() {
        return ClienteInfo.NOME_SINGULAR;
    }
}
