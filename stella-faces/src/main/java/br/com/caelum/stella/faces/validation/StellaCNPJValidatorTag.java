package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a um validador de CNPJ
 * (StellaCNPJValidator).
 * 
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaCNPJValidatorTag extends ValidatorELTag {
	private ValueExpression formatted;

	public StellaCNPJValidatorTag() {
		super.setId(StellaCNPJValidator.VALIDATOR_ID);
	}

	/**
	 * @return StellaCNPJValidator
	 */
	@Override
	protected Validator createValidator() throws JspException {
		StellaCNPJValidator validator = new StellaCNPJValidator();
		try {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			boolean isFormatted = (Boolean) formatted.getValue(elContext);
			validator.setFormatted(isFormatted);
		} catch (NullPointerException e) {
			//TODO:Tratar essa Expection (causada pela falta de contexto) ou mudar o teste unitario.
		}
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
