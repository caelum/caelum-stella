package br.com.caelum.stella.example.validator;

import br.com.caelum.stella.bean.validation.CPF;

public class Usuario {
    @CPF
    private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
