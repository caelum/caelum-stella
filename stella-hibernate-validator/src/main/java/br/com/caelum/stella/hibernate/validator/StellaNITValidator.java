package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.NITValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de um NIT. O padrão NIT é o
 * mesmo utilizado no PIS, PASEP e o SUS.
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class StellaNITValidator implements Validator<NIT> {
	private NITValidator stellaValidator;

	/**
	 * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
	 */
	public void initialize(NIT nit) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(
				nit);
		stellaValidator = new NITValidator(messageProducer, nit.formatted());
	}

	/**
	 * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
	 */
	public boolean isValid(Object o) {
		if (o != null) {
			String nit = o.toString();
			if (nit.trim().length() == 0) {
				return true;
			} else {
				return stellaValidator.getValidationMessages(nit).isEmpty();
			}
		} else {
			return true;
		}
	}

}
