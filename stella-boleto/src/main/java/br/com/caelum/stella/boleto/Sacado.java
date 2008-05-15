package br.com.caelum.stella.boleto;

/**
 * Interface com métodos do sacado<br/> Sacado é a pessoa/empresa que irá pagar
 * pelo boleto gerado.
 * 
 * @author Cauê Guerra
 * 
 */
public class Sacado {
	private String nome;
	private String cpf;
	private String endereco;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;

	private Sacado() {
	}

	public static Sacado newSacado() {
		return new Sacado();
	}

	public String getNome() {
		return this.nome;
	}

	public Sacado comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Sacado comCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public Sacado comEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getCep() {
		return this.cep;
	}

	public Sacado comCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getBairro() {
		return this.bairro;
	}

	public Sacado comBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return this.cidade;
	}

	public Sacado comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getUf() {
		return this.uf;
	}

	public Sacado comUf(String uf) {
		this.uf = uf;
		return this;
	}

}
