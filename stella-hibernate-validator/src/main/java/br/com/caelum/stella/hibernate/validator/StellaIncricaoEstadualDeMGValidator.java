package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.InscricaoEstatudalDeMinasGeraisValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de Inscrição Estadual de Minas
 * Gerais.
 * 
 * @author Leonardo Bessa
 */
public class StellaIncricaoEstadualDeMGValidator implements
		Validator<InscricaoEstadualMG> {
	private InscricaoEstatudalDeMinasGeraisValidator stellaValidator;

	/**
	 * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(InscricaoEstadualMG ie) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				ie);
		stellaValidator = new InscricaoEstatudalDeMinasGeraisValidator(
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
