package br.com.caelum.stella.gateway.pagseguro;

import br.com.caelum.stella.gateway.core.DadosComprador;

public class PagSeguroDadosCliente {

	private DadosComprador dadosComprador;
	private String numero;
	private String complemento;
	private String bairro;
	private String ddd;
	private String telefone;
	private String email;
	
	
	public PagSeguroDadosCliente(String cep, String cidade, String endereco,
			String nome, String estado,
			String numero, String complemento, String bairro, String ddd,
			String telefone, String email) {
		super();
		this.dadosComprador = new DadosComprador(cep,cidade,endereco,nome,estado);
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
	}


	public String getNumero() {
		return numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public String getDdd() {
		return ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getEmail() {
		return email;
	}


	public String getCep() {
		return dadosComprador.getCep();
	}


	public String getCidade() {
		return dadosComprador.getCidade();
	}


	public String getEndereco() {
		return dadosComprador.getEndereco();
	}


	public String getEstado() {
		return dadosComprador.getEstado();
	}


	public String getNome() {
		return dadosComprador.getNome();
	}


	public String getPais() {
		return dadosComprador.getPais();
	}
	
	
	
	
}
