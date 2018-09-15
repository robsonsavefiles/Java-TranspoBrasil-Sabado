package avaliacao.questao26.menu;

import avaliacao.questao26.info.PedidoInfo;
import avaliacao.questao26.model.Cliente;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.Pedido;
import avaliacao.questao26.repositorio.RepositorioCliente;
import avaliacao.questao26.repositorio.RepositorioPedido;
import avaliacao.questao26.validacao.Erro;
import avaliacao.questao26.validacao.ValidadorPedido;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuPedido extends MenuEntidade {

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu("1", "Cadastrar novo " + PedidoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu("2", "Remover um " + PedidoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu("3", "Listar todos os " + PedidoInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_PESQUISAR = new OpcaoMenu("4", "Pesquisar " + PedidoInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("5", "Voltar ao menu anterior");

    public MenuPedido(Scanner teclado) {
        super(teclado, RepositorioPedido.getInstance(), new ValidadorPedido(), PedidoInfo.getCamposOrdenacao(), PedidoInfo.getCamposPesquisa());
        addOpcao(OPCAO_CADASTRAR);
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
        adicionar(new Pedido());
    }

    @Override
    public void solicitarParametros(Entidade obj, boolean permitirNulos) {
        Pedido pedido = (Pedido) obj;

        String codigo = solicitarParametro(PedidoInfo.CAMPO_CODIGO, permitirNulos);
        pedido.setCodigo((String) verificaQueInfoManter(codigo, pedido.getCodigo()));

        String idCliente = solicitarParametro(PedidoInfo.CAMPO_CLIENTE_ID, permitirNulos);
        long id = Long.parseLong(idCliente);
        pedido.setCliente((Cliente) RepositorioCliente.getInstance().buscarPorId(id));

        MenuPedidoItem mpi = new MenuPedidoItem(getTeclado(), pedido);
        while (true) {
            mpi.mostrarMenu();
            List<Erro> errosItens = getValidador().validarCampo(PedidoInfo.CAMPO_PEDIDOS, pedido.getItens());
            if (errosItens.isEmpty()) {
                break;
            } else {
                imprimirErros(errosItens);
            }
        }
    }

    @Override
    public String getNomePlural() {
        return PedidoInfo.NOME_PLURAL;
    }

    @Override
    public String getNomeSingular() {
        return PedidoInfo.NOME_SINGULAR;
    }
}
