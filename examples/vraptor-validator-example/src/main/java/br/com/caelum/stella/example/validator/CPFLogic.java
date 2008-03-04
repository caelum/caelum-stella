package br.com.caelum.stella.example.validator;

import org.hibernate.validator.Valid;
import org.vraptor.annotations.Component;
import org.vraptor.annotations.Parameter;
import org.vraptor.plugin.hibernate.Validate;

@Component
public class CPFLogic {

	@Parameter
	@Valid
	private ValidaCPF validaCPF = new ValidaCPF();

	
	@Validate(fields = "validaCPF")
	public void valida(ValidaCPF validaCPF) {
		System.out.println("validou");
	}

}