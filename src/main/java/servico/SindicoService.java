package servico;

import java.util.List;

import javax.inject.Inject;

import dao.SindicoDAO;
import dominio.Sindico;

public class SindicoService implements InterfaceServico<Sindico>{
	
	@Inject
	private SindicoDAO sindicoDAO;
	
	public SindicoService() {
		sindicoDAO = new SindicoDAO();
	}

	@Override
	public List buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sindico buscar(Sindico elemento) {
		// TODO Auto-generated method stub
		return sindicoDAO.buscar(elemento);
	}
	
	public Sindico buscar(String elemento) {
		return sindicoDAO.buscar(elemento);
	}

	@Override
	public void inserir(Sindico novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Sindico elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Sindico elemento) {
		// TODO Auto-generated method stub
		
	}


}
