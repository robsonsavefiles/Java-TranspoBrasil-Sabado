/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.criandoobjeto.jogoadvinhar;

/**
 *
 * @author Robinho
 */
public class GuessGame {

    //variveis de instância para os tres objetos

    Player p1;
    Player p2;
    Player p3;

    //cria tres objetos  player e atribui a eles as tres variaveis de instancia player

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        //variaveis para armazenar os palpites dos jogadores
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

       // variaveis para armazenar resposta do jogador verdadeiro ou falso
        //baseado na resposta do jogador
        boolean p1isRight = false;
        boolean p2isRigth = false;
        boolean p3isRigth = false;

        //cria um numero valo quee os jogadores terao que advinhar
        int targetNumber = (int) (Math.random() * 10);
        System.out.println("Estou pensando em um numero entre 0 e 9...");
        while (true) {
            System.out.println("O numero a advinhar é " + targetNumber);
            //chama o metodo guess() de cada jogador   
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("O jogador 1 Forneceu o palpite" + guessp1);
            guessp1 = p2.number;
            System.out.println("O jogador 2 Forneceu o palpite" + guessp2);
            guessp1 = p3.number;
            System.out.println("O jogador 3 Forneceu o palpite" + guessp3);

            if (guessp1 == targetNumber) {
                p1isRight = true;
            }
            if (guessp2 == targetNumber) {
                p2isRigth = true;
            }
            if (guessp3 == targetNumber) {
                p3isRigth = true;
            }
            if (p1isRight || p2isRigth || p3isRigth) {
                System.out.println("Temos um Vencedor!!!");
                System.out.println("O jogador 1 acertou?" + p1isRight);
                System.out.println("O jogador 2 acertou?" + p2isRigth);
                System.out.println("O jogador 3 acertou?" + p3isRigth);
                System.out.println("Fim de Jogo!!!");
                break;
            } else {
                //Devemos continuar ninguem acertou
                System.out.println("Os jogadores terao que tentar Novamente.");

            }
        }
    }

}
