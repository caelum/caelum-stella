package br.com.caelum.stella.gateway.core;

public class DadosComprador {

	private String cep;
	private String cidade;
	private String endereco;
	private String nome;
	private String estado;
	private String pais;
	
	
	
	
	
	public DadosComprador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DadosComprador(String cep, String cidade, String endereco,
			String nome, String estado) {
		super();
		this.cep = cep;
		this.cidade = cidade;
		this.endereco = endereco;
		this.nome = nome;
		this.estado = estado;
	}
	
	
	public DadosComprador(String cep, String cidade, String endereco,
			String nome, String estado, String pais) {
		super();
		this.cep = cep;
		this.cidade = cidade;
		this.endereco = endereco;
		this.nome = nome;
		this.estado = estado;
		this.pais = pais;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	
	
	
}
