package avaliacao.questao26.menu;

import avaliacao.questao26.info.EntidadeInfo;
import avaliacao.questao26.info.InfoCampo;
import avaliacao.questao26.model.Entidade;
import avaliacao.questao26.repositorio.Repositorio;
import avaliacao.questao26.validacao.ValidadorEntidade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public abstract class MenuEntidade extends Menu {

    private final ValidadorEntidade validadorPadrao;
    private final Repositorio repositorioPadrao;
    private final List<InfoCampo> camposOrdenacao;
    private final List<InfoCampo> camposPesquisa;

    public MenuEntidade(Scanner teclado, Repositorio repositorioPadrao, ValidadorEntidade validadorPadrao, List<InfoCampo> camposOrdenacao, List<InfoCampo> camposPesquisa) {
        super(teclado);
        this.validadorPadrao = validadorPadrao;
        this.repositorioPadrao = repositorioPadrao;
        this.camposOrdenacao = camposOrdenacao;
        this.camposPesquisa = camposPesquisa;
    }

    public Repositorio getRepositorio() {
        return repositorioPadrao;
    }

    public ValidadorEntidade getValidador() {
        return validadorPadrao;
    }

    @Override
    public String getTitulo() {
        return "MENU DE " + getNomePlural().toUpperCase();
    }

    public abstract String getNomePlural();

    public abstract String getNomeSingular();

    public abstract void solicitarParametros(Entidade obj, boolean permitirNulos);

//    public Entidade solicitarEntidade(InfoCampo campo, Repositorio repositorio, ValidadorEntidade validador, boolean permitirNulos) {
//        OpcaoMenu opcaoPesquisar = new OpcaoMenu("1", "Pesquisar " + campo.getNome());
//        OpcaoMenu opcaoId = new OpcaoMenu("2", "Fornecer " + EntidadeInfo.CAMPO_ID.getNome());
//        OpcaoMenu opcaoCancelar = new OpcaoMenu("3", "Manter o anterior");
//        SubMenu subMenu = new SubMenu(campo.getNome(), getTeclado(),
//                permitirNulos ? new OpcaoMenu[]{opcaoPesquisar, opcaoId, opcaoCancelar} : new OpcaoMenu[]{opcaoPesquisar, opcaoId});
//        OpcaoMenu opcaoEscolhida = null;
//
//        while (opcaoEscolhida != opcaoId && opcaoEscolhida != opcaoCancelar) {
//            subMenu.mostrarMenu();
//            opcaoEscolhida = subMenu.getOpcaoEscolhida();
//            if (opcaoEscolhida == opcaoCancelar) {
//                return null;
//            }
//            if (opcaoEscolhida == opcaoPesquisar) {
//                pesquisar(repositorio);
//            }
//        }
//
//        String id = solicitarParametro(campo, permitirNulos);
//        if (id.isEmpty()) {
//            return null;
//        } else {
//            return repositorio.buscarPorId(Long.parseLong(id));
//        }
//    }
//    public boolean entidadeIsValida(InfoCampo campo, Entidade entidade, ValidadorEntidade validador, boolean permitirNulos) {
//        if (permitirNulos && entidade == null) {
//            return true;
//        }
//        if (validador.isValido(entidade)) {
//            return true;
//        } else {
//            imprimirErros(validador.getErros());
//            return false;
//        }
//    }
    public String solicitarParametro(InfoCampo campo, boolean permitirNulos) {
        while (true) {
            System.out.println(campo.getNome() + ":");
            String input = getInput();
            if (parametroIsValido(campo, input, permitirNulos)) {
                return input;
            }
        }
    }

    public boolean parametroIsValido(InfoCampo campo, String input, boolean permitirNulos) {
        if (permitirNulos && input.isEmpty()) {
            return true;
        }
        if (validadorPadrao.isCampoValido(campo, input)) {
            return true;
        } else {
            imprimirErros(validadorPadrao.validarCampo(campo, input));
            return false;
        }
    }

    public void listar() {
        if (repositorioPadrao.isVazio()) {
            System.out.println("Não há " + getNomePlural() + " cadastrados(as).");
            return;
        }
        SubMenuCampo menu = new SubMenuCampo("Ordenar por:", getTeclado(), camposOrdenacao);
        menu.mostrarMenu();
        OpcaoMenu opcao = menu.getOpcaoEscolhida();
        if (opcao != null) {
            System.out.print(repositorioPadrao.infoString(repositorioPadrao.getTodosPorOrdem(opcao.getCampo())));
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void pesquisar() {
        pesquisar(getRepositorio(), camposPesquisa);
    }

    public void pesquisar(Repositorio repositorio, List<InfoCampo> camposPesquisa) {
        if (repositorio.isVazio()) {
            System.out.println("Não há " + getNomePlural() + " cadastrados(as).");
            return;
        }
        SubMenuCampo menu = new SubMenuCampo("Pesquisar por:", getTeclado(), camposPesquisa);
        menu.mostrarMenu();
        OpcaoMenu opcao = menu.getOpcaoEscolhida();
        if (opcao != null) {
            pesquisarPorCampo(opcao.getCampo(), repositorio);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void pesquisarPorCampo(InfoCampo campo, Repositorio repositorio) {
        String pesquisa = solicitarParametro(campo, false);
        System.out.print(repositorio.infoString(repositorio.getPesquisaPorOrdem(campo, pesquisa, false)));
    }

    public abstract void adicionar();

    public Entidade adicionar(Entidade obj) {
        solicitarParametros(obj, false);
        Entidade e = repositorioPadrao.salvar(obj);
        System.out.println(getNomeSingular() + " adicionado(a) com sucesso.");
        return e;
    }

    public void editar() {
        System.out.println("EDITAR " + getNomeSingular().toUpperCase());
        Entidade obj = getEntidadePorId();
        if (obj != null) {
            solicitarParametros(obj, true);
            getRepositorio().salvar(obj);
            System.out.println(getNomeSingular() + " " + obj.getId() + " editado(a) com sucesso.");
        }
    }

    public void remover() {
        System.out.println("REMOVER " + getNomeSingular().toUpperCase());
        Entidade obj = getEntidadePorId();
        if (obj != null) {
            getRepositorio().remover(obj);
            System.out.println(getNomeSingular() + " " + obj.getId() + " removido(a) com sucesso.");
        }
    }

    public Object verificaQueInfoManter(Object input, Object infoOriginal) {
        return input == null ? infoOriginal : input;
    }

    public Object verificaQueInfoManter(String input, Object infoOriginal) {
        return input == null || input.isEmpty() ? infoOriginal : input;
    }

    public Entidade getEntidadePorId() {
        if (getRepositorio().isVazio()) {
            System.out.println("Não há " + getNomePlural() + " cadastrados(as)!");
            return null;
        }

        System.out.println("Forneça o " + EntidadeInfo.CAMPO_ID + " do " + getNomeSingular() + ":");
        String entrada = getInput();

        if (!validadorPadrao.isCampoValido(EntidadeInfo.CAMPO_ID, entrada)) {
            imprimirErros(validadorPadrao.validarCampo(EntidadeInfo.CAMPO_ID, entrada));
            return null;
        }

        Entidade obj = getRepositorio().buscarPorId(Long.parseLong(entrada));

        if (obj == null) {
            System.out.println("Não foi encontrado nenhum(a) " + getNomeSingular() + " com o " + EntidadeInfo.CAMPO_ID.getNome() + " informado.");
        }

        return obj;
    }

}
