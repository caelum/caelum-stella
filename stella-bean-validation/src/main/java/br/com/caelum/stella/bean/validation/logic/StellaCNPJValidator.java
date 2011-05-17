package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.validation.CNPJValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de CNPJ.
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @author David Paniz
 */
public class StellaCNPJValidator implements ConstraintValidator<CNPJ, String> {
	private CNPJValidator stellaValidator;

	public void initialize(CNPJ cnpj) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(cnpj);
		stellaValidator = new CNPJValidator(messageProducer, cnpj.formatted());
	}

	public boolean isValid(String cnpj, ConstraintValidatorContext context) {
		if (cnpj != null) {
			if (cnpj.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.invalidMessagesFor(cnpj).isEmpty();
			}
		} else {
			return true;
		}
	}
}
