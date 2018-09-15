package redes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")


public class ChatCliente extends JFrame {

	JTextField textoParaEnviar;
	Socket socket;
	PrintWriter escritor;
	String nome;
	JTextArea textoRecebido;
	Scanner leitor;

	public class EscutaServidor implements Runnable {

		@Override
		public void run() {
			try {

				String texto;
				while ((texto = leitor.next()) != null) {
					textoRecebido.append(texto + "\n");

				}
			} catch (Exception x) {}
			}

		}

	public ChatCliente(String nome) {
		super("Chat:" + nome);
		this.nome = nome;

		Font fonte = new Font("Serif", Font.PLAIN, 26);

		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
        botao.addActionListener(new EnviarListener());

		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);

		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		
		textoRecebido = new JTextArea();
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);
		
		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
	

		configurarRede();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);

	}

	private class EnviarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			escritor.println(nome + ":" + textoParaEnviar.getText());
			escritor.flush();// garantir que a msg foi enviada
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();// aguardando um novo texto

		}

	}

	private void configurarRede() {
		try {
			socket = new Socket("127.0.0.1", 5000);
			escritor = new PrintWriter(socket.getOutputStream());
			new Thread(new EscutaServidor()).start();
		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {

		new ChatCliente("");
		

	}

}
