package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a um validador de uma
 * Inscrição Estadual de São Paulo (StellaIESPValidator).
 * 
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaIESPValidatorTag extends ValidatorELTag {
	private boolean formatted;

	public StellaIESPValidatorTag() {
		super.setId(StellaIESPValidator.VALIDATOR_ID);
	}

	/**
	 * @return StellaCNPJValidator
	 */
	@Override
	protected Validator createValidator() throws JspException {
		StellaIESPValidator validator = new StellaIESPValidator();
		validator.setFormatted(this.formatted);
		return validator;
	}

	/**
	 * @see StellaCNPJValidator#setFormatted(boolean)
	 */
	public void setFormatted(ValueExpression formatted) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		this.formatted = (Boolean) formatted.getValue(elContext);
	}

	@Override
	public void release() {
		super.release();
		this.formatted = false;
	}
}
