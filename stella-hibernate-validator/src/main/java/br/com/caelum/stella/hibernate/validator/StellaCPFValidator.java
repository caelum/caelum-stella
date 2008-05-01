package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.CPFValidator;

/**
 * Valida a cadeia gerada através do método {@linkplain #toString()} para
 * verificar se ela está de acordo com o padrão de CPF.
 *
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class StellaCPFValidator implements Validator<CPF> {
    private CPFValidator stellaValidator;

    /**
     * @see org.hibernate.validator.Validator#initialize(java.lang.annotation.Annotation)
     */
    public void initialize(CPF cpf) {
        AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(cpf);
        stellaValidator = new CPFValidator(messageProducer, cpf.formatted());
    }

    /**
     * @see org.hibernate.validator.Validator#isValid(java.lang.Object)
     */
    public boolean isValid(Object o) {
        if (o != null) {
            String cpf = o.toString();
            if (cpf.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.getValidationMessages(cpf).isEmpty();
            }
        } else {
            return true;
        }
    }
}
