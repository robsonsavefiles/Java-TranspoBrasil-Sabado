package avaliacao.questao21;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 78522
 */
public class Aluno {

    private String nome;
    private List<Double> notas = new ArrayList();

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, List<Double> notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void addNota(double nota) {
        notas.add(nota);
    }

    public double getMedia() {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

}
