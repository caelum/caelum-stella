package br.com.caelum.stella.faces.component;

import javax.faces.component.FacesComponent;

import br.com.caelum.stella.faces.validation.StellaCPFValidator;

@FacesComponent("br.com.caelum.stella.faces.component.InputCPF")
public class InputCPF extends MaskedInput {

	private static final String DEFAULT_CLASS = "stella-inputCpf";
	private static final String DEFAULT_MASK = "999.999.999-99";
	
	public InputCPF() {
		addValidator(new StellaCPFValidator(true));
	}

	@Override
	public String getDefaultMaskFormat() {
		return DEFAULT_MASK;
	}

	@Override
	public String getDefaultClass() {
		return DEFAULT_CLASS;
	}

}
