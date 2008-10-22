package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;

/**
 * 
 * @author Leonardo Bessa
 */
public class StellaCNPJValidatorTagHandler extends ValidateHandler {

    private final TagAttribute formatted;

    @SuppressWarnings("deprecation")
    public StellaCNPJValidatorTagHandler(TagConfig config) {
        super(config);
        formatted = getAttribute("formatted");
    }

    public StellaCNPJValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
        formatted = getAttribute("formatted");
    }

    /**
     * @see com.sun.facelets.tag.jsf.ValidateHandler#createValidator(com.sun.facelets.FaceletContext)
     */
    protected Validator createValidator(FaceletContext context) {
        StellaCNPJValidator validator = new StellaCNPJValidator();
        if (formatted != null) {
            validator.setFormatted(formatted.getBoolean(context));
        } else {
            validator.setFormatted(false);
        }
        return validator;
    }
}
