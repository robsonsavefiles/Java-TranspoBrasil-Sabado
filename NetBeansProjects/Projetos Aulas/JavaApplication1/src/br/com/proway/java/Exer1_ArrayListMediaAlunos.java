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
public class Exer1_ArrayListMediaAlunos {
    
    public static void main(String[] args) {
        
  
        int alunos = 5;
        int notas = 3;
        double[][] dados = new double[alunos][notas];
        double[] medias = new double[alunos];
        double mediaGeral = 0;
        
        Scanner teclado = new Scanner(System.in);
        for(int aluno = 0; aluno < dados.length;aluno = aluno +1){
            for(int nota = 0; nota< dados[aluno].length;nota = nota+1){
                System.out.println("Informe a nota"+(nota+1)+" do aluno "+(aluno+1));
                dados[aluno][nota] = Double.parseDouble(teclado.nextLine());
                medias[aluno] = medias[aluno]+ dados[aluno][nota];
            }
            medias[aluno] = medias[aluno]/notas;
            mediaGeral = mediaGeral + medias[aluno];
        }
        mediaGeral = mediaGeral /medias.length;
        
        for(int aluno = 0; aluno < dados.length;aluno = aluno +1){
             System.out.println("Notas aluno "+(aluno+1));
            for(int nota = 0; nota< dados[aluno].length;nota = nota+1){
                System.out.print(dados[aluno][nota]+" ");
            }
            System.out.println("");
            System.out.println("Média: "+medias[aluno]);
        }
        System.out.println("Media da turma "+ mediaGeral);
        
        teclado.close();
        
    }
}