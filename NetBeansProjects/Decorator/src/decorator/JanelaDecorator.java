/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 * @author 89087
 */
public class JanelaDecorator extends Janela {

    protected Janela janelaDecorator;

    public JanelaDecorator(Janela janela) {
        janelaDecorator = janela;
    }

    @Override
    public void abrir() {
        System.out.println("Abriu a Janela");

    }

}
