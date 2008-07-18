package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

import br.com.caelum.stella.type.Estado;

@SuppressWarnings("serial")
public class StellaIEValidatorTag extends ValidatorELTag {
	private boolean formatted;
	private String estado;

	public StellaIEValidatorTag() {
		super.setId(StellaIEValidator.VALIDATOR_ID);
	}

	@Override
	protected Validator createValidator() throws JspException {
		StellaIEValidator validator = new StellaIEValidator();
		if (estado!=null){
		    validator.setEstado(Estado.valueOf(estado));
		}
		validator.setFormatted(formatted);
		return validator;
	}

	public void setFormatted(ValueExpression formatted) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		this.formatted = (Boolean) formatted.getValue(elContext);
	}
	
	public void setEstado(ValueExpression estado) {
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            this.estado = (String) estado.getValue(elContext);
    }

	public void release() {
		super.release();
		this.formatted = false;
	}

}
