package dominio;

public class Pessoa {

 private String nome;
 private String cpf;
 private String bloco;
 private String apartamento;
 private String vinculo;
 private String telefone;
 private int id;
 private String email;
 
 public Pessoa(){
  
 }
 public String getNome() {
  return nome;
 }
 public void setNome(String nome) {
  this.nome = nome;
 }
 public String getCpf() {
  return cpf;
 }
 public void setCpf(String cpf) {
  this.cpf = cpf;
 }
 public String getBloco() {
  return bloco;
 }
 public void setBloco(String bloco) {
  this.bloco = bloco;
 }
 public String getApartamento() {
  return apartamento;
 }
 public void setApartamento(String apartamento) {
  this.apartamento = apartamento;
 }
 public String getVinculo() {
  return vinculo;
 }
 public void setVinculo(String vinculo) {
  this.vinculo = vinculo;
 }
 public String getTelefone() {
  return telefone;
 }
 public void setTelefone(String telefone) {
  this.telefone = telefone;
 }
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
}