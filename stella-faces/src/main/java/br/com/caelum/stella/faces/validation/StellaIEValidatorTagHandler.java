package br.com.caelum.stella.faces.validation;

import javax.faces.validator.Validator;

import br.com.caelum.stella.type.Estado;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.jsf.ValidateHandler;
import com.sun.facelets.tag.jsf.ValidatorConfig;
/**
 * Produz o Handler que cuida da validação do Facelets, de forma que 
 * o método createValidator, faz uma verificação no atributo da Tag,
 * para que diga, se esta formatado ou não. Após isso retorna o validator.
 * 
 * @author Leonardo Bessa
 *
 */
public class StellaIEValidatorTagHandler extends ValidateHandler{

	private TagAttribute formatted;
	private TagAttribute estado;
	
	@SuppressWarnings("deprecation")
	public StellaIEValidatorTagHandler(TagConfig config) {
		super(config);
			formatted = getAttribute("formatted");
			estado = getAttribute("estado");
	}
	public StellaIEValidatorTagHandler(ValidatorConfig validatorConfig) {
		super(validatorConfig);
		formatted = getAttribute("formatted");
		estado = getAttribute("estado");
	}
	
	@Override
	protected Validator createValidator(FaceletContext ctx) {
		StellaIEValidator validator = new StellaIEValidator();
		validator.setEstado(Estado.valueOf(estado.getValue()));
		if(formatted != null){
			validator.setFormatted(formatted.getBoolean(ctx));
		}else{
			validator.setFormatted(false);
		}
		return validator;
	}
	
	
}
