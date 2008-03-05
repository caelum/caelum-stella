package br.com.caelum.stella.example.validator;

import br.com.caelum.stella.hibernate.validator.CPF;

public class Usuario {
	@CPF
	private String cpf;

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
