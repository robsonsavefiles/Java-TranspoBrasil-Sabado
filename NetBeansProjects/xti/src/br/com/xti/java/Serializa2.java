package br.com.xti.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import br.com.xti.poo.Conta;

import java.nio.file.*;

public class Serializa2 {

	public void armazenarContas(ArrayList<Conta> contas) throws IOException {
		try (FileOutputStream fos = new FileOutputStream("C:/xti/files/contas.ser")) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(contas);
			}
		}
	}

	public ArrayList<Conta> recuperarContas() throws IOException, ClassNotFoundException {

		try (FileInputStream fos = new FileInputStream("C:/xti/files/contas.ser")) {
			try (ObjectInputStream oos = new ObjectInputStream(fos)) {
				return (ArrayList<Conta>) oos.readObject();
			}
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ArrayList<Conta> contas = new ArrayList<>();
		contas.add(new Conta("Ricardo", 12000.23));
		contas.add(new Conta("Lawrence", 11050.32));
		contas.add(new Conta("Sandra", 1800.21));
		contas.add(new Conta("Beatriz", 23200.09));

		Serializa2 operacao = new Serializa2();
		operacao.armazenarContas(contas);
		ArrayList<Conta> contas2 = operacao.recuperarContas();
		for (Conta conta : contas) {
			conta.exibeSaldo();
		}

	}

}
