package br.com.caelum.stella.hibernate.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.caelum.stella.hibernate.validator.CNPJ;
import br.com.caelum.stella.hibernate.validator.CPF;

@Entity
public class Modelo {
	@Id
	@GeneratedValue
	private Long id;
	@CNPJ
	private String CNPJ;
	@CPF
	private String CPF;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cnpj) {
		CNPJ = cnpj;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "(ID:"+this.id+") CPF:" + this.CPF + " CNPJ:" + this.CNPJ;
	}

}
