/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.arrayList;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //primeiro cria alguns objetos DotCom e fornece seus Locais
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Seu objetivo é eliminar tres dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Tente Elimnar todas com o menor numero de palpites");

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationsCells(newLocation);

        }// encerra o loop for

    }// encerra o metodo setUpGame

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Insira um palpite");
            checkUserGuess(userGuess);

        }// encerra  while
        finishGame();
    }//encerra o metodo starPlaying

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "errado";

        for (DotCom dotComToTest : dotComList) {
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.equals("correto")) {
                break;

            }
            if (result.equals("eliminar")) {
                dotComList.remove(dotComToTest);
                break;
            }

        }//encerra for

        System.out.println(result);

    }//encerra o metodo
    
    private void finishGame(){
        System.out.println("Todas as Dot Coms foram Eliminadas!! Agora seu conjunto esta vazio");
        if(numOfGuesses <= 18){
            System.out.println("Voce so usou "+ numOfGuesses +"palpites.");
            System.out.println("Voce Saiu antes de eliminar suas opçoes");
            
        }else{
            System.out.println("Demorou demais"+ numOfGuesses+ "palpites.");
            System.out.println("Não Havera pesca com essas opçoes");
        }
    }//encerra o metodo

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
        
    }//encerra o metodo
    
}

   
    

