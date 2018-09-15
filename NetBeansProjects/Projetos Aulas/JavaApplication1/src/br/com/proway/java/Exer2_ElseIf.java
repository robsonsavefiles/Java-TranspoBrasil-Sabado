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
public class Exer2_ElseIf {
    
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe sua Idade");
        int age = Integer.parseInt(teclado.nextLine());
        
        if(age>=16){
    
        System.out.println("Voce pode Votar");
        
        }else{
            System.out.println("Voce nao tem idade Suficiente para Votar");

        }
    }
}
    

