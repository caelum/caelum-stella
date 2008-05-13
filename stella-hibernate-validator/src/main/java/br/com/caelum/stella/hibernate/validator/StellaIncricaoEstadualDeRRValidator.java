package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.InscricaoEstatudalDeRoraimaValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscrição Estadual de Roraima.
 * 
 * @author Leonardo Bessa
 */
public class StellaIncricaoEstadualDeRRValidator implements
		Validator<InscricaoEstadualRR> {
	private InscricaoEstatudalDeRoraimaValidator stellaValidator;

	/**
	 * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(InscricaoEstadualRR ie) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				ie);
		stellaValidator = new InscricaoEstatudalDeRoraimaValidator(
				messageProducer, ie.formatted());
	}

	/**
	 * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
	 */
	public boolean isValid(Object o) {
		if (o != null) {
			String ie = o.toString();
			if (ie.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.invalidMessagesFor(ie).isEmpty();
			}
		} else {
			return true;
		}
	}
}
