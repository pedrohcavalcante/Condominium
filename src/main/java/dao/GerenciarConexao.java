package dao;

import java.sql.*;


public class GerenciarConexao {

	
	private static Connection conexao;
	
	public static Connection getConexao() {
		if (conexao == null){
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/condominium";
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(url, username, password);
			}catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}
}
