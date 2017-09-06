package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.primefaces.model.diagram.Connection;

import dominio.TipoPessoa;
import dominio.Usuario;
import dao.GerenciarConexao;

public class UsuarioDAO implements InterfaceDAO<Usuario>{

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> resultado = new ArrayList<Usuario>();
		Connection conexaoDAO = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario";
		PreparedStatement ps;
		try {
			ps = (conexaoDAO).prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoID(TipoPessoa.fromInteger(rs.getInt("tipoId")));
				resultado.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Usuario buscar(Usuario elemento) {
		Usuario resultado = new Usuario();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario WHERE matricula='"+elemento.getLogin()+"';";
		try {
			PreparedStatement ps = (con).prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setLogin(rs.getString("login"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setTipoID(TipoPessoa.fromInteger(rs.getInt("tipoId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public Usuario buscar(String login){
		Usuario resultado = new Usuario();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Usuario WHERE matricula='"+login+"';";
		try {
			PreparedStatement ps = (con).prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setLogin(rs.getString("login"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setTipoID(TipoPessoa.fromInteger(rs.getInt("tipoId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Usuario novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Usuario VALUES (?, ?)";
		try {
			PreparedStatement ps = (con).prepareStatement(sql);
			ps.setString(1, novo.getLogin());
			ps.setString(2, novo.getSenha());
			ps.setInt(3, novo.getTipoID().ordinal());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

}
