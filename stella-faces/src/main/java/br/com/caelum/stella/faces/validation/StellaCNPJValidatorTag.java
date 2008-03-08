package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a uma StellaCPFValidator class.
 *
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaCNPJValidatorTag extends ValidatorELTag {
    private Boolean formatted = Boolean.FALSE;

    /**
     * @return StellaCNPJValidator
     */
    @Override
    protected Validator createValidator() throws JspException {
        return new StellaCNPJValidator(formatted);
    }

    public Boolean getFormatted() {
        return formatted;
    }

    public void setFormatted(Boolean formatted) {
        this.formatted = formatted;
    }
}
