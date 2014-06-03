package br.com.caelum.stella.boleto;

import java.io.Serializable;

public class Endereco implements Serializable {
	public String logradouro;
	public String bairro;
	public String cep;
	public String cidade;
	public String uf;

	private Endereco() {
	}

	public Endereco(String logradouro, String bairro, String cep, String cidade, String uf) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public static Endereco novoEndereco() {
		return new Endereco();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Endereco comLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public Endereco comBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Endereco comCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Endereco comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getUf() {
		return uf;
	}

	public Endereco comUf(String uf) {
		this.uf = uf;
		return this;
	}

}