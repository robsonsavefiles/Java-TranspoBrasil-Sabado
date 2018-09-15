package redes;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.LinkedList;

public class ChatServidor {

	ArrayList<PrintWriter> escritores = new ArrayList<>();

	public ChatServidor() {
		ServerSocket server;
		Scanner leitor;
		try {
			server = new ServerSocket(5000);
			while (true) {
				Socket socket = server.accept();
				new Thread(new EscutaCliente(socket)).start();
				leitor = new Scanner(socket.getInputStream());
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
				
			}
		} catch (IOException e1) {
		}

	}

	//InetAddress ip= InetAddress.getLocalHost(); socket=new Socket(ip.getHostAddress(),5000); 
	private void encaminharParaTodos(String texto) {
		for (PrintWriter w : escritores) {
			try {
				w.println(texto);
				w.flush();
			} catch (Exception e) {
			}
		}
	}

	private class EscutaCliente implements Runnable {
		Scanner leitor;

		public EscutaCliente(Socket socket) {
			try {
				Scanner leitor = new Scanner(socket.getInputStream());
			} catch (Exception e) {
			}

		}

		@Override
		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
					encaminharParaTodos(texto);
				}

			} catch (Exception e) {}//nao é boa pratica

		}
	}

	public static void main(String[] args) {
		
		new ChatServidor();

	}

}
