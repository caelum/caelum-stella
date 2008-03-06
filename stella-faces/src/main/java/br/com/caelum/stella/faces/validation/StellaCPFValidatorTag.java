package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * This class associates a TLD with validator on StellaCPFValidator class.
 *
 * @author Caires V.
 */
public class StellaCPFValidatorTag extends ValidatorELTag {
    private Boolean formatted = Boolean.FALSE;

    /**
     * Creates a new validator, after that return validate method on
     * StellaCPFValidator.
     */
    @Override
    protected Validator createValidator() throws JspException {
        return new StellaCPFValidator(formatted);
    }

    public Boolean getFormatted() {
        return formatted;
    }

    public void setFormatted(Boolean formatted) {
        this.formatted = formatted;
    }
}
