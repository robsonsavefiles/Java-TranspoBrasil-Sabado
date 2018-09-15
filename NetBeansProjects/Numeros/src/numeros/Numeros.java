/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros;

import java.util.Scanner;

/**
 *
 * @author Robinho
 */
public class Numeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, s=0;
        String resp;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um Numero:");
            n = teclado.nextInt();
            s += n; // s = s + n;
            System.out.print("Quer continuar? [S/N]:12");
            resp = teclado.next();
      
        }while(resp.equals("s"));
        System.out.print("A SOMA DOS DE TODOS OS VALORES É " + s);  
    }
    
}

