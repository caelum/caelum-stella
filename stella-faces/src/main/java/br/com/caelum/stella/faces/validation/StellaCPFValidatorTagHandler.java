package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;

public class StellaCPFValidatorTagHandler extends ValidateHandler {

    private final TagAttribute formatted;

    @SuppressWarnings("deprecation")
    public StellaCPFValidatorTagHandler(TagConfig config) {
        super(config);
        formatted = getAttribute("formatted");
    }

    public StellaCPFValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
        formatted = getAttribute("formatted");
    }

    protected Validator createValidator(FaceletContext context) {
        StellaCPFValidator validator = new StellaCPFValidator();
        if (formatted != null) {
            validator.setFormatted(formatted.getBoolean(context));
        } else {
            validator.setFormatted(false);
        }
        return validator;
    }
}
