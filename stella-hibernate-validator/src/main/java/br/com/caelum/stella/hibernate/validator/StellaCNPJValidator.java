package br.com.caelum.stella.hibernate.validator;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.validation.CNPJError;
import br.com.caelum.stella.validation.CNPJValidator;


/**
 * @Author Leonardo Bessa
 */
public class StellaCNPJValidator implements Validator<CNPJ> {
    private CNPJValidator stellaValidator;

    public void initialize(CNPJ cpf) {
        AnnotationMessageProducer<CNPJError> messageProducer = new AnnotationMessageProducer<CNPJError>(cpf);
        stellaValidator = new CNPJValidator(messageProducer, cpf.formatted());
    }

    public boolean isValid(Object o) {
        if (o != null) {
            String cnpj = o.toString();
            if (cnpj.trim().length() == 0) {
                return true;
            } else {
                return stellaValidator.validate(cnpj);
            }
        } else {
            return true;
        }
    }
}
