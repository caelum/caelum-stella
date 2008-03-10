package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

public class StellaNITValidatorTag extends ValidatorELTag {
	private ValueExpression formatted;

	public StellaNITValidatorTag() {
		super.setId(StellaNITValidator.VALIDATOR_ID);
	}

	@Override
	protected Validator createValidator() throws JspException {
		StellaNITValidator validator = new StellaNITValidator();
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
