package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;

/**
 * Produz o Handler que cuida da validação do Facelets, de forma que o método
 * createValidator, faz uma verificação no atributo da Tag, para que diga, se
 * esta formatado ou não. Após isso retorna o validator.
 * 
 * @author Caires
 * 
 */
public class StellaNITValidatorTagHandler extends ValidateHandler {

    private TagAttribute formatted;

    @SuppressWarnings("deprecation")
    public StellaNITValidatorTagHandler(TagConfig config) {
        super(config);
        formatted = getAttribute("formatted");
    }

    public StellaNITValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
        formatted = getAttribute("formatted");
    }

    @Override
    protected Validator createValidator(FaceletContext ctx) {
        StellaNITValidator validator = new StellaNITValidator();
        if (formatted != null) {
            validator.setFormatted(formatted.getBoolean(ctx));
        } else {
            validator.setFormatted(false);
        }
        return validator;
    }

}
