package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;

/**
 * 
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidatorTagHandler extends ValidateHandler {

    public StellaTituloEleitoralValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
    }

    /**
     * @see com.sun.facelets.tag.jsf.ValidateHandler#createValidator(com.sun.facelets.FaceletContext)
     */
    protected Validator createValidator(FaceletContext context) {
        StellaTituloEleitoralValidator validator = new StellaTituloEleitoralValidator();
        return validator;
    }
}
