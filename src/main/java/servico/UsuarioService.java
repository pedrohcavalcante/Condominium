package servico;

import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

public class UsuarioService implements InterfaceServico<Usuario>{
	
	@Inject
	protected UsuarioDAO usuarioDao;
	
	public UsuarioService(){
		usuarioDao = new UsuarioDAO();
	}

	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuarioDao.buscarTodos();
	}

	@Override
	public Usuario buscar(Usuario elemento) {
		// TODO Auto-generated method stub
		return usuarioDao.buscar(elemento);
	}

	@Override
	public void inserir(Usuario novo) {
		// TODO Auto-generated method stub
		usuarioDao.inserir(novo);
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
