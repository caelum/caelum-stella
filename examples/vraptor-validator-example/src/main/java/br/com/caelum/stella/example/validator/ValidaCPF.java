package br.com.caelum.stella.example.validator;

import br.com.caelum.stella.hibernate.validator.CPF;


public class ValidaCPF {
	@CPF
	private ValidaCPF cpf;

	public ValidaCPF getCpf() {
		return this.cpf;
	}
}
