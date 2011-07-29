package br.com.caelum.stella.faces.component;

import javax.faces.component.html.HtmlInputText;

public abstract class MaskedInput extends HtmlInputText {

	protected static final String DEFAULT_RENDERER = MaskedInputRenderer.class.getName();
	protected static final char DEFAULT_PLACE_HOLDER = '_';
	
	public MaskedInput(){
		setRendererType(DEFAULT_RENDERER);
	}

	protected enum PropertyKeys {
		MASK_FORMAT, PLACE_HOLDER;
	}

	public String getMaskFormat() {
		return (String) getStateHelper().eval(PropertyKeys.MASK_FORMAT, this.getDefaultMaskFormat());
	}

	public void setMaskFormat(String maskFormat) {
		getStateHelper().put(PropertyKeys.MASK_FORMAT, maskFormat);
	}

	public char getPlaceHolder() {
		return  (Character) getStateHelper().eval(PropertyKeys.PLACE_HOLDER, this.getDefaultPlaceHolder());
	}

	public void setPlaceHolder(char placeHolder) {
		getStateHelper().put(PropertyKeys.PLACE_HOLDER, placeHolder);
	}
	
	public char getDefaultPlaceHolder() {
		return DEFAULT_PLACE_HOLDER;
	}

	public abstract String getDefaultMaskFormat();
	
	public abstract String getDefaultClass();


}