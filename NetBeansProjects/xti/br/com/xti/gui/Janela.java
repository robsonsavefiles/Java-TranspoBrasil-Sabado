/*GUI -Graphical User Interface - Interface Grafica com usuario 
 *	Pacote javax.swing
 *	Janela (JFrame)
 * 	Container
 * 	Componentes(controles)botão,campo de texto e etcs;;;
 * */

package br.com.xti.gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {
	
	public Janela(){
		super("Minha Aplicaçao");
		JFrame frame = new JFrame();	
		JButton botao = new JButton("Clique");
		getContentPane().add(botao);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);//visisivel para o usuario 
		
	}

	public static void main(String[] args) {
		new Janela();
		
		
	}

}
