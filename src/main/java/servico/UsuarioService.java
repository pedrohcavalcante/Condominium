package servico;

import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

public class UsuarioService implements InterfaceServico<Usuario>{
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService(){
		usuarioDAO = new UsuarioDAO();
	}
	@Override 
	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
	@Override 
	public Usuario buscar(Usuario elemento) {
		return usuarioDAO.buscar(elemento);
	}
	@Override 
	public void inserir(Usuario novo) {
		usuarioDAO.inserir(novo);
		
	}
	@Override
	public void atualizar(Usuario elemento) {
		usuarioDAO.atualizar(elemento);
		
	}
	@Override 
	public void remover(Usuario elemento) {
		usuarioDAO.remover(elemento);
		
	}

	

}
