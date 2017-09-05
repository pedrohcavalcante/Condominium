package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dominio.Pessoa;
import dominio.Sindico;
import dominio.TipoPessoa;
import dominio.Usuario;
import servico.PessoaService;
import servico.SindicoService;
import servico.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	private Usuario user;
	private List<Usuario> listaUser;
	private UsuarioService UserService;
	private Usuario usuarioLogado;
	private Pessoa morador;
	private Sindico administrador;
	
	@Inject
	private PessoaService pessoaService;
	
	@Inject 
	private SindicoService administradorService;
	
	public UsuarioMBean(){
		user = new Usuario();
		listaUser = new ArrayList<Usuario>();
		UserService = new UsuarioService();	
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<Usuario> listaUser) {
		this.listaUser = listaUser;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Pessoa getMorador() {
		return morador;
	}

	public void setMorador(Pessoa morador) {
		this.morador = morador;
	}

	public Sindico getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Sindico administrador) {
		this.administrador = administrador;
	}
	
	
	
	

}
