package avaliacao.questao15;

import java.util.Scanner;

/**
 * Fazer um Programa que mostre um menu conforme abaixo at� que o usu�rio escolha a op��o sair. Caso o Usuario escolha uma op��o diferente da op��o 'sair' ent�o
 * deve ser apresentada a mensagem voc� escolheu a op��o {opcao_escolhida} "Cliente" "Produto" "Pedido" "sair"
 *
 * @author 89087
 */
public class Questao15 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            MenuPrincipal menu = new MenuPrincipal(teclado);
            menu.mostrarMenu();
        }
    }

}
