package avaliacao.questao26.menu;

import avaliacao.questao26.info.PedidoInfo;
import avaliacao.questao26.info.PedidoItemInfo;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.model.Pedido;
import avaliacao.questao26.model.PedidoItem;
import avaliacao.questao26.model.Produto;
import avaliacao.questao26.repositorio.RepositorioPedidoItem;
import avaliacao.questao26.repositorio.RepositorioProduto;
import avaliacao.questao26.validacao.ValidadorPedidoItem;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class MenuPedidoItem extends MenuEntidade {

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu("1", "Inserir novo " + PedidoItemInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu("2", "Remover " + PedidoItemInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu("4", "Listar todos os " + PedidoItemInfo.NOME_PLURAL + " deste " + PedidoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_PESQUISAR = new OpcaoMenu("5", "Pesquisar " + PedidoItemInfo.NOME_PLURAL + " dentro deste " + PedidoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("6", "Concluir cadastro de " + PedidoItemInfo.NOME_PLURAL);

    private final Pedido pedido;

    public MenuPedidoItem(Scanner teclado, Pedido pedido) {
        super(teclado, RepositorioPedidoItem.getInstance(), new ValidadorPedidoItem(), PedidoItemInfo.getCamposOrdenacao(), PedidoItemInfo.getCamposPesquisa());
        addOpcao(OPCAO_CADASTRAR);
        addOpcao(OPCAO_REMOVER);
        addOpcao(OPCAO_LISTAR_TODOS);
        addOpcao(OPCAO_PESQUISAR);
        addOpcao(OPCAO_SAIR);
        this.pedido = pedido;
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
        PedidoItem item = new PedidoItem();
        item = (PedidoItem) adicionar(item);
        pedido.addItem(item);
    }

    @Override
    public void solicitarParametros(Entidade obj, boolean permitirNulos) {
        PedidoItem item = (PedidoItem) obj;

        String idProduto = solicitarParametro(PedidoItemInfo.CAMPO_PRODUTO_ID, permitirNulos);
        long id = Long.parseLong(idProduto);
        Produto produto = (Produto) RepositorioProduto.getInstance().buscarPorId(id);

        String quantidade = solicitarParametro(PedidoItemInfo.CAMPO_QUANTIDADE, permitirNulos);

        item.setPedidoItem(produto, Integer.parseInt(quantidade));
    }

    @Override
    public String getNomePlural() {
        return PedidoItemInfo.NOME_PLURAL;
    }

    @Override
    public String getNomeSingular() {
        return PedidoItemInfo.NOME_SINGULAR;
    }
}
