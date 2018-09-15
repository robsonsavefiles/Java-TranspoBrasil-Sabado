/*1)Crie um enum que contenha os dias da semana em seguida crie um aplicacao que receba
 *um numero de 1 a 7 e escreva o nome do dia, onde o dia 1 deve ser domingo e o dia 7 deve ser sabado; 
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class Dias {

    private DiasSemana opcao;

    Dias(String domingo, DiasSemana diasSemana) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DiasSemana getOpcao() {
        return opcao;
    }

    public void setOpcao(DiasSemana opcao) {
        this.opcao = opcao;
    }

    public Dias(DiasSemana opcao) {
        this.opcao = opcao;
    }

    @Override
    public String toString() {
        return "Dias{" + "opcao=" + opcao + '}';
    }

}
