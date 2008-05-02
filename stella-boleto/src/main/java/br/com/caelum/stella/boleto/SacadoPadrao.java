package br.com.caelum.stella.boleto;

public class SacadoPadrao implements Sacado {
	private String nome;
	private String cpf;
	private String endereco;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	private SacadoPadrao() {
	}
	
	public static SacadoPadrao newSacado() {
		return new SacadoPadrao();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public SacadoPadrao comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public SacadoPadrao comCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public SacadoPadrao comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public SacadoPadrao comCep(String cep) {
		this.cep = cep;
		return this;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public SacadoPadrao comBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public SacadoPadrao comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public String getUf() {
		return this.uf;
	}
	
	public SacadoPadrao comUf(String uf) {
		this.uf = uf;
		return this;
	}
	
}
