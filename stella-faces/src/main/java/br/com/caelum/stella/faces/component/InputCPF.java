package br.com.caelum.stella.faces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlInputText;

import br.com.caelum.stella.faces.validation.StellaCPFValidator;

@FacesComponent("br.com.caelum.stella.faces.component.InputCPF")
public class InputCPF extends HtmlInputText {

	private static final String DEFAULT_RENDERER = "br.com.caelum.stella.faces.component.InputCPFRenderer";
	public static final String DEFAULT_CLASS = "stella-inputCpf";
	public final String DEFAULT_MASK = "999.999.999-99";
	public final char DEFAULT_PLACE_HOLDER = '_';
	
	protected enum PropertyKeys {
		MASK, PLACE_HOLDER;
	}

	public InputCPF() {
		addValidator(new StellaCPFValidator(true));
		setRendererType(DEFAULT_RENDERER);
	}

	public String getMask() {
		return (String) getStateHelper().eval(PropertyKeys.MASK, DEFAULT_MASK);
	}

	public void setMask(String mask) {
		getStateHelper().put(PropertyKeys.MASK, mask);
	}

	public char getPlaceHolder() {
		return  (Character) getStateHelper().eval(PropertyKeys.PLACE_HOLDER, DEFAULT_PLACE_HOLDER);
	}

	public void setPlaceHolder(char placeHolder) {
		getStateHelper().put(PropertyKeys.PLACE_HOLDER, placeHolder);
	}

}
