package br.com.caelum.stella.faces.validation;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;

@FacesComponent("br.com.caelum.stella.faces.validation.InputCPF")
public class InputCPF extends UIInput {

	public InputCPF() {
		addValidator(new StellaCPFValidator());
	}
	
}
