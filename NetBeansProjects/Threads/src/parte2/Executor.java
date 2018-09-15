/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author 88178
 */
public class Executor {

    public static void main(String[] args) {
        Balde balde = new Balde();

        Removedor r1 = new Removedor(balde);
        Removedor r2 = new Removedor(balde);
        Removedor r3 = new Removedor(balde);
        Removedor r4 = new Removedor(balde);
        Removedor r5 = new Removedor(balde);

        Colocador c1 = new Colocador(balde);
        Colocador c2 = new Colocador(balde);
        Colocador c3 = new Colocador(balde);
        Colocador c4 = new Colocador(balde);
        Colocador c5 = new Colocador(balde);
        Colocador c6 = new Colocador(balde);
        Colocador c7 = new Colocador(balde);
        Colocador c8 = new Colocador(balde);
        Colocador c9 = new Colocador(balde);
        Colocador c10 = new Colocador(balde);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
    }

}
