package br.com.caelum.stella.hibernate.validator;

import br.com.caelum.stella.validation.CPFError;
import br.com.caelum.stella.validation.CPFValidator;
import org.hibernate.validator.Validator;

/**
 * Will use the toString() value for validation
 *
 * @author Fabio Kung
 */
public class StellaCPFValidator implements Validator<CPF> {
    private CPFValidator stellaValidator;

    public void initialize(CPF cpf) {
        AnnotationMessageProducer<CPFError> messageProducer = new AnnotationMessageProducer<CPFError>(cpf);
        stellaValidator = new CPFValidator(messageProducer, cpf.formatted());
    }

    public boolean isValid(Object o) {
        if (o != null) {
            String cpf = o.toString();
            if (cpf.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.validate(cpf);
            }
        } else {
            return true;
        }
    }
}
