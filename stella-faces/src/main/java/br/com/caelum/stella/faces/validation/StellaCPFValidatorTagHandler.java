package br.com.caelum.stella.faces.validation;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;

import javax.faces.validator.Validator;

public class StellaCPFValidatorTagHandler extends ValidateHandler {
    private final TagAttribute formatted;

    public StellaCPFValidatorTagHandler(TagConfig tagConfig) {
        super(tagConfig);
        formatted = getAttribute("formatted");
    }

    public StellaCPFValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
        formatted = getAttribute("formatted");
    }

    protected Validator createValidator(FaceletContext context) {
        if (formatted != null) {
            return new StellaCPFValidator(formatted.getBoolean(context));
        } else {
            return new StellaCPFValidator();
        }
    }
}
