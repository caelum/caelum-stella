package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

@SuppressWarnings("serial")
public class StellaIEValidatorTag extends ValidatorELTag {
	private boolean formatted;
	private String estadoComponentId;

	public StellaIEValidatorTag() {
		super.setId(StellaIEValidator.VALIDATOR_ID);
	}

	@Override
	protected Validator createValidator() throws JspException {
		StellaIEValidator validator = new StellaIEValidator();
		if (estadoComponentId!=null){
		    validator.setEstadoComponentId(estadoComponentId);
		}
		validator.setFormatted(formatted);
		return validator;
	}

	public void setFormatted(ValueExpression formatted) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		this.formatted = (Boolean) formatted.getValue(elContext);
	}
	
	public void setEstadoId(ValueExpression estadoId) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            this.estadoComponentId = (String) estadoId.getValue(elContext);
    }

	public void release() {
		super.release();
		this.formatted = false;
	}

}
