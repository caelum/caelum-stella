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
 * @author Leonardo Bessa
 * 
 */
public class StellaIEValidatorTagHandler extends ValidateHandler {

    private TagAttribute formatted;
    private TagAttribute estadoId;

    @SuppressWarnings("deprecation")
    public StellaIEValidatorTagHandler(TagConfig config) {
        super(config);
        this.formatted = getAttribute("formatted");
        this.estadoId = getAttribute("estadoId");
    }

    public StellaIEValidatorTagHandler(ValidatorConfig validatorConfig) {
        super(validatorConfig);
        this.formatted = getAttribute("formatted");
        this.estadoId = getAttribute("estadoId");
    }

    @Override
    protected Validator createValidator(FaceletContext ctx) {
        StellaIEValidator validator = new StellaIEValidator();
        validator.setEstadoComponentId(estadoId.getValue());
        if (formatted != null) {
            validator.setFormatted(formatted.getBoolean(ctx));
        } else {
            validator.setFormatted(false);
        }
        return validator;
    }

}
