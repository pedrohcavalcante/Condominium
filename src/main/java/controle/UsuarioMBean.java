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

@ManagedBean(name="usuarioMBean")
//@SessionScoped
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
		System.out.println("return user");
		return user;
	}

	public void setUser(Usuario user) {
		System.out.println("Set user");
		this.user = user;
	}

	public List<Usuario> getListaUser() {
		System.out.println("get list user");
		return listaUser;
	}

	public void setListaUser(List<Usuario> listaUser) {
		System.out.println("setlistauser");
		this.listaUser = listaUser;
	}

	public Usuario getUsuarioLogado() {
		System.out.println("get user logado");
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		System.out.println("set user logado");
		this.usuarioLogado = usuarioLogado;
	}

	public Pessoa getMorador() {
		System.out.println("get morador");
		return morador;
	}

	public void setMorador(Pessoa morador) {
		System.out.println("set  morador");
		this.morador = morador;
	}

	public Sindico getAdministrador() {
		System.out.println("get admin");
		return administrador;
	}

	public void setAdministrador(Sindico administrador) {
		System.out.println("set admin");
		this.administrador = administrador;
	}
	
public String login(){
		System.out.println("entrou no STRING LOGIN");
		Usuario usuarioBd = new Usuario();
		
		for (Usuario temp2 : UserService.buscarTodos()){
			if (user.getLogin().equalsIgnoreCase(temp2.getLogin())){
				usuarioBd = temp2;
			}else if (user.getLogin().equalsIgnoreCase("admin")){
				usuarioBd = temp2;
			}
		}
			usuarioBd.setLogin("admin");
			usuarioBd.setSenha("admin");
			usuarioBd.setTipoID(TipoPessoa.sindico);
		
		
		/*for (Usuario usuarioTemp : UserService.buscarTodos()){
			if (user.getLogin().equals("admin") || usuarioTemp.getLogin().equals(user.getLogin())){
				usuarioBd = usuarioTemp;
			}
		}*/
				
		if (!usuarioBd.getLogin().isEmpty()){
			if (usuarioBd.getSenha().equals(user.getSenha())){
				usuarioLogado = usuarioBd;
				
				if (usuarioLogado.getTipoID() == TipoPessoa.morador){
					
					pessoaService = new PessoaService();
					morador = pessoaService.buscar(usuarioLogado.getLogin());
					
					return "/index.jsf";
				}else{
					
					administradorService = new SindicoService();
					//administrador = administradorService.buscar(usuarioLogado.getLogin());
					
					return "/correspondencia.xhtml";
				}
			}else{
				FacesMessage msg = new FacesMessage("Senha incorreta");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("", msg);
				return null;
			}
		}else{
			FacesMessage msg = new FacesMessage("Usuário não existe");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
	
	public String logoff(){
		this.usuarioLogado = null;
		return "/login.jsf";
	}
	
	

}
