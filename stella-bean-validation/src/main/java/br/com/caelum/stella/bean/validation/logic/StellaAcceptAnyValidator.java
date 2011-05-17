package br.com.caelum.stella.bean.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.AcceptAny;
import br.com.caelum.stella.validation.AcceptAnyValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de qualquer um dos documentos
 * passados como parametro.
 * 
 * @author Leonardo Bessa
 * @author David Paniz
 * 
 */
public class StellaAcceptAnyValidator implements ConstraintValidator<AcceptAny, String> {
	private AcceptAnyValidator stellaValidator;

	public void initialize(AcceptAny annotation) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(annotation);
		stellaValidator = new AcceptAnyValidator(messageProducer, annotation.formatted(), annotation.documentos());
	}

	public boolean isValid(String document, ConstraintValidatorContext context) {
		if (document != null) {
			if (document.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.invalidMessagesFor(document).isEmpty();
			}
		} else {
			return true;
		}
	}
}
