package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.CNPJValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de CNPJ.
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class StellaCNPJValidator implements Validator<CNPJ> {
	private CNPJValidator stellaValidator;

	/**
	 * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(CNPJ cnpj) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(cnpj);
		stellaValidator = new CNPJValidator(messageProducer, cnpj.formatted());
	}

	/**
	 * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
	 */
	public boolean isValid(Object o) {
		if (o != null) {
			String cnpj = o.toString();
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
