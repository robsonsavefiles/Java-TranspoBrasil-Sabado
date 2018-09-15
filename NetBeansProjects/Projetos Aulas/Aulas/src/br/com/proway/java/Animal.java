/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

/**
 *
 * @author 89087
 */
public class Animal {

//    public static final int MACHO = 1;// CONSTANTE 
//    public static final int FEMEA =2;
    private String nome;
    private Genero genero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Animal(String nome, Genero genero) {
        this.nome = nome;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Animal{" + "nome=" + nome + ", genero=" + genero + '}';
    }

}
