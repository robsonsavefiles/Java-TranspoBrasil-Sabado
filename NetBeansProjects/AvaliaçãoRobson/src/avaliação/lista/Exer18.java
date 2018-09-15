/*
 * 18)Escreva um programa que  solicite o nome de um recurso e em seguida escreva 
   se  o recurso existe, se é um arquivo ou se é uma pasta.
 */
package avaliação.lista;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class Exer18 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o caminho de um recurso:");
        String path = teclado.nextLine();
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println(file.getName()+"É um arquivo.");
            } else if (file.isDirectory()) {
                System.out.println(file.getName()+"É uma Pasta.");
            }
        } else {
            System.out.println(file.getName()+"Não existe.");
        }
    }
}

    
