package br.com.caelum.stella.hibernate.example.persistence;

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
	private String cnpj;
	@CPF
	private String cpf;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "(ID:"+this.id+") CPF:" + this.cpf + " CNPJ:" + this.cnpj;
	}

}
