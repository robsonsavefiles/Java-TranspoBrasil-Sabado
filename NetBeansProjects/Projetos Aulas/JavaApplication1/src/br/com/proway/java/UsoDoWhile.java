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
public class UsoDoWhile {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String controle = "";
        
        do{// vai executar ao menos uma vez
            
            System.out.print("Digite um numero:");
            controle = teclado.nextLine();
            
        }while(!controle.equals("10"));
        teclado.close();
    }
    
}
