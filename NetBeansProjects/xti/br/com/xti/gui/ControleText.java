package br.com.xti.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleText extends JFrame {

	JButton ok, cancela;
	JTextField login;
	JPasswordField senha;

	public ControleText() {

		super("Texto e Senhas");

		login = new JTextField();
		senha = new JPasswordField();

		ok = new JButton("OK");
		ok.addActionListener(new BotaoOKListener());
		
		cancela = new JButton("Cancela");
		cancela.addActionListener(new BotaoCancelaListener());

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Login"));
		c.add(login);
		c.add(new JLabel("Senha"));
		c.add(senha);
		c.add(ok);
		c.add(cancela);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ControleText();

	}
	class BotaoOKListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = "login:" + login.getText() + "\nsenha:" + new String(senha.getPassword());
			JOptionPane.showMessageDialog(null, s);
		}
		
	}
	class BotaoCancelaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			login.setText("");
			senha.setText("");
		}
		
	}
	
	
}
	