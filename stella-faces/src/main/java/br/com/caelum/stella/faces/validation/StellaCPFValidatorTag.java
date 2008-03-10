package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a um validador de CPF
 * (StellaCPFValidator).
 * 
 * @author Caires V.
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaCPFValidatorTag extends ValidatorELTag {
	private ValueExpression formatted;

	public StellaCPFValidatorTag() {
		super.setId(StellaCPFValidator.VALIDATOR_ID);
	}

	/**
	 * @return StellaCPFValidator
	 */
	@Override
	protected Validator createValidator() throws JspException {
		StellaCPFValidator validator = new StellaCPFValidator();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		boolean isFormatted = (Boolean) formatted.getValue(elContext);
		validator.setFormatted(isFormatted);
		return validator;
	}

	public void setFormatted(ValueExpression formatted) {
		this.formatted = formatted;
	}

	public void release() {
		super.release();
		this.formatted = null;
	}

}