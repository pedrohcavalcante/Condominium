package dao;

import java.util.List;

import dominio.Sindico;
import dominio.TipoPessoa;

public class SindicoDAO implements AllDAO<Sindico>{

	@Override
	public List<Sindico> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sindico buscar(Sindico elemento) {
		
		Sindico sindico = new Sindico();
		
		sindico.setId(1);
		sindico.setApartamento("303");
		sindico.setBloco("23");
		sindico.setCPF("09133979464");
		sindico.setEmail("pedrohbcavalcante@outlook.com");
		sindico.setNome("Pedro");
		sindico.setLogin("admin");
		sindico.setSenha("admin");
		sindico.setTelefone("96064412");
		sindico.setTipoID(TipoPessoa.sindico);
		sindico.setVinculo("sindico");
		
		return sindico;
	}
	
	public Sindico buscar(String elemento) {
		Sindico sindico = new Sindico();
		
		sindico.setId(1);
		sindico.setApartamento("303");
		sindico.setBloco("23");
		sindico.setCPF("09133979464");
		sindico.setEmail("pedrohbcavalcante@outlook.com");
		sindico.setNome("Pedro");
		sindico.setLogin("admin");
		sindico.setSenha("admin");
		sindico.setTelefone("96064412");
		sindico.setTipoID(TipoPessoa.sindico);
		sindico.setVinculo("sindico");
		
		return sindico;
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
