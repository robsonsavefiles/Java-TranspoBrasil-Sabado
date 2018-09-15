/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class ExemploSwitchCase {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva o dia da semana ");
        String dia = teclado.nextLine();
        
        
        
        switch(dia.toLowerCase()){
            case "Segunda feira":
                System.out.println("O dia o ceus! Segunda");   
                break;
            case "Terça Feira":
                System.out.println("Dois pra frente estamos quase no fim");
                break;
            case"Quarta Feira":  
                System.out.println("dia de jogo");
                break;
            case"Quinta Feira":
                System.out.println("ta chegando");
                break;
            case"Sexta Feira":
                System.out.println("ufa so mais hoje");
                break;
            case"Sabado Feira":
                System.out.println("sombra e aguaa fresca");
                break;
            case"Domingo":    
                System.out.println("So sossego");
                break;
            default:
                
        }
        
        
        
    }
    
    
    
}
