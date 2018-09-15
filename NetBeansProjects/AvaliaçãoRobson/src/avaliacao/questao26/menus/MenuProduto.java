package avaliacao.questao26.menus;

import avaliacao.questao26.informacao.ProdutoInfo;
import avaliacao.questao26.modelos.Entidade;
import avaliacao.questao26.modelos.Produto;
import avaliacao.questao26.repositorios.RepositorioProduto;
import avaliacao.questao26.validacoes.ValidadorProduto;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class MenuProduto extends MenuEntidade {

    public static final OpcaoMenu OPCAO_CADASTRAR = new OpcaoMenu("1", "Cadastrar novo " + ProdutoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_EDITAR = new OpcaoMenu("2", "Editar um " + ProdutoInfo.NOME_SINGULAR + " existente");
    public static final OpcaoMenu OPCAO_REMOVER = new OpcaoMenu("3", "Remover um " + ProdutoInfo.NOME_SINGULAR);
    public static final OpcaoMenu OPCAO_LISTAR_TODOS = new OpcaoMenu("4", "Listar todos os " + ProdutoInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_PESQUISAR = new OpcaoMenu("5", "Pesquisar " + ProdutoInfo.NOME_PLURAL);
    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("6", "Voltar ao menu anterior");

    public MenuProduto(Scanner teclado) {
        super(teclado, RepositorioProduto.getInstance(), new ValidadorProduto(), ProdutoInfo.getCamposOrdenacao(), ProdutoInfo.getCamposPesquisa());
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
        adicionar(new Produto());
    }

    @Override
    public void solicitarParametros(Entidade obj, boolean permitirNulos) {
        Produto produto = (Produto) obj;

        String codigo = solicitarParametro(ProdutoInfo.CAMPO_CODIGO, permitirNulos);
        produto.setCodigo((String) verificaQueInfoManter(codigo, produto.getCodigo()));

        String nome = solicitarParametro(ProdutoInfo.CAMPO_NOME, permitirNulos);
        produto.setNome((String) verificaQueInfoManter(nome, produto.getNome()));

        String descricao = solicitarParametro(ProdutoInfo.CAMPO_DESCRICAO, permitirNulos);
        produto.setDescricao((String) verificaQueInfoManter(descricao, produto.getDescricao()));

        String valor = solicitarParametro(ProdutoInfo.CAMPO_VALOR, permitirNulos);
        produto.setValor(Double.parseDouble((String) verificaQueInfoManter(valor, produto.getValor())));
    }

    @Override
    public String getNomePlural() {
        return ProdutoInfo.NOME_PLURAL;
    }

    @Override
    public String getNomeSingular() {
        return ProdutoInfo.NOME_SINGULAR;
    }

}
