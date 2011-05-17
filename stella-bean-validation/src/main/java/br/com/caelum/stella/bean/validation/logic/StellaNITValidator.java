package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.NIT;
import br.com.caelum.stella.validation.NITValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de um NIT. O padrão NIT é o
 * mesmo utilizado no PIS, PASEP e o SUS.
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class StellaNITValidator implements ConstraintValidator<NIT, String> {
	private NITValidator stellaValidator;

	public void initialize(NIT nit) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				nit);
		stellaValidator = new NITValidator(messageProducer, nit.formatted());
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null) {
			if (value.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.invalidMessagesFor(value).isEmpty();
			}
		} else {
			return true;
		}
	}

}
