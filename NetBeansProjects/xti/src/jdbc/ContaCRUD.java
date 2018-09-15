package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD-Create,Read, Update e Delete

public class ContaCRUD {

	public void criar(Connection con, Conta conta) throws SQLException {
		String sql = "insert into conta values(?,?,?)";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1,conta.numero);
			stm.setString(2,conta.cliente);
			stm.setDouble(3,conta.saldo);
			stm.executeUpdate();
			
		}
	}
	public List<Conta> ler(Connection con) throws SQLException {
		List<Conta> lista = new ArrayList<>();
		String sql = "select numero,cliente,saldo from conta";
		try (PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery()){
			while (rs.next()) {
				lista.add(new Conta(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			
			}
		}
		return lista;
	}

	
	public void alterar(Connection con, Conta conta) throws SQLException {
		String sql = "update conta set cliente=?,saldo=? where numero=?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(1,conta.cliente);
			stm.setDouble(2,conta.saldo);
			stm.setInt(3,conta.numero);
			stm.executeUpdate();
			
		}
	}
	public void excluir(Connection con, Conta conta) throws SQLException {
		String sql = "delete conta where numero=?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1,conta.numero);
			stm.executeUpdate();
			
		}
	}
	
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try (Connection con = DriverManager.getConnection(url, "xti", "xti123")) {
			
			ContaCRUD crud = new ContaCRUD();
			
			Conta conta1 = new Conta(1,"Ricardo", 1000.10);
			conta1.saldo = 9000.99;
			crud.alterar(con, conta1);
			
			Conta conta3 = new Conta(3,"Beatriz", 3000.50);
			crud.excluir(con, conta3);
			
			/*
			Conta conta2 = new Conta(2,"Robson", 2000.50);
			
			crud.criar(con, conta1);
			crud.criar(con, conta2);
			crud.criar(con, conta3);
				*/
			
			List<Conta> contas = crud.ler(con);
			for (Conta conta : contas) {
				System.out.println(conta);
			}

		}
	}
}
