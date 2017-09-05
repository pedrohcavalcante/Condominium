package dominio;

public class Usuario {
	private String login;
	private String senha;
	private TipoPessoa tipoID;
	
	public Usuario() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoPessoa getTipoID() {
		return tipoID;
	}

	public void setTipoID(TipoPessoa tipoID) {
		this.tipoID = tipoID;
	}
	
	
}
