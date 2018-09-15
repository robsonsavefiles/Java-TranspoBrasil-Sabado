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
public class Exer1ElseIf {
    
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe sua idade:");
        int age = Integer.parseInt(teclado.nextLine());
        
        if(age>=18){
    
        System.out.println("Voce pode fazer a CNH");
        
        }else{
            System.out.println("Não é permitido");

        }
    }
}