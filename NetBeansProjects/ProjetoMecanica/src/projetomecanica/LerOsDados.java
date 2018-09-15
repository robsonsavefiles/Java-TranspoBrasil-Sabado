/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerOsDados {
    
     Scanner teclado = new Scanner(System.in);

    LerOsDados() {
        
    }

  
    void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }
        LerOsDados(Veiculo veiculos){
    
    
    Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo:");
        String nome = teclado.nextLine();

        lerDados(nome);
        teclado.close();
        }
    public static void lerDados(String nomeArquivo) {
        
        RepositorioMecanica repositorio = new RepositorioMecanica();
        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {
               
              System.out.println(leitor.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }

    }
    
}

