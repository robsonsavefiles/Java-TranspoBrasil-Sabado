package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;

import conexao.ConexaoFactory;
import modelo.Pessoa;

public class PessoaDAO {
	private Connection conn;
	private Statement statement;

	private void conectar() throws ClassNotFoundException, SQLException {
		conn = ConexaoFactory.getConexao();
		statement = conn.createStatement();
	}

	private void desconectar() throws SQLException {
		conn.close();
		statement.close();
	}

	public ArrayList<Pessoa> buscarTodos() throws SQLException, ClassNotFoundException {
		conectar();
		String sql = "SELECT * FROM pessoa"; // no * funciona a opcao de filtro
												// basta informar o nome da
												// coluna e se for mais de uma
												// colocar virgula
		ResultSet rs = statement.executeQuery(sql);

		ArrayList<Pessoa> listaRetorno = new ArrayList<Pessoa>();

		while (rs.next()) {
			Pessoa p = new Pessoa();
			p.setNome(rs.getString("nome"));
			p.setRg(rs.getString("rg"));
			p.setEstado(rs.getString("estado"));
			p.setIdade(rs.getInt("idade"));
			p.setCidade(rs.getString("cidade"));

			listaRetorno.add(p);
		}
		desconectar();
		return listaRetorno;
	}

	public void inserir(Pessoa novaPessoa) throws SQLException, ClassNotFoundException {
		conectar();

		statement.executeUpdate("INSERT INTO Pessoa VALUES('" + novaPessoa.getRg() + "','" + novaPessoa.getNome()
				+ "','" + novaPessoa.getIdade() + "','" + novaPessoa.getCidade() + "','" + novaPessoa.getEstado()
				+ "')");

		desconectar();
	}

	public void remover(String rg) throws SQLException, ClassNotFoundException {
		conectar();
		statement.executeUpdate("DELETE FROM pessoa WHERE rg = '" + rg + "';");
		desconectar();
	}

	public Pessoa buscar(String rg) throws SQLException, ClassNotFoundException {
		conectar();
		Pessoa retorno = new Pessoa();

		ResultSet rs = statement.executeQuery("SELECT * FROM pessoa WHERE rg = '" + rg + "';");

		if (rs.next()) {
			retorno.setNome(rs.getString("nome"));
			retorno.setRg(rs.getString("rg"));
			retorno.setEstado(rs.getString("estado"));
			retorno.setIdade(rs.getInt("idade"));
			retorno.setCidade(rs.getString("cidade"));

			desconectar();
			return retorno;
		} else {
			System.out.println("Pessoa não localizada");
			desconectar();
			return null;
		}
	}

	public void alterar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		conectar();

		statement.executeUpdate("UPDATE pessoa SET name = '" + pessoa.getNome() + "', idade =" + pessoa.getIdade()
				+ ", cidade = '" + pessoa.getCidade() + "', estado = '" + pessoa.getEstado() + "' WHERE rg = '"
				+ pessoa.getRg() + "';");

		desconectar();
	}
}
