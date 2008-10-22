package br.com.caelum.stella.faces.validation;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

@SuppressWarnings("serial")
public class StellaNITValidatorTag extends ValidatorELTag {
    private boolean formatted;

    public StellaNITValidatorTag() {
        super.setId(StellaNITValidator.VALIDATOR_ID);
    }

    @Override
    protected Validator createValidator() throws JspException {
        StellaNITValidator validator = new StellaNITValidator();
        validator.setFormatted(formatted);
        return validator;
    }

    public void setFormatted(ValueExpression formatted) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        this.formatted = (Boolean) formatted.getValue(elContext);
    }

    public void release() {
        super.release();
        this.formatted = false;
    }

}
