package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.TipoPessoa;
import dominio.Usuario;


public class GerenciarConexao {

	
	private static Connection conexao;
	
	public static Connection getConexao() {
		if (conexao == null){
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/condominium?useTimezone=true&serverTimezone=UTC&useSSL=false";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(url, username, password);
			}catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}
	
	public static void main(String args[]){
		System.out.println(">>> print entrando no main");
		Connection conexaoDAO = GerenciarConexao.getConexao();
		List<Usuario> resultado = new ArrayList<Usuario>();
		String sql = "SELECT * FROM Usuario";
		PreparedStatement ps;
		try {
			System.out.println(">>> Entrando no TRY");
			ps = (conexaoDAO).prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("login") + " " + rs.getString("senha") + " " + rs.getInt("tipoID"));
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoID(TipoPessoa.fromInteger(rs.getInt("tipoID")));
				resultado.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
