package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

/**
 * Associa um TLD (Descritor de Biblioteca de Tag) a um validador de Titulo Eleitoral
 * (StellaTituloEleitoralValidator).
 * 
 * @author Leonardo Bessa
 */
@SuppressWarnings("serial")
public class StellaTituloEleitoralValidatorTag extends ValidatorELTag {

    public StellaTituloEleitoralValidatorTag() {
        super.setId(StellaTituloEleitoralValidator.VALIDATOR_ID);
    }

    /**
     * @return StellaTituloEleitoralValidator
     */
    @Override
    protected Validator createValidator() throws JspException {
        StellaTituloEleitoralValidator validator = new StellaTituloEleitoralValidator();
        return validator;
    }

}
