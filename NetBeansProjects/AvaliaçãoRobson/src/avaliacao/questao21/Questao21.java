package avaliacao.questao21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escreva um programa que solicite o nome e 5 notas de 10 alunos, em seguida escreva
 * o nome de cada aluno, suas notas e a sua m�dia.(Utilize Uma classe Aluno
 * para conter os dados de cada aluno)
 *
 * @author 89087
 */
public class Questao21 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            List<Aluno> alunos = new ArrayList();
            int qtdAlunos = 2;//quantidade 10 alunos
            int qtdNotas = 5;
            System.out.println("\t\t Sistema para Calcular Notas dos Alunos\n");
            for (int i = 0; i < qtdAlunos; i++) {
                Aluno aluno = new Aluno();
                
                System.out.println("Informe o nome do aluno:");
                String nome = teclado.nextLine();
                if (nome.isEmpty()) {
                    i--;
                    continue;
                }
                aluno.setNome(nome);

                System.out.println("Informe as notas de " + nome + ".");
                for (int j = 0; j < qtdNotas; j++) {
                    System.out.println("Nota " + (j + 1) + ":");
                    try {
                        double nota = Double.parseDouble(teclado.nextLine());
                        if (nota > 10 || nota < 0) {
                            throw new IllegalArgumentException();
                        }
                        aluno.addNota(nota);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nota inválida.");
                        j--;
                    }
                }
                System.out.println("============================================");
                alunos.add(aluno);
            }

            alunos.stream().map((aluno) -> {
                System.out.println("\nNotas do aluno " + aluno.getNome() + ":");
                return aluno;
            }).forEach((aluno) -> {
                List<Double> notas = aluno.getNotas();
                notas.stream().forEach((nota) -> System.out.println(nota));
                System.out.println("Média do "+aluno.getNome()+":"+ aluno.getMedia());
                System.out.println("============================================");
            });
        }
    }
}
