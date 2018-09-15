package exercicios.enums.usuario;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class CadastroUsuario {

    private enum Opcoes {

        ADICIONAR, LISTAR, REMOVER, SAIR;
    }

    private Scanner teclado;

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public CadastroUsuario(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {
        Opcoes opcao;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println(Opcoes.ADICIONAR.ordinal() + " - Adicionar Usu�rio");
            System.out.println(Opcoes.LISTAR.ordinal() + " - Listar Usu�rios");
            System.out.println(Opcoes.REMOVER.ordinal() + " - Remover Usu�rio");
            System.out.println(Opcoes.SAIR.ordinal() + " - Sair");
            opcao = Opcoes.values()[Integer.parseInt(teclado.nextLine())];
            tratarOpcoes(opcao);
        } while (opcao != Opcoes.SAIR);
    }

    private void tratarOpcoes(Opcoes opcao) {
        switch (opcao) {
            case ADICIONAR:
                adicionar();
                break;
            case LISTAR:
                listar();
                break;
            case REMOVER:
                remover();
                break;
            default:
                break;
        }
    }

    private void adicionar() {
        RepositorioUsuario repositorio = new RepositorioUsuario();

        System.out.println("ADI��O DE USU�RIO");
        Usuario usuario = new Usuario();

        System.out.println("Nome: ");
        usuario.setNome(teclado.nextLine());

        System.out.println("Email: ");
        usuario.setEmail(teclado.nextLine());

        System.out.println("Senha: ");
        usuario.setSenha(teclado.nextLine());

        System.out.println("Tipo " + Arrays.toString(TipoUsuario.values()) + ": ");
        usuario.setTipo(TipoUsuario.values()[Integer.parseInt(teclado.nextLine())]);

        repositorio.salvar(usuario);
        System.out.println("Usu�rio salvo com sucesso.");
    }

    private void listar() {
        RepositorioUsuario repositorio = new RepositorioUsuario();
        List<Usuario> usuarios = repositorio.listar();

        System.out.println("LISTA DE USU�RIOS");

        System.out.printf("%-20s|%-50s|%-50s|%-50s|%-30s\r\n", 
                "ID", "NOME", "EMAIL", "SENHA", "TIPO");
        for (Usuario usuario : usuarios) {
            System.out.printf("%-20s|%-50s|%-50s|%-50s|%-30s\r\n",
                    usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTipo());
        }
    }

    private void remover() {
        RepositorioUsuario repositorio = new RepositorioUsuario();

        System.out.println("REMO��O DE USU�RIO");
        System.out.println("Informe o ID do usu�rio:");
        long id = Long.parseLong(teclado.nextLine());

        Usuario usuario = repositorio.getPorId(id);

        if (usuario == null) {
            System.out.println("ID Inv�lido.");
        } else {
            repositorio.remover(usuario);
            System.out.println("Usu�rio removido com sucesso.");
        }
    }
}
