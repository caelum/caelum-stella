package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validator.CNPJError;
import br.com.caelum.stella.validator.CNPJValidator;


/**
 * @Author Leonardo Bessa
 */
public class StellaCNPJValidator implements Validator<CNPJ> {
    private CNPJValidator stellaValidator;

    public void initialize(CNPJ cpf) {
        AnnotationMessageProducer<CNPJError> messageProducer = new AnnotationMessageProducer<CNPJError>(cpf);
        stellaValidator = new CNPJValidator(messageProducer);
    }

    public boolean isValid(Object o) {
        if (o instanceof String) {
            return stellaValidator.validate((String) o);
        } else {
            return false;
        }
    }

}
