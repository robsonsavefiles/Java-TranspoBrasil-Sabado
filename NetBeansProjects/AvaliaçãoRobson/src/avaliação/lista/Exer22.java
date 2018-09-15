/*
 22) Escreva um programa que solicite o nome do usuário e escreva a quantidade de caracteres do nome informado.
 */
package avaliação.lista;

import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer22 {
    
    public static void main(String[] args) {
       
     try (Scanner teclado = new Scanner(System.in)) {
         
            System.out.println("\t\tInforma a Quantidade de Caracteres Informado\n\n");
            System.out.println("Informe seu nome:");
            String nome = teclado.nextLine();
            System.out.println("Quantidade de caracteres: " + nome.length());
        }
    }
}

    
    
    
    

