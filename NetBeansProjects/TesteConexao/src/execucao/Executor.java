package execucao;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.PessoaDAO;
import modelo.Pessoa;

public class Executor {
	public static void main(String[] args) {
		try {
			PessoaDAO pdao = new PessoaDAO();

			ArrayList<Pessoa> pessoas = pdao.buscarTodos();

			for (Pessoa p : pessoas) {
				System.out.println(p.getNome());
			}
			
			Pessoa pessoaNova = new Pessoa();
						
			pessoaNova = pdao.buscar("212");
			
			pessoaNova.setCidade("NOVA");
			pdao.alterar(pessoaNova);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
