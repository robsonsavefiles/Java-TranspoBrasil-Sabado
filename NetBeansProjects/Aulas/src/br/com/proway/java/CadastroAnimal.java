/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.java;

import java.util.Arrays;

/**
 *
 * @author 89087
 */
public class CadastroAnimal {

    public static void main(String[] args) {

        //Animal animal  = new Animal("Zuk",1);
        Animal animal = new Animal("Zuk", Genero.MACHO);
        System.out.println(animal);

        //Animal animal2  = new Animal("Laika",1);
        Animal animal2 = new Animal("Zuk", Genero.FEMEA);
        System.out.println(animal2);

        Animal animal3 = new Animal("Betoven", Genero.MACHO);
        System.out.println(animal3);

        System.out.println(Genero.FEMEA.ordinal());
        System.out.println(Genero.MACHO.ordinal());

        Genero genero = Genero.valueOf("FEMEA");
        System.out.println(genero);
        System.out.println(Arrays.toString(Genero.values()));//
        System.out.println(Genero.values()[0]);
        System.out.println(Genero.values()[1]);

        System.out.println(Genero.FEMEA == Genero.FEMEA);
        System.out.println(Genero.FEMEA.equals(Genero.FEMEA));
        System.out.println(Genero.FEMEA.equals(Genero.MACHO));
        System.out.println(Genero.MACHO.equals(Genero.FEMEA));

    }

}
