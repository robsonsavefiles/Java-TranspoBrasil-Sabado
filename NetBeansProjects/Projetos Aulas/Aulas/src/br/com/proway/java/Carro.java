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
public class Carro {

    String modelo;
    int velocidadeMaxima;
    double segundosZeroACem;
    Motor motor;

    public Carro() {// construtor 

    }
	//construtor 2

    public Carro(String modelo, int velocidadeMaxima, double segundosZeroACem) {

        this(modelo, velocidadeMaxima, segundosZeroACem, null);// chamando outro construtor

    }

    // construtor 3

    public Carro(String modelo, int velocidadeMaxima, double segundosZeroACem, Motor motor) {

        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.segundosZeroACem = segundosZeroACem;
        this.motor = motor;

    }
}