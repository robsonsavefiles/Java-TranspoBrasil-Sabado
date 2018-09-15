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
public class OperadorTernario {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite sua Idade");
        
        int idade = Integer.parseInt(teclado.nextLine());
       
        String mensagem = "";
        
         /*
        if(idade>=18){
            mensagem = "Maior";
            
        }else{
            mensagem = "Menor";
        }
        */
     
        mensagem = idade >=18 ? "Maior" : "Menor";
        System.out.println(mensagem);
        
        teclado.close();
        
    }
    
    
    
}
