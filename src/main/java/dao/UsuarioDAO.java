package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.TipoPessoa;
import dominio.Usuario;
import dao.GerenciadorConexao;

public class UsuarioDAO implements AllDAO<Usuario>{
	
	private List<Usuario> resultadoConsulta;
	//private Connection conexaoBanco;
	//private ResultSet resultados_consulta;
	Usuario getInfo;

	public List<Usuario> buscarTodos() {
		//resultadoConsulta = new ArrayList<Usuario>();
		//conexaoBanco = GerenciadorConexao.getConexao();
		//String seleciona_todos_usuarios = "SELECT * FROM USUARIO";
		//try {
			//PreparedStatement query = conexaoBanco.prepareStatement(seleciona_todos_usuarios);
			//resultados_consulta = query.executeQuery();
			/*while (resultados_consulta.next()){
				getInfo = new Usuario();
				getInfo.setLogin(resultados_consulta.getString("login"));
				getInfo.setSenha(resultados_consulta.getString("senha"));
				getInfo.setID(TipoPessoa.fromInteger(resultados_consulta.getInt("tipoID")));
				resultadoConsulta.add(getInfo);
			}*/
			
		//} catch (SQLException e) {
			getInfo = new Usuario();
			resultadoConsulta = new ArrayList<Usuario>();
			getInfo.setLogin("admin");
			getInfo.setSenha("admin");
			getInfo.setID(TipoPessoa.sindico);
			resultadoConsulta.add(getInfo);
			//e.printStackTrace();
		//}
		return resultadoConsulta;
	}

	public Usuario buscar(Usuario elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Usuario novo) {
		// TODO Auto-generated method stub
		
	}

	public void atualizar(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

	public void remover(Usuario elemento) {
		// TODO Auto-generated method stub
		
	}

}
