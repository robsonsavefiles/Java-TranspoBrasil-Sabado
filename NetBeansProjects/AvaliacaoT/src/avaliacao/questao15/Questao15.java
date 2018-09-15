package avaliacao.questao15;

import java.util.Scanner;

/**
 * Fazer um Programa que mostre um menu conforme abaixo até que o usuário escolha a opção sair. Caso o Usuario escolha uma opção diferente da opção 'sair' então
 * deve ser apresentada a mensagem você escolheu a opção {opcao_escolhida} "Cliente" "Produto" "Pedido" "sair"
 *
 * @author 78522
 */
public class Questao15 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            MenuPrincipal menu = new MenuPrincipal(teclado);
            menu.mostrarMenu();
        }
    }

}
