package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dominio.Morador;
import dominio.Sindico;
import dominio.TipoPessoa;
import dominio.Usuario;
import servico.MoradorService;
import servico.SindicoService;
import servico.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	private Usuario loginUsuario;
	private List<Usuario> listUsuario;
	private UsuarioService serviceUsuario;
	//===================================
	private Usuario usuarioLogado;
	private Morador morador;
	private Sindico sindico;
	//===================================
	@Inject
	private MoradorService moradorService;
	
	@Inject
	private SindicoService sindicoService;
	
	
	public UsuarioMBean(){
		loginUsuario = new Usuario();
		listUsuario = new ArrayList<Usuario>();
		serviceUsuario = new UsuarioService();
	}


	public Usuario getLoginUsuario() {
		return loginUsuario;
	}


	public void setLoginUsuario(Usuario loginUsuario) {
		this.loginUsuario = loginUsuario;
	}


	public List<Usuario> getListUsuario() {
		return listUsuario;
	}


	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}


/*	public UsuarioService getServiceUsuario() {
		return serviceUsuario;
	}


	public void setServiceUsuario(UsuarioService serviceUsuario) {
		this.serviceUsuario = serviceUsuario;
	}*/


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}


	public Morador getMorador() {
		return morador;
	}


	public void setMorador(Morador morador) {
		this.morador = morador;
	}


	public Sindico getSindico() {
		return sindico;
	}


	public void setSindico(Sindico sindico) {
		this.sindico = sindico;
	}
	
	public String login(){
		Usuario getUsuarioBanco = new Usuario();
		
		// Verificar se login passado no xhtml estÃ¡ cadastrado no banco de dados. 
		
		for (Usuario temporario : serviceUsuario.buscarTodos()){
			if (temporario.getLogin().equals(loginUsuario.getLogin())){
				getUsuarioBanco = temporario;
				break;
			}
		}
		/*for (Usuario temporario : serviceUsuario.buscarTodos()){
			if (temporario.getLogin() == loginUsuario.getLogin()){
				getUsuarioBanco = temporario;
			}
		}*/
		
		if (getUsuarioBanco.getLogin().isEmpty()){
			System.out.println("Login nao encontrado");
		}else{
			if (getUsuarioBanco.getSenha().equalsIgnoreCase((loginUsuario.getSenha()))){
				System.out.println("Senha bate: " + getUsuarioBanco.getSenha() + " " + loginUsuario.getSenha());
				usuarioLogado = getUsuarioBanco;
				
				if (usuarioLogado.getTipoID() == TipoPessoa.sindico){
					sindico = new Sindico();
					sindicoService = new SindicoService();
					sindico = sindicoService.buscar(usuarioLogado.getLogin());
					try {
						FacesContext.getCurrentInstance().getExternalContext().redirect("sindico.xhtml");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//return "/sindico.xhtml";
				}else{
					morador = new Morador();
					return "/morador.xhtml";
				}
			}
		}
		return null;
	}

}
