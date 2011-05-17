package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.TituloEleitoral;
import br.com.caelum.stella.validation.TituloEleitoralValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Título Eleitoral.
 * 
 * @author Leonardo Bessa
 */
public class StellaTituloEleitoralValidator implements
		ConstraintValidator<TituloEleitoral, String> {
	private TituloEleitoralValidator stellaValidator;

	public void initialize(TituloEleitoral tituloEleitoral) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				tituloEleitoral);
		stellaValidator = new TituloEleitoralValidator(messageProducer);
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
