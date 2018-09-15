/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.encapsulamento;

/**
 *
 * @author Robinho
 */
public class GoodDog {

    private int size;//torna a varivel de instancia privada

    public int getSize() {//torna os metodos de captura e configuraçao publicos
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
            System.out.println("Woof!! Woof!!");
        } else if (size > 14) {
            System.out.println("Ruff!! Ruff!!");
        } else {
            System.out.println("Yip!! Yip!!");
        }
    }

}
