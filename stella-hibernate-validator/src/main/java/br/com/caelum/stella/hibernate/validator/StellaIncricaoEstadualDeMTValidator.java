package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.InscricaoEstatudalDeMatoGrossoValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscrição Estadual de Mato
 * Grosso.
 * 
 * @author Leonardo Bessa
 */
public class StellaIncricaoEstadualDeMTValidator implements
		Validator<InscricaoEstadualMT> {
	private InscricaoEstatudalDeMatoGrossoValidator stellaValidator;

	/**
	 * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(InscricaoEstadualMT ie) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				ie);
		stellaValidator = new InscricaoEstatudalDeMatoGrossoValidator(
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
