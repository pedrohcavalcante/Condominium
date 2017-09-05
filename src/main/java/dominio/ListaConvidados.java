package dominio;

public class ListaConvidados {
	
	private int idLista;
	private int idMorador;
	private String nomePessoa;
	
	public int getIdLista() {
		return idLista;
	}
	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}
	public int getIdMorador() {
		return idMorador;
	}
	public void setIdMorador(int idMorador) {
		this.idMorador = idMorador;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
}
