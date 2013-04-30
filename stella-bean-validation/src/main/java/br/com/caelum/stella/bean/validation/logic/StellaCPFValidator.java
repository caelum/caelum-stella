package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.CPF;
import br.com.caelum.stella.validation.CPFValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de CPF.
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 * @author David Paniz
 */
public class StellaCPFValidator implements ConstraintValidator<CPF, String> {
	private CPFValidator stellaValidator;

	@Override
	public void initialize(CPF cpf) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(cpf);
		stellaValidator = new CPFValidator(messageProducer, cpf.formatted(),cpf.ignoreRepeated());
	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (cpf != null) {
			if (cpf.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.invalidMessagesFor(cpf).isEmpty();
			}
		} else {
			return true;
		}
	}
}
