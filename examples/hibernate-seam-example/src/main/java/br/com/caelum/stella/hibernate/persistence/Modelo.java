package br.com.caelum.stella.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.caelum.stella.hibernate.validator.CNPJ;
import br.com.caelum.stella.hibernate.validator.CPF;

@SuppressWarnings("serial")
@Entity
@Name("modelo")                                                                            
@Scope(ScopeType.SESSION) 
public class Modelo implements Serializable {
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
