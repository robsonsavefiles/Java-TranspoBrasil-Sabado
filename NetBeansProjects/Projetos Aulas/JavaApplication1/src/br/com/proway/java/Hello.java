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
public class Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite seu Nome:");
        String nome = teclado.nextLine();
        System.out.printf("Bem vindo ao Netbeans %s!!!!\r\n",nome);
        System.out.println("c:\\");
        System.out.println("Quem usa \"Netbeans\\?");
        
        
        
        
    }
    
}
